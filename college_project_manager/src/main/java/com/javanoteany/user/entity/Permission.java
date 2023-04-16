package com.javanoteany.user.entity;

import com.javanoteany.common.base.entity.BaseEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
@Entity
@Table(name = BaseEntity.TABLE_PREFIX + "PERMISSION")
public class Permission extends BaseEntity {


    //权限code
    @Column(length = 50)
    private String code;

    //权限名称
    @Column(length = 50)
    private String name;

    //排序
    @Column
    private Integer sort;

    //父级
    @Column(name = "parent_id")
    private String parentId;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Permission.class,mappedBy = "parentId",orphanRemoval = true)
    private List<Permission> children;

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

    public List<Permission> getChildren() {
        return children;
    }

    public void setChildren(List<Permission> children) {
        this.children = children;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
