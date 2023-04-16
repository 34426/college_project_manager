package com.javanoteany.common.base.service;

import com.javanoteany.common.result.PageResult;
import com.javanoteany.common.query.Query;

import java.io.Serializable;
import java.util.List;
/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public interface IBaseService<T> {


    /**
     * 添加或更新
     * @param t
     */
    public T save(T t);

    /**
     * 更新
     * @param t
     * @return
     */
    public T update(T t);

    /**
     * 添加或更新
     * @param t
     */
    public Iterable<T> save(Iterable<T> t);

    /**
     * 根据主键删除
     * @param id
     */
    public void delete(Serializable id);

    /**
     * 根据主键获取 懒加载
     * @param id
     * @return
     */
    public T getOne(Serializable id);

    /**
     * 根据主键获取
     * @param id
     * @return
     */
    public T findById(Serializable id);

    /**
     * 根据主键获取
     * @param ids
     * @return
     */
    public List<T> findByIds(List<Serializable> ids);

    /**
     * 根据主键获取
     * @param ids
     * @return
     */
    public List<T> findByIds(String[] ids);

    /**
     * 获取全部记录
     * @return
     */
    public List<T> findAll();

    /**
     * 判断对应Id记录是否存在
     * @param id 数据ID
     * @return
     */
    public boolean exists(Serializable id);

    /**
     * 统计总数
     * @return
     */
    public Long count();


    /**
     * 高级查询 支持查询条件、分页、排序
     * @param query 查询条件
     * @return
     */
    PageResult queryPage(Query query);

    /**
     * 高级查询 支持查询条件但不支持分页
     * @param query  查询条件
     * @return
     */
    List<T> query(Query query);
}
