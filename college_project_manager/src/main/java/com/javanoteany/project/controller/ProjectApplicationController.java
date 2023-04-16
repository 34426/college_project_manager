package com.javanoteany.project.controller;

import com.javanoteany.common.aop.AutoErrorhandler;
import com.javanoteany.common.base.V;
import com.javanoteany.common.result.PageResult;
import com.javanoteany.common.result.Result;
import com.javanoteany.common.utils.BeanCopyUtils;
import com.javanoteany.project.entity.ProjectApplication;
import com.javanoteany.project.query.ApplicationQuery;
import com.javanoteany.project.service.IProjectApplicationService;
import com.javanoteany.project.view.ProjectApplicationView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
@Api(value = "项目申报")
@RestController
@RequestMapping("/project_application")
public class ProjectApplicationController {

    @Autowired
    private IProjectApplicationService projectApplicationService;

    @ApiOperation("项目申报")
    @PostMapping("")
    @AutoErrorhandler
    public Result save(@RequestBody @Validated(V.Save.class) ProjectApplicationView projectApplicationView, BindingResult bindingResult)throws Exception{
        ProjectApplication projectApplication = BeanCopyUtils.copy(projectApplicationView, ProjectApplication.class);
        return Result.getSuccess(projectApplicationService.toApplication(projectApplication));
    }


    @ApiOperation(value = "项目申请通过")
    @PutMapping(value = "/pass")
    @AutoErrorhandler
    public Result applicationPass(@RequestBody @Validated(ProjectApplicationView.ApplicationPass.class) ProjectApplicationView projectApplicationView, BindingResult bindingResult){
        ProjectApplication projectApplication = projectApplicationService.findById(projectApplicationView.getId());
        Assert.notNull(projectApplication,"项目申请不存在!");
        projectApplication.setBackInformation(projectApplicationView.getBackInformation());
        return Result.getSuccess(projectApplicationService.applicationPass(projectApplication));
    }

    @ApiOperation(value = "项目申报未通过")
    @PutMapping(value = "/not_pass")
    @AutoErrorhandler
    public Result applicationNotPass(@RequestBody @Validated(ProjectApplicationView.ApplicationNotPass.class) ProjectApplicationView projectApplicationView, BindingResult bindingResult){
        ProjectApplication projectApplication = projectApplicationService.findById(projectApplicationView.getId());
        Assert.notNull(projectApplication,"结题申请不存在!");
        projectApplication.setBackInformation(projectApplicationView.getBackInformation());
        return Result.getSuccess(projectApplicationService.applicationNotPass(projectApplication));
    }

    @ApiOperation(value = "查询项目申报")
    @GetMapping("/query")
    @AutoErrorhandler
    public Result query(ApplicationQuery query){
        PageResult pageResult = projectApplicationService.queryPage(query);
        return Result.getSuccess(pageResult);
    }

    @ApiOperation(value = "根据id获取项目申报")
    @GetMapping(value = "",params = {"id"})
    @AutoErrorhandler
    public Result findById(String id){
        ProjectApplication projectApplication = projectApplicationService.findById(id);
        Assert.notNull(projectApplication,"项目申报不存在!");
        return Result.getSuccess(projectApplication);
    }
}
