package com.fitness.result.page;

import com.fitness.result.SuccessResult;

/**
 * Created on 2017/7/1.
 */
public class PageResult extends SuccessResult {

    private Integer total;

    private int pageNo;

    private int pageSize;

    private int pages;

    private Boolean hasNextPage;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        if (this.getTotal() > 0 && this.pageSize > 0) {

            if (total < pageSize) {
                pages = 1;
            } else {
                pages = (int) Math.ceil(total / Double.valueOf(pageSize));
            }
        } else {
            pages = 0;
        }
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Boolean getHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(Boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public PageResult(Object object, Integer total) {
        super(object);
        this.pageNo = 1;
        this.total = total;
    }

    public PageResult(Object object, int total, int pageNo, int pageSize) {
        super(object);
        this.total = total;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.hasNextPage = total > (pageNo * pageSize);
    }
}
