package com.javanoteany.dict.service;


import com.javanoteany.common.base.service.IBaseService;
import com.javanoteany.dict.entity.DataDictType;

import java.io.Serializable;
import java.util.List;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public interface IDataDictTypeService extends IBaseService<DataDictType> {

    /**
     * 根据数据字典查询数据字典类别
     * @param id
     * @return
     */
    @Override
    DataDictType findById(Serializable id);

    /**
     * 根据code查找字典类型
     * @param code 字典代码
     * @return
     */
    DataDictType findByCode(String code);

    /**
     * 根绝name查找字典名称
     * @param name 字典名称
     * @return
     */
    DataDictType findByName(String name);

    /**
     * 获取全部数据字典类别
     * @return
     */
    List<DataDictType> findAll();

    /**
     * 保存数据字典类型
     * @param dataDictType
     * @return
     */
    DataDictType save(DataDictType dataDictType);

    /**
     * 修改字典类型
     * @param dataDictType
     * @return
     */
    DataDictType update(DataDictType dataDictType);

}
