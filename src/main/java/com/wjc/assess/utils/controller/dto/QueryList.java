package com.wjc.assess.utils.controller.dto;

public class QueryList {
    public Object queryData;    //查询条件
    public int page;        //页数
    public int size;        //条数

    public Object getQueryData() {
        return queryData;
    }

    public void setQueryData(Object queryData) {
        this.queryData = queryData;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
