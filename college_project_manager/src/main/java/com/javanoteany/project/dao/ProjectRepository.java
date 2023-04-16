package com.javanoteany.project.dao;

import com.javanoteany.project.entity.Project;
import com.javanoteany.common.base.dao.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public interface ProjectRepository extends BaseRepository<Project>{
    @Query("select p from Project p where p.name = :name")
    Project findByName(@Param("name") String name);
}
