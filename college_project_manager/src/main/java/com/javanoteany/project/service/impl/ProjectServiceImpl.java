package com.javanoteany.project.service.impl;

import com.javanoteany.common.base.dao.BaseRepository;
import com.javanoteany.common.base.service.Impl.BaseServiceImpl;
import com.javanoteany.project.dao.ProjectRepository;
import com.javanoteany.project.entity.Project;
import com.javanoteany.project.service.IProjectService;
import com.javanoteany.project.util.ProjectUtils;
import com.javanoteany.project.constant.ProjectStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
@Service
public class ProjectServiceImpl extends BaseServiceImpl<Project> implements IProjectService {
    public ProjectServiceImpl(BaseRepository<Project> repository) {
        super(repository);
    }

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private BaseRepository<Project> baseRepository;

    @Override
    public Project update(Project newProject, Project oldProject) {
        newProject = ProjectUtils.someThingNotChange(newProject,oldProject);
        Project updated = baseRepository.save(newProject);
        return updated;
    }

    @Override
    public Project changeStatus(String projectId, ProjectStatus status) {
        Project project = projectRepository.findOne(projectId);
        Assert.notNull(project,"项目"+project.getName()+"不存在!");
        project.setStatus(status.getCode());
        return baseRepository.save(project);
    }

    @Override
    public Project findByName(String name) {
        return projectRepository.findByName(name);
    }
}
