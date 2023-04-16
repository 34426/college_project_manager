package com.javanoteany.common.query;


import com.github.wenhao.jpa.PredicateBuilder;
import com.github.wenhao.jpa.Sorts;
import com.github.wenhao.jpa.Specifications;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class QuerySpecification<T>{


    //猜测用的时间格式
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    /**
     * 拼装条件
     * @param filters
     * @param predicate
     */
    public void toPredicate(List<Filter> filters, PredicateBuilder<T> predicate){
        for (Filter filter : filters) {

            switch (filter.getOperator()){

                case eq:
                    if(!StringUtils.isEmpty(filter.getValue())){
                        predicate.eq(filter.getField(),filter.getValue());
                    }
                    break;

                case ge:
                    try {
                        Integer value = new Integer(filter.getValue().toString());
                        predicate.ge(filter.getField(),value);
                    }catch (Exception e){
                        throw new RuntimeException("大于等于条件错误 " + e.getMessage());
                    }
                    break;

                case gt:
                    try {
                        Integer value = new Integer(filter.getValue().toString());
                        predicate.gt(filter.getField(),value);
                    }catch (Exception e){
                        throw new RuntimeException("大于条件错误 " + e.getMessage());
                    }
                    break;

                case in:
                    if(!StringUtils.isEmpty(filter.getValue())){
                        predicate.in(filter.getField(),(Object[])filter.getValue());
                    }
                    break;

                case isNull:
                    predicate.eq(filter.getField(),null);
                    break;

                case le:
                    try {
                        Integer value = new Integer(filter.getValue().toString());
                        predicate.le(filter.getField(),value);
                    }catch (Exception e){
                        throw new RuntimeException("小于等于条件错误 " + e.getMessage());
                    }
                    break;

                case like:
                    if(!StringUtils.isEmpty(filter.getValue())){
                        predicate.like(filter.getField(),filter.getValue().toString());
                    }
                    break;

                case lt:
                    try {
                        Integer value = new Integer(filter.getValue().toString());
                        predicate.lt(filter.getField(),value);
                    }catch (Exception e){
                        throw new RuntimeException("小于条件错误 " + e.getMessage());
                    }
                    break;

                case neq:
                    if(!StringUtils.isEmpty(filter.getValue())){
                        predicate.ne(filter.getField(),filter.getValue());
                    }
                    break;

                case notNull:
                    predicate.ne(filter.getField(),null);
                    break;

                case between:
                    Object[] values = filter.getValues();
                    if (values == null || values.length != 2) {
                        throw new RuntimeException("between条件参数错误，参数必须为两个");
                    }
                    Range range;
                    Object[] guess = guess(values);
                    if (guess[0] instanceof Number) {
                        range = new Range((Double) guess[0], (Double) guess[1]);
                    } else {
                        range = new Range((Date) guess[0], (Date) guess[1]);
                    }
                    predicate.between(filter.getField(), range);
            }
        }
    }

    /**
     * 猜测
     * @param values
     */
    public static Object[] guess(Object ...values) {
        Object[] guessValues = new Object[values.length];
        Boolean allIsDate = null;
        for (int i = 0; i < values.length; i++) {
            if (StringUtils.isEmpty(values[i])) {//如果值为空，那么我们将他当做时间格式处理
                guessValues[i] = i == 0 ? new Date(0) : new Date(Long.MAX_VALUE);//这里补全了时间，按照第一位为1970开始。第二位也就是其他位取时间最大值
                allIsDate = true;//所有的都应该是时间格式
                continue;
            }
            try {
                guessValues[i] = Double.valueOf(values[i].toString());
                if (allIsDate!=null&&allIsDate) {//如果所有的都是时间，这个却不是时间，那么就有问题
                    throw new RuntimeException("值:'"+values[i].toString() + "'与'"+values[i-1].toString()+"'格式不统一");
                }
                allIsDate = false;
            } catch (NumberFormatException e) {//这里只处理拦截数字格式异常
                //猜测为数字，未命中
                try {
                    guessValues[i] = sdf.parse(values[i].toString());
                    if (allIsDate!=null&&!allIsDate) {//如果之前一个不是时间
                        throw new RuntimeException("值:'"+values[i].toString() + "'与'"+values[i-1].toString()+"'格式不统一");
                    }
                    allIsDate = true;
                } catch (ParseException e1) {//这里也只处理转换错误
                    //猜测为时间格式，未命中
                    //搞个屁哦
                    throw new RuntimeException("值：'"+values[i].toString()+"'为不支持的数据类型");
                }
            }

        }
        return guessValues;
    }

    /**
     * 生成动态查询
     * @param query
     * @return
     */
    public Specification<T> buildSpecification(Query query){
        PredicateBuilder<T> andPredicate = Specifications.<T>and();
        PredicateBuilder<T> orPredicate = Specifications.<T>or();


        //获取条件
        List<Filter> orFilter = query.getOrFilter();
        List<Filter> andFilter = query.getAndFilter();


        //解析Search
        Search search = query.getSearch();
        if(search != null && !StringUtils.isEmpty(search.getFields()) &&  !StringUtils.isEmpty(search.getValue())){
            String[] fields = search.getFields().split(",");
            for (String field : fields) {
                orFilter.add(Filter.like(field,search.getValue()));
            }
        }

        //生成Predicate
        toPredicate(andFilter,andPredicate);

        toPredicate(orFilter,orPredicate);

        //条件合并
        if(orFilter.size() ==  0 && andFilter.size() > 0){
            return andPredicate.build();
        }else if(andFilter.size() == 0 && orFilter.size() > 0){
            return orPredicate.build();
        }else if(andFilter.size() == 0 && orFilter.size() == 0){
            return null;
        }else{
            return andPredicate.predicate(orPredicate.build()).build();
        }
    }

    /**
     * 生成排序和分页对象
     * @param query
     * @return
     */
    public Pageable buildPageable(Query query) {
        //生成排序条件
        if(!CollectionUtils.isEmpty(query.getSorts())){
            Sorts.Builder builder = Sorts.builder();
            for (Sort sort : query.getSorts()) {
                if(sort.getDir() == Sort.Dir.asc){
                    builder.asc(sort.getField());
                }else{
                    builder.desc(sort.getField());
                }
            }
            return new PageRequest(query.getPage(),query.getPageSize(),builder.build());
        }else{
            return new PageRequest(query.getPage(),query.getPageSize());
        }
    }


    /**
     * 生成排序和分页对象
     * @param query
     * @return
     */
    public org.springframework.data.domain.Sort buildSort(Query query) {
        //生成排序条件
        if(!CollectionUtils.isEmpty(query.getSorts())) {
            Sorts.Builder builder = Sorts.builder();
            for (Sort sort : query.getSorts()) {
                if (sort.getDir() == Sort.Dir.asc) {
                    builder.asc(sort.getField());
                } else {
                    builder.desc(sort.getField());
                }
            }
            return builder.build();
        }
        return null;
    }
}
