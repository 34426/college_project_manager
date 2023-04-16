package com.javanoteany.common.base.service.Impl;

import com.javanoteany.common.context.ContextUtils;
import com.javanoteany.common.result.PageResult;
import com.javanoteany.common.utils.BeanCopyUtils;
import com.javanoteany.common.base.dao.BaseRepository;
import com.javanoteany.common.base.service.IBaseService;
import com.javanoteany.common.query.Query;
import com.javanoteany.common.query.QuerySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class BaseServiceImpl<T> implements IBaseService<T>  {

    public BaseServiceImpl(BaseRepository<T> repository) {
        this.repository = repository;
    }

    private QuerySpecification querySpecification = new QuerySpecification<T>();

    private BaseRepository<T> repository;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public T save(T t){
        return repository.save(t);
    }

    @Transactional
    public T update(T t) {
        return repository.save(t);
    }

    @Transactional
    public Iterable<T> save(Iterable<T> list) {
        List<T> result = new ArrayList<T>();
        for (T  t : list) {
            result.add(save(t));
        }
        return result;
    }


    @Transactional
    public void delete(Serializable id){
        repository.delete(id);
    }


    public T getOne(Serializable id){
        return (T) repository.getOne(id);
    }

    public T findById(Serializable id) {
        if(!StringUtils.isEmpty(id)){
            T t = repository.findOne(id);
            if(t == null){
                return t;
            }
            return t;
        }else{
            return null;
        }
    }

    public List<T> findByIds(List<Serializable> ids) {
        return repository.findAll(ids);
    }

    public List<T> findByIds(String[] ids) {
        return repository.findAll(Arrays.stream(ids).collect(Collectors.toList()));
    }

    public List<T> findAll(){
        return repository.findAll();
    }

    /**
     * 判断对应Id记录是否存在
     * @param id
     * @return
     */
    public boolean exists(Serializable id) {
        return repository.exists(id);
    }

    /**
     * 统计总数
     * @return
     */
    public Long count() {
        return repository.count();
    }

    public EntityManager getEntityManager() {
        if(this.entityManager == null){
            this.entityManager = ContextUtils.getApplicationContext().getBean(EntityManager.class);
        }
        return entityManager;
    }

    /**
     * 高级查询 支持查询条件、分页、排序
     * @param query
     * @return
     */
    public PageResult queryPage(Query query) {
        query.generateCondition();
        Specification specification = querySpecification.buildSpecification(query);
        Page page = null;
        if(specification != null){
            page = repository.findAll(specification, querySpecification.buildPageable(query));
        }else{
            page = repository.findAll(querySpecification.buildPageable(query));
        }
        PageResult pageResult = new PageResult(page.getContent(),page.getTotalPages(),page.getTotalElements());
        if(query.getResultType() != null && !CollectionUtils.isEmpty(page.getContent())){
            try {
                pageResult.setRows(BeanCopyUtils.copyList(page.getContent(),query.getResultType()));
            } catch (Exception e) {
                throw new RuntimeException("类型转换出错! " + e.getMessage());
            }
        }
        return pageResult;
    }

    /**
     * 高级查询 支持查询条件但不支持分页
     * @param query
     * @return
     */
    public List<T> query(Query query) {
        query.generateCondition();
        Specification specification = querySpecification.buildSpecification(query);
        if(specification != null){
            return repository.findAll(specification,querySpecification.buildSort(query));
        }else{
            return repository.findAll(querySpecification.buildSort(query));
        }
    }
}
