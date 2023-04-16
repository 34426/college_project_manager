package com.javanoteany.common.query;

/**
 * @author javanoteany
 * @Date 2021-12-12
 * @Description
 * @Version 1.0
 */
public class PageQuery {
    /**
     * 第多少页
     */
    private Integer page = 1;

    /**
     * 一页显示多少数据
     */
    private Integer pageSize = 10;

    public PageQuery(Integer page, Integer pageSize){
        this.setPage(page);
        this.setPageSize(pageSize);
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
        if(pageSize == null){
            pageSize = 10;
        }else if(pageSize <= 0){
            pageSize = 10;
        }
        this.pageSize = pageSize;
    }
}
