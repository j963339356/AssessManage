package com.wjc.assess.entity;

import java.util.Date;

public class Account {
    private String id;

    private String username;

    private String password;

    private Date syscreatetime;

    private Date sysupdatetime;

    private Integer sysstatics;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getSyscreatetime() {
        return syscreatetime;
    }

    public void setSyscreatetime(Date syscreatetime) {
        this.syscreatetime = syscreatetime;
    }

    public Date getSysupdatetime() {
        return sysupdatetime;
    }

    public void setSysupdatetime(Date sysupdatetime) {
        this.sysupdatetime = sysupdatetime;
    }

    public Integer getSysstatics() {
        return sysstatics;
    }

    public void setSysstatics(Integer sysstatics) {
        this.sysstatics = sysstatics;
    }
}