package com.javanoteany.project.service;

import com.javanoteany.project.entity.Project;
import com.javanoteany.common.base.service.IBaseService;
import com.javanoteany.project.constant.ProjectStatus;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public interface IProjectService extends IBaseService<Project>{

    /**
     * 项目更新
     * @param newProject
     * @param oldProject
     * @return
     */
    Project update(Project newProject, Project oldProject);

    /**
     * 修改项目状态
     * @param projectId
     * @param status
     * @return
     */
    Project changeStatus(String projectId, ProjectStatus status);

    /**
     * 根据项目名称查询
     * @param name
     * @return
     */
    Project findByName(String name);
}
