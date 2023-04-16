package com.javanoteany.user.service.impl;

import com.javanoteany.common.base.dao.BaseRepository;
import com.javanoteany.common.base.service.Impl.BaseServiceImpl;
import com.javanoteany.user.entity.RolePermission;
import com.javanoteany.user.service.IRolePermissionService;
import org.springframework.stereotype.Service;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
@Service
public class RolePermissionServiceImpl extends BaseServiceImpl<RolePermission> implements IRolePermissionService {

    public RolePermissionServiceImpl(BaseRepository<RolePermission> repository) {
        super(repository);
    }
}
