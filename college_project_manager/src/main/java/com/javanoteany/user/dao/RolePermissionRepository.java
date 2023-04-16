package com.javanoteany.user.dao;

import com.javanoteany.common.base.dao.BaseRepository;
import com.javanoteany.user.entity.RolePermission;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public interface RolePermissionRepository extends BaseRepository<RolePermission> {
    @Query(" select rp.permissionId from RolePermission rp where rp.roleId = :id " )
    Set<String> findPerIdByRoleId(@Param("id") String id);

    @Transactional
    @Modifying
    @Query("delete from RolePermission rp where rp.permissionId in :ids")
    void deleteInPermissionIds(@Param("ids") Set<String> deleteIds);

    @Transactional
    @Modifying
    @Query("delete from RolePermission rp where rp.roleId = :id")
    void deleteByRoleId(@Param("id") String id);

    @Transactional
    @Modifying
    @Query("delete from RolePermission rp where rp.permissionId = :id")
    void deleteByPermissionIds(@Param("id") String id);
}
