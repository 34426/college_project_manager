package com.javanoteany.user.service;

import com.javanoteany.common.base.service.IBaseService;
import com.javanoteany.common.utils.tree.JsonTreeData;
import com.javanoteany.user.entity.Permission;

import java.util.List;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public interface IPermissionService extends IBaseService<Permission> {
    /**
     * 根据权限名 权限code 权限父接节点 进行保存验证
     * @param name
     * @param code
     * @param parentId
     * @return
     */
    Permission saveValidate(String name,String code, String parentId);

    /**
     * 查询所有权限树
     * @return
     */
    List<JsonTreeData> findPermissionTree();

    /**
     * 删除权限
     * @param id
     */
    void deldete(String id);

    /**
     * 修改权限的时候验证 规则就是统一父id下 除了本id外没有 重复的name 和code
     * @param permission
     * @return
     */
    int updateValidate(Permission permission);
}
