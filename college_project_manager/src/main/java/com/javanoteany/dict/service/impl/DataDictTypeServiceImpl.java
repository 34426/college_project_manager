package com.javanoteany.dict.service.impl;

import com.javanoteany.common.base.dao.BaseRepository;
import com.javanoteany.common.base.service.Impl.BaseServiceImpl;
import com.javanoteany.dict.dao.DataDictTypeRepository;
import com.javanoteany.dict.entity.DataDictType;
import com.javanoteany.dict.service.IDataDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
@Service
public class DataDictTypeServiceImpl extends BaseServiceImpl<DataDictType> implements IDataDictTypeService {

    @Autowired
    private DataDictTypeRepository dataDictTypeRepository;

    public DataDictTypeServiceImpl(BaseRepository<DataDictType> repository) {
        super(repository);
    }

    @Override
    public DataDictType findByCode(String code) {
        return dataDictTypeRepository.findByCode(code);
    }

    @Override
    public DataDictType findByName(String name) {
        return dataDictTypeRepository.findByName(name);
    }
}
