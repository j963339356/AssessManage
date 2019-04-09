package com.wjc.assess.utils.controller.dto;

import java.util.List;

public class ReturnList {
    int totalcount;
    List items;

    public ReturnList(int totalcount, List items) {
        this.totalcount = totalcount;
        this.items = items;
    }

    public int getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(int totalcount) {
        this.totalcount = totalcount;
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }
}
