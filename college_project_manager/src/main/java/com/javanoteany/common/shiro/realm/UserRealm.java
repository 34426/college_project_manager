package com.javanoteany.common.shiro.realm;

import com.javanoteany.common.constant.UserType;
import com.javanoteany.user.dto.LoginUserDto;
import com.javanoteany.user.dto.SecurityUserDto;
import com.javanoteany.user.entity.Permission;
import com.javanoteany.user.entity.Role;
import com.javanoteany.user.service.IPermissionService;
import com.javanoteany.user.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    @Autowired
    private IPermissionService permissionService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        LoginUserDto loginUserDto = (LoginUserDto) principalCollection.getPrimaryPrincipal();
        SecurityUserDto userDto = loginUserDto.getSecurityUserDto();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //如果用户type为admin则拥有所有权限
        if(userDto.getType().equals(UserType.SUPER_ADMIN.getCode())){
            simpleAuthorizationInfo.addStringPermission("*:*");
        }else {
            //查询用户的权限缓存起来
            simpleAuthorizationInfo.setStringPermissions(loginUserDto.getPerCodes());
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 登陆认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        SimpleAuthenticationInfo simpleAuthenticationInfo = null;
        Set<String> perCode = new HashSet<>();
        try {
            String loginName = (String) token.getPrincipal();
            String password = new String((char[])token.getCredentials());
            SecurityUserDto user = userService.login(loginName,password);
            //查询用户的角色
            List<Role> roles = userService.findRoleByUserId(user.getId());
            //如果用户type为admin则拥有所有权限
            if(user.getType().equals(UserType.SUPER_ADMIN.getCode())){
                List<Permission> permissionList = permissionService.findAll();
                for(Permission permission :permissionList){
                    perCode.add(permission.getCode());
                }
            }else {
                //查询用户的权限缓存起来
                perCode = userService.findPerByUserId(user.getId());
            }
            simpleAuthenticationInfo =  new SimpleAuthenticationInfo(new LoginUserDto(user,perCode,roles),password,getName());
        }catch (AuthenticationException e){
            throw e;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return simpleAuthenticationInfo;
    }
}
