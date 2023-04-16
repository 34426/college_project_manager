package com.javanoteany.dict.service;


import com.javanoteany.common.base.service.IBaseService;
import com.javanoteany.dict.entity.DataDictDetail;

import java.io.Serializable;
import java.util.List;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public interface IDataDictDetailService extends IBaseService<DataDictDetail> {

    /**
     * 根据id查询数据字典明细
     * @param id
     * @return
     */
    @Override
    DataDictDetail findById(Serializable id);

    /**
     * 根据字典类别id获取
     * @param typeId
     * @return
     */
    List<DataDictDetail> findByTypeId(String typeId);

    /**
     * 根据名称查询字典明细
     * @param name name
     * @return
     */
    DataDictDetail findByNameAndTypeId(String name, String typeId);

    /**
     * 根据code查询字典明细
     * @param name
     * @param typeId
     * @return
     */
    DataDictDetail findByCodeAndTypeId(String name, String typeId);

    /**
     * 保存字典明细
     * @param DataDictDetail
     * @return
     */
    DataDictDetail save(DataDictDetail DataDictDetail);

    /**
     * 更新字典类型
     * @param dataDictDetail
     * @return
     */
    DataDictDetail update(DataDictDetail dataDictDetail);

}
