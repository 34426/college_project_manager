package com.javanoteany.common.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class BeanCopyUtils {


    /**
     * 对象拷贝
     * @param source 对象源
     * @param targer 目标对象
     */
    public static void copy(Object source,Object targer){
        BeanCopier beanCopier = BeanCopier.create(source.getClass(), targer.getClass(), false);
        beanCopier.copy(source,targer,null);
    }

    /**
     * 对象拷贝忽略控制
     * @param source 对象源
     * @param targer 目标对象
     */
    public static void copyIgnoreNullValue(Object source,Object targer){
        if(source != null && targer != null){
            BeanWrapper beanWrapper = new BeanWrapperImpl(source);
            PropertyDescriptor[] propertyDescriptors = beanWrapper.getPropertyDescriptors();
            Set<String> nullNames = new HashSet<>();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                Object value = beanWrapper.getPropertyValue(propertyDescriptor.getName());
                if(value == null && StringUtils.isEmpty(value)){
                    nullNames.add(propertyDescriptor.getName());
                }
            }
            BeanUtils.copyProperties(source,targer,nullNames.toArray(new String[]{}));
        }
    }

    /**
     * 对象拷贝并创建target对象
     * @param source 对象源
     * @param targer 目标对象
     */
    public static <T> T copy(Object source,Class<T> targer) throws Exception {
        if(source != null){
            T instance = targer.newInstance();
            copy(source,instance);
            return instance;
        }
        return  null;
    }

    /**
     * 集合对象拷贝并创建target对象
     * @param sources 对象源
     * @param targer 目标对象
     */
    public static <T> List copyList(List sources, Class<T> targer) throws Exception {
        List<T> list = new ArrayList<T>();
        if(!CollectionUtils.isEmpty(sources)){
            for (Object source : sources) {
                T t = copy(source, targer);
                list.add(t);
            }
        }
        return list;
    }



}
