package com.javanoteany.common.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class Query implements Serializable{

    /**
     * 第多少页
     */
    private Integer page = 1;

    /**
     * 不分页
     */
    private boolean noPage;

    /**
     * 一页显示多少数据
     */
    private Integer pageSize = 10;

    /**
     * 多字段模糊查询
     */
    private Search search;

    /**
     * 拼装And条件
     */
    private List<Filter> filters = new ArrayList<Filter>();

    /**
     * 拼装查询条件
     */
    private List<Sort> sorts;

    private Class resultType;

    /**
     * 连接条件
     */
    private Logic logic = Logic.and;

    public void addSort(Sort.Dir dir,String field){
        if(sorts == null){
            sorts = new ArrayList<>();
        }
        Sort sort = new Sort();
        sort.setDir(Sort.Dir.desc);
        sort.setField(field);
        sorts.add(sort);
    }

    /**
     * 生成条件
     */
    public void generateCondition(){

    }

    public void addFilter(Filter filter){
        filters.add(filter);
    }

    public Integer getPage() {
        if(page <= 1){
            return 0;
        }
        return page-1;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    public List<Sort> getSorts() {
        return sorts;
    }

    public void setSorts(List<Sort> sorts) {
        this.sorts = sorts;
    }

    public Logic getLogic() {
        return logic;
    }

    public void setLogic(Logic logic) {
        this.logic = logic;
    }

    public List<Filter> getOrFilter(){
        List<Filter> orFilters = new ArrayList<>();
        for (Filter filter : filters) {
            if(filter.getLogic() != Logic.and){
                if(filter.getLogic() != null && filter.getLogic() == Logic.or){
                    orFilters.add(filter);
                }else if(logic.equals(Logic.or)){
                    orFilters.add(filter);
                }
            }
        }
        return orFilters;
    }

    public List<Filter> getAndFilter(){
        List<Filter> andFilters = new ArrayList<>();
        for (Filter filter : filters) {
            if(filter.getLogic() != Logic.or){
                if(filter.getLogic() == Logic.and){
                    andFilters.add(filter);
                }else if(logic.equals(Logic.and)){
                    andFilters.add(filter);
                }
            }
        }
        return andFilters;
    }

    public Class getResultType() {
        return resultType;
    }

    public void setResultType(Class resultType) {
        this.resultType = resultType;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    public boolean isNoPage() {
        return noPage;
    }

    public void setNoPage(boolean noPage) {
        this.noPage = noPage;
    }
}
