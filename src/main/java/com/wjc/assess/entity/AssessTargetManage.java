package com.wjc.assess.entity;

import java.util.Date;

public class AssessTargetManage {
    private String id;

    private String assessId;

    private String name;

    private String meansure;

    private String p;

    private String targetExplain;

    private Integer level;

    private String valueType;

    private String remark;

    private String dimension;

    private String orgCode;

    private String ogrName;

    private Boolean isStart;

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

    public String getAssessId() {
        return assessId;
    }

    public void setAssessId(String assessId) {
        this.assessId = assessId == null ? null : assessId.trim();
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

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType == null ? null : valueType.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension == null ? null : dimension.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getOgrName() {
        return ogrName;
    }

    public void setOgrName(String ogrName) {
        this.ogrName = ogrName == null ? null : ogrName.trim();
    }

    public Boolean getIsStart() {
        return isStart;
    }

    public void setIsStart(Boolean isStart) {
        this.isStart = isStart;
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