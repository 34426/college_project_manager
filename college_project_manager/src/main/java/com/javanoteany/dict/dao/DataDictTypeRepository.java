package com.javanoteany.dict.dao;

import com.javanoteany.common.base.dao.BaseRepository;
import com.javanoteany.dict.entity.DataDictType;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public interface DataDictTypeRepository extends BaseRepository<DataDictType> {

    DataDictType findByCode(String code);

    DataDictType findByName(String name);
}