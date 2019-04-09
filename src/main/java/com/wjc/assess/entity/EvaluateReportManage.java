package com.wjc.assess.entity;

import java.util.Date;

public class EvaluateReportManage {
    private String id;

    private Integer year;

    private String reportAddr;

    private String orgName;

    private String orgCode;

    private String sysCreateName;

    private String sysCreateCode;

    private Date sysCreateTime;

    private String sysUpdateName;

    private String sysUpdateCode;

    private Date sysUpdateTime;

    private Integer sysStatus;

    private String reportEvaluate;

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

    public String getReportAddr() {
        return reportAddr;
    }

    public void setReportAddr(String reportAddr) {
        this.reportAddr = reportAddr == null ? null : reportAddr.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
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

    public String getReportEvaluate() {
        return reportEvaluate;
    }

    public void setReportEvaluate(String reportEvaluate) {
        this.reportEvaluate = reportEvaluate == null ? null : reportEvaluate.trim();
    }
}