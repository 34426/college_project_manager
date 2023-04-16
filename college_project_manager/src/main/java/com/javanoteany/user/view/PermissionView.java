package com.javanoteany.user.view;

import com.javanoteany.common.base.V;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class PermissionView {
    // id
    @ApiModelProperty("id")
    @NotBlank(groups = {V.Update.class},message = "id不能为空!")
    private String id;

    // 权限code
    @ApiModelProperty("权限code")
    @Size(min = 2,max = 50,groups = {V.Save.class,V.Update.class},message = "权限code[2-50]位!")
    @NotBlank(groups = {V.Save.class,V.Update.class},message = "权限code不能为空!")
    private String code;

    // 权限名称
    @ApiModelProperty("权限名称")
    @Size(min = 2,max = 20,groups = {V.Save.class,V.Update.class},message = "权限名称[2-20]位!")
    @NotBlank(groups = {V.Save.class,V.Update.class},message = "权限名称不能为空!")
    private String name;

    // 排序
    @ApiModelProperty("排序")
    private Integer sort;

    // 父级id
    @ApiModelProperty("父级id")
    private String parentId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
