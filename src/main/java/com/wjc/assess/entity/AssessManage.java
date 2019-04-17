package com.wjc.assess.entity;

import java.util.Date;

public class AssessManage {
    private String id;

    private Integer year;

    private String city;

    private String county;

    private String province;

    private String orgCode;

    private String orgName;

    private String writerId;

    private String writerName;

    private String writerPhone;

    private Date writeDate;

    private String level;

    private Integer countyScore;

    private Integer cityScore;

    private Integer provinceScore;

    private Integer status;

    private String backReson;

    private String processName;

    private Date noticeStart;

    private Date noticeEnd;

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

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId == null ? null : writerId.trim();
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName == null ? null : writerName.trim();
    }

    public String getWriterPhone() {
        return writerPhone;
    }

    public void setWriterPhone(String writerPhone) {
        this.writerPhone = writerPhone == null ? null : writerPhone.trim();
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(Date writeDate) {
        this.writeDate = writeDate;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBackReson() {
        return backReson;
    }

    public void setBackReson(String backReson) {
        this.backReson = backReson == null ? null : backReson.trim();
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName == null ? null : processName.trim();
    }

    public Date getNoticeStart() {
        return noticeStart;
    }

    public void setNoticeStart(Date noticeStart) {
        this.noticeStart = noticeStart;
    }

    public Date getNoticeEnd() {
        return noticeEnd;
    }

    public void setNoticeEnd(Date noticeEnd) {
        this.noticeEnd = noticeEnd;
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