package com.javanoteany.user.service.impl;

import com.javanoteany.common.base.dao.BaseRepository;
import com.javanoteany.common.base.service.Impl.BaseServiceImpl;
import com.javanoteany.user.service.IUserRoleService;
import com.javanoteany.user.dao.UserRoleRepository;
import com.javanoteany.user.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole> implements IUserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(BaseRepository<UserRole> repository) {
        super(repository);
    }

    @Override
    public Set<String> findRoleIdsByUserId(String id) {
        return userRoleRepository.findByUserId(id);
    }
}
