package com.javanoteany.project.service.impl;

import com.javanoteany.common.base.dao.BaseRepository;
import com.javanoteany.common.base.service.Impl.BaseServiceImpl;
import com.javanoteany.project.entity.Fund;
import com.javanoteany.project.service.IFundService;
import org.springframework.stereotype.Service;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
@Service
public class FundServiceImpl extends BaseServiceImpl<Fund> implements IFundService {
    public FundServiceImpl(BaseRepository<Fund> repository) {
        super(repository);
    }
}
