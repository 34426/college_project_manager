package com.javanoteany.user.service.impl;

import com.javanoteany.common.base.dao.BaseRepository;
import com.javanoteany.common.base.service.Impl.BaseServiceImpl;
import com.javanoteany.common.utils.tree.JsonTreeCreater;
import com.javanoteany.common.utils.tree.JsonTreeData;
import com.javanoteany.user.dao.PermissionRepository;
import com.javanoteany.user.dao.RolePermissionRepository;
import com.javanoteany.user.entity.Permission;
import com.javanoteany.user.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements IPermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private RolePermissionRepository rolePermissionRepository;

    public PermissionServiceImpl(BaseRepository<Permission> repository) {
        super(repository);
    }

    @Override
    public Permission saveValidate(String name, String code, String parentId) {
        return permissionRepository.saveValidate(name, code, parentId);
    }

    @Override
    public List<JsonTreeData> findPermissionTree() {
        List<Permission> permissionList = permissionRepository.findAll();
        return new JsonTreeCreater<Permission>(permissionList,
                item -> item.getId(),
                a -> StringUtils.isEmpty(a.getParentId()) ? "0" : a.getParentId(),
                a -> a.getName(),
                a -> false,
                a -> null
        ).create();
    }

    @Override
    @Transactional
    public void deldete(String id) {
        // 删除权限
        permissionRepository.delete(id);
        // 删除角色权限中间关系表
        rolePermissionRepository.deleteByPermissionIds(id);
    }

    @Override
    public int updateValidate(Permission permission) {
        return permissionRepository.updateValidate(permission.getId(),permission.getName(),permission.getCode(),permission. getParentId());
    }

    @Override
    public Permission update(Permission permission){
        Permission oldPermission = this.findById(permission.getId());
        Assert.notNull(oldPermission,"你要修改的权限不存在");
        oldPermission.setName(permission.getName());
        oldPermission.setCode(permission.getCode());
        return permissionRepository.save(oldPermission);
    }
}
