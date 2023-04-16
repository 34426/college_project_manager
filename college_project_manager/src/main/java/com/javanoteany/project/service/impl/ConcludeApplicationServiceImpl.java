package com.javanoteany.project.service.impl;

import com.javanoteany.common.base.dao.BaseRepository;
import com.javanoteany.common.base.service.Impl.BaseServiceImpl;
import com.javanoteany.common.utils.CurrentUserUtils;
import com.javanoteany.project.constant.ApplicationStatus;
import com.javanoteany.project.dao.ConcludeApplicationRepository;
import com.javanoteany.project.entity.ConcludeApplication;
import com.javanoteany.project.service.IConcludeApplicationService;
import com.javanoteany.project.service.IProjectService;
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
public class ConcludeApplicationServiceImpl extends BaseServiceImpl<ConcludeApplication> implements IConcludeApplicationService {
    public ConcludeApplicationServiceImpl(BaseRepository<ConcludeApplication> repository) {
        super(repository);
    }

    @Autowired
    private ConcludeApplicationRepository concludeApplicationRepository;

    @Autowired
    private IProjectService projectService;

    @Override
    @Transactional
    public ConcludeApplication toApplication(ConcludeApplication concludeApplication) {
        //申请结题中 项目状态变为 申请结题中 不可修改 不可申报 不可申请变更 不可申请结题
        projectService.changeStatus(concludeApplication.getProjectId(), ProjectStatus.CONCLUDE_AUDIT);
        concludeApplication.setStatus(ApplicationStatus.ON_APPLIACTION.getName());
        concludeApplication.setApplicant(CurrentUserUtils.getCurrentUser().getSecurityUserDto().getUserName());
        concludeApplication.setApplicateTime(new Date());
        return concludeApplicationRepository.save(concludeApplication);
    }

    @Override
    @Transactional
    public ConcludeApplication applicationPass(ConcludeApplication concludeApplication) {
        //结题申请通过 结题成功 不可修改 不可申请 不可申请变更 不可申请结题
        projectService.changeStatus(concludeApplication.getProjectId(),ProjectStatus.CONCLUDED);
        concludeApplication.setStatus(ApplicationStatus.SUCCESS_APPLICATION.getName());
        return concludeApplicationRepository.save(concludeApplication);
    }

    @Override
    @Transactional
    public ConcludeApplication applicationNotPass(ConcludeApplication concludeApplication) {
        //结题未通过 结题未通过 不可修改 不可申请 可以申请变更 可以申请结题
        projectService.changeStatus(concludeApplication.getProjectId(),ProjectStatus.FAIL_CONCLUDE_AUDIT);
        concludeApplication.setStatus(ApplicationStatus.FAIL_APPLICATION.getName());
        return concludeApplicationRepository.save(concludeApplication);
    }
}
