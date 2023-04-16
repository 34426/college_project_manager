package com.javanoteany.common.base.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T, Serializable>,JpaSpecificationExecutor<T> {

}
