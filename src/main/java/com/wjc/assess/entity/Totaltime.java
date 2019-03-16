package com.wjc.assess.entity;

import java.util.Date;

public class Totaltime {
    private Integer id;

    private String title;

    private Date mytime;

    private Date mydate;

    private Date mystamtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getMytime() {
        return mytime;
    }

    public void setMytime(Date mytime) {
        this.mytime = mytime;
    }

    public Date getMydate() {
        return mydate;
    }

    public void setMydate(Date mydate) {
        this.mydate = mydate;
    }

    public Date getMystamtime() {
        return mystamtime;
    }

    public void setMystamtime(Date mystamtime) {
        this.mystamtime = mystamtime;
    }
}