package com.wjc.assess.entity;

import java.util.Date;

public class User {
    private String id;

    private String countId;

    private String username;

    private String password;

    private String name;

    private String email;

    private String phone;

    private String city;

    private String county;

    private String province;

    private Integer sex;

    private String orgName;

    private Integer orgCode;

    private String sysCreateName;

    private String sysCreateCode;

    private Date sysCreateTime;

    private String sysUpdateName;

    private String sysUpdateCode;

    private Date sysUpdateTime;

    private Integer sysStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCountId() {
        return countId;
    }

    public void setCountId(String countId) {
        this.countId = countId == null ? null : countId.trim();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public Integer getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(Integer orgCode) {
        this.orgCode = orgCode;
    }

    public String getSysCreateName() {
        return sysCreateName;
    }

    public void setSysCreateName(String sysCreateName) {
        this.sysCreateName = sysCreateName == null ? null : sysCreateName.trim();
    }

    public String getSysCreateCode() {
        return sysCreateCode;
    }

    public void setSysCreateCode(String sysCreateCode) {
        this.sysCreateCode = sysCreateCode == null ? null : sysCreateCode.trim();
    }

    public Date getSysCreateTime() {
        return sysCreateTime;
    }

    public void setSysCreateTime(Date sysCreateTime) {
        this.sysCreateTime = sysCreateTime;
    }

    public String getSysUpdateName() {
        return sysUpdateName;
    }

    public void setSysUpdateName(String sysUpdateName) {
        this.sysUpdateName = sysUpdateName == null ? null : sysUpdateName.trim();
    }

    public String getSysUpdateCode() {
        return sysUpdateCode;
    }

    public void setSysUpdateCode(String sysUpdateCode) {
        this.sysUpdateCode = sysUpdateCode == null ? null : sysUpdateCode.trim();
    }

    public Date getSysUpdateTime() {
        return sysUpdateTime;
    }

    public void setSysUpdateTime(Date sysUpdateTime) {
        this.sysUpdateTime = sysUpdateTime;
    }

    public Integer getSysStatus() {
        return sysStatus;
    }

    public void setSysStatus(Integer sysStatus) {
        this.sysStatus = sysStatus;
    }
}