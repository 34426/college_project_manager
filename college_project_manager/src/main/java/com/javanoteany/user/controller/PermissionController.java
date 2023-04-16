package com.javanoteany.user.controller;

import com.javanoteany.common.aop.AutoErrorhandler;
import com.javanoteany.common.base.V;
import com.javanoteany.common.result.Result;
import com.javanoteany.common.utils.BeanCopyUtils;
import com.javanoteany.common.utils.CurrentUserUtils;
import com.javanoteany.common.utils.tree.JsonTreeData;
import com.javanoteany.user.service.IPermissionService;
import com.javanoteany.user.entity.Permission;
import com.javanoteany.user.view.PermissionView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
@Api(value = "权限")
@RequestMapping("/permission")
@RestController
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;

    /**
     * 根据id获取权限
     * @param id
     * @return
     */
    @ApiOperation("根据id获取权限")
    @GetMapping(value = "",params = {"id"})
    @AutoErrorhandler
    @RequiresPermissions("account:user:list")
    public Result findById(String id){
        Permission permission = permissionService.findById(id);
        Assert.notNull(permission,"权限不存在!");
        return Result.getSuccess(permission);
    }

    /**
     * 删除权限
     * @param id
     * @return
     */
    @ApiOperation("删除权限")
    @DeleteMapping(value = "",params = {"id"})
    @AutoErrorhandler
    public Result delete(String id){
        Permission permission = permissionService.findById(id);
        Assert.notNull(permission,"权限不存在!");
        permissionService.delete(id);
        return Result.getSuccess();
    }

    @RequiresPermissions("account:permission:update")
    @ApiOperation(value="修改权限")
    @AutoErrorhandler
    @PutMapping("")
    public Result update(@RequestBody @Validated(V.Update.class) PermissionView permissionView, BindingResult bindingResult) throws Exception {
        //这里应该要判断权限是否重复的
        int count = permissionService.updateValidate(BeanCopyUtils.copy(permissionView,Permission.class));
        Assert.isTrue(count == 0,"该节点下已经有同名 或者 同code 的权限");
        permissionService.update(BeanCopyUtils.copy(permissionView,Permission.class));
        return Result.getSuccess();
    }


    /**
     * 添加权限
     * @return
     */
    @ApiOperation("添加权限")
    @PostMapping("")
    @AutoErrorhandler
    public Result save(@RequestBody @Validated(V.Save.class)PermissionView permissionView, BindingResult bindingResult) throws Exception {
        // 先判断再同一个父节点下面是不是有同名或者同code的权限 如果有就不允许添加
        Permission permission = permissionService.saveValidate(permissionView.getName(), permissionView.getCode(), permissionView.getParentId());
        Assert.isNull(permission,"该节点下已经有同名 或者 同code 的权限");
        return Result.getSuccess(permissionService.save(BeanCopyUtils.copy(permissionView,Permission.class)));
    }

    /**
     * 查询权限树
     * @return
     */
    @RequiresPermissions("account:permission:list")
    @ApiOperation(value = "查询权限树")
    @GetMapping("/tree")
    @AutoErrorhandler
    public Result findPermissionTree(){
        List<JsonTreeData> permissionTree = permissionService.findPermissionTree();
        return Result.getSuccess(permissionTree);
    }

    /**
     * 获取当前用户的权限code
     * @return
     */
    @ApiOperation(value = "获取当前用户的权限code")
    @GetMapping("/per_code")
    @AutoErrorhandler
    public Result getCurrentPermission(){
        return Result.getSuccess(CurrentUserUtils.getCurrentUser().getPerCodes());
    }
}
