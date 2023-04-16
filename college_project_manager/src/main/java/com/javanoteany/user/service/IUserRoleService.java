package com.javanoteany.user.service;

import com.javanoteany.common.base.service.IBaseService;
import com.javanoteany.user.entity.UserRole;

import java.util.Set;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public interface IUserRoleService extends IBaseService<UserRole> {
    /**
     * 根据用户id获取角色ids
     * @param id
     * @return
     */
    Set<String> findRoleIdsByUserId(String id);

}
