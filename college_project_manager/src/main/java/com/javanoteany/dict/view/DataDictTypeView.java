package com.javanoteany.dict.view;


import com.javanoteany.common.base.V;
import com.javanoteany.dict.entity.DataDictDetail;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class DataDictTypeView {

    private String id;

    /**
     * 字典类型名称
     */
    @Size(min = 1,max = 50,groups = {V.Save.class},message = "字典类型名称[1,50]")
    @NotBlank(groups = {V.Save.class},message = "字典类型名称不能为空")
    private String name;

    /**
     * 字典类型code
     */
    @Size(min = 1,max = 50,groups = {V.Save.class},message = "字典类型code[1,50]")
    @NotBlank(groups = {V.Save.class},message = "字典类型code不能为空")
    private String code;

    private List<DataDictDetail> dataDictDetails;

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

    public List<DataDictDetail> getDataDictDetails() {
        return dataDictDetails;
    }

    public void setDataDictDetails(List<DataDictDetail> dataDictDetails) {
        this.dataDictDetails = dataDictDetails;
    }
}
