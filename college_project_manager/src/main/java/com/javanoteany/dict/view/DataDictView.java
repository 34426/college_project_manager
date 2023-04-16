package com.javanoteany.dict.view;


import com.javanoteany.common.base.V;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class DataDictView{

    private String id;

    /**
     * 字典明细名称
     */
    @Size(min = 1,max = 50,groups = {V.Save.class},message = "字典明细名称[1,50]")
    @NotBlank(groups = {V.Save.class},message = "字典明细名称不能为空")
    private String name;

    /**
     * 字典明细code
     */
    @Size(min = 1,max = 50,groups = {V.Save.class},message = "字典明细code[1,50]")
    @NotBlank(groups = {V.Save.class},message = "字典明细code不能为空")
    private String code;

    /**
     * 字典类别ID
     */
    @NotBlank(groups = {V.Save.class},message = "字典类别ID不能为空")
    private String typeId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

}
