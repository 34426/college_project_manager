package com.javanoteany.dict.entity;

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
@Table(name = BaseEntity.TABLE_PREFIX + "DATA_DICTIONARY_TYPE")
public class DataDictType extends BaseEntity{
    //数据字典类型名称
    @Column(name = "name",length = 50,nullable = false,unique = true)
    private String name;

    //数据字典code
    @Column(name = "code",length = 50,nullable = false,unique = true)
    private String code;

    //数据字典明细
    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = DataDictDetail.class,mappedBy = "typeId")
    private List<DataDictDetail> dataDictDetails;

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
