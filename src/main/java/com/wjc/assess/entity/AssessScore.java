package com.wjc.assess.entity;

import java.util.Date;

public class AssessScore {
    private String id;

    private String name;

    private String meansure;

    private String p;

    private String targetExplain;

    private Integer level;

    private String remark;

    private Integer countyScore;

    private Integer cityScore;

    private Integer provinceScore;

    private Integer year;

    private String city;

    private String county;

    private String province;

    private Integer orgCode;

    private String ogrName;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMeansure() {
        return meansure;
    }

    public void setMeansure(String meansure) {
        this.meansure = meansure == null ? null : meansure.trim();
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p == null ? null : p.trim();
    }

    public String getTargetExplain() {
        return targetExplain;
    }

    public void setTargetExplain(String targetExplain) {
        this.targetExplain = targetExplain == null ? null : targetExplain.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getCountyScore() {
        return countyScore;
    }

    public void setCountyScore(Integer countyScore) {
        this.countyScore = countyScore;
    }

    public Integer getCityScore() {
        return cityScore;
    }

    public void setCityScore(Integer cityScore) {
        this.cityScore = cityScore;
    }

    public Integer getProvinceScore() {
        return provinceScore;
    }

    public void setProvinceScore(Integer provinceScore) {
        this.provinceScore = provinceScore;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    public Integer getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(Integer orgCode) {
        this.orgCode = orgCode;
    }

    public String getOgrName() {
        return ogrName;
    }

    public void setOgrName(String ogrName) {
        this.ogrName = ogrName == null ? null : ogrName.trim();
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