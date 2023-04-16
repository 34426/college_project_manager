package com.javanoteany.user.service.impl;

import com.javanoteany.common.base.dao.BaseRepository;
import com.javanoteany.common.base.service.Impl.BaseServiceImpl;
import com.javanoteany.common.utils.UUIDUtil;
import com.javanoteany.user.service.IRoleService;
import com.javanoteany.user.service.IUserRoleService;
import com.javanoteany.user.service.IUserService;
import com.javanoteany.user.dao.RolePermissionRepository;
import com.javanoteany.user.dao.RoleRepository;
import com.javanoteany.user.entity.Role;
import com.javanoteany.user.entity.User;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserRoleService userRoleServicel;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public RoleServiceImpl(BaseRepository<Role> repository) {
        super(repository);
    }

    @Override
    public Set<String> findRoleIdsByUserId(String id) {
        User user = userService.findById(id);
        Assert.notNull(user,"用户不存在!");
        return userRoleServicel.findRoleIdsByUserId(id);
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Set<String> findPermissionIdsByid(String id) {
        return rolePermissionRepository.findPerIdByRoleId(id);
    }

    @Override
    @Transactional
    public void assignmentPermission(String roleId, String[] permissionIds) {
        //旧权限
        Set<String> oldPerIds = rolePermissionRepository.findPerIdByRoleId(roleId);
        //新权限
        Set<String> newPerIds = Arrays.stream(permissionIds).collect(Collectors.toSet());
        //要删除的权限 旧的去掉新的
        Set<String> deleteIds = new HashSet<>(CollectionUtils.removeAll(oldPerIds, newPerIds));
        if(deleteIds.size() > 0) {
            rolePermissionRepository.deleteInPermissionIds(deleteIds);
        }
        //要添加的权限 新的去掉旧的
        Set<String> addPerId = new HashSet<>(CollectionUtils.removeAll(newPerIds, oldPerIds));
        String[] addPerIdArr = addPerId.toArray(new String[addPerId.size()]);
        if(addPerId.size() > 0){
            jdbcTemplate.batchUpdate("insert into t_role_permission(id,role_id,permission_id)value(?,?,?)", new BatchPreparedStatementSetter() {
                public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                    preparedStatement.setString(1, UUIDUtil.getUUID());
                    preparedStatement.setString(2,roleId);
                    preparedStatement.setString(3,addPerIdArr[i]);
                }
                public int getBatchSize() {
                    return addPerIdArr.length;
                }
            });
        }
    }

    @Override
    @Transactional
    public void delete(String id) {
        // 删除角色
        roleRepository.delete(id);
        // 删除角色权限关系表
        rolePermissionRepository.deleteByRoleId(id);
    }
}
