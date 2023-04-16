package com.javanoteany.dict.service.impl;

import com.javanoteany.common.base.dao.BaseRepository;
import com.javanoteany.common.base.service.Impl.BaseServiceImpl;
import com.javanoteany.dict.dao.DataDictDetailRepository;
import com.javanoteany.dict.entity.DataDictDetail;
import com.javanoteany.dict.service.IDataDictDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
@Service
public class DataDictDetailServiceImpl extends BaseServiceImpl<DataDictDetail> implements IDataDictDetailService {

    @Autowired
    private DataDictDetailRepository dataDictDetailRepository;

    public DataDictDetailServiceImpl(BaseRepository<DataDictDetail> repository) {
        super(repository);
    }

    @Override
    public List<DataDictDetail> findByTypeId(String typeId) {
        return dataDictDetailRepository.findByTypeId(typeId);
    }

    @Override
    public DataDictDetail findByNameAndTypeId(String name, String typeId) {
        return dataDictDetailRepository.findByNameAndTypeId(name,typeId);
    }

    @Override
    public DataDictDetail findByCodeAndTypeId(String code, String typeId) {
        return dataDictDetailRepository.findByCodeAndTypeId(code,typeId);
    }
}
