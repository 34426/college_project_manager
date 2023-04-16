package com.javanoteany.project.service.impl;

import com.javanoteany.common.base.dao.BaseRepository;
import com.javanoteany.common.base.service.Impl.BaseServiceImpl;
import com.javanoteany.common.utils.CurrentUserUtils;
import com.javanoteany.project.constant.ApplicationStatus;
import com.javanoteany.project.dao.UpdateApplicationRepository;
import com.javanoteany.project.entity.UpdateApplication;
import com.javanoteany.project.service.IProjectService;
import com.javanoteany.project.service.IUpdateApplicationService;
import com.javanoteany.project.constant.ProjectStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
@Service
public class UpdateApplicationServiceImpl extends BaseServiceImpl<UpdateApplication> implements IUpdateApplicationService {
    public UpdateApplicationServiceImpl(BaseRepository<UpdateApplication> repository) {
        super(repository);
    }

    @Autowired
    private UpdateApplicationRepository updateApplicationRepository;

    @Autowired
    private IProjectService projectService;

    @Override
    @Transactional
    public UpdateApplication applicationPass(UpdateApplication updateApplication) {
        //变更申请成功后 项目状态变成 变更中 可以修改 需要再次申报 不可以申请变更 不可以申请结题
        projectService.changeStatus(updateApplication.getProjectId(), ProjectStatus.SUCCESS_UPDATE_AUDIT);
        updateApplication.setStatus(ApplicationStatus.SUCCESS_APPLICATION.getName());
        return updateApplicationRepository.save(updateApplication);
    }

    @Override
    @Transactional
    public UpdateApplication toApplication(UpdateApplication updateApplication) {
        //申请变更 项目状态变成 申请变更中 不可以修改 不可以申报 不可以申请变更 不可以申请结题
        projectService.changeStatus(updateApplication.getProjectId(), ProjectStatus.UPDATE_AUDIT);
        updateApplication.setApplicant(CurrentUserUtils.getCurrentUser().getSecurityUserDto().getUserName());
        updateApplication.setApplicateTime(new Date());
        updateApplication.setStatus(ApplicationStatus.ON_APPLIACTION.getName());
        return updateApplicationRepository.save(updateApplication);
    }

    @Override
    @Transactional
    public UpdateApplication applicationNotPass(UpdateApplication updateApplication) {
        //申请变更失败 项目状态变成申请变更失败 不可修改 不可以申报 可以申请变更 可以申请结题
        projectService.changeStatus(updateApplication.getProjectId(), ProjectStatus.FAIL_UPDATE_AUDIT);
        updateApplication.setStatus(ApplicationStatus.FAIL_APPLICATION.getName());
        return updateApplicationRepository.save(updateApplication);
    }
}
