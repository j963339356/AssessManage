package com.wjc.assess.utils.controller.dto;

public class CommonRequest {
    public int page;    //页数
    public int rows;    //条数
    public Object body;         //请求体

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
