package com.wjc.assess.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EvaluateReportManageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EvaluateReportManageExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Integer value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Integer value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Integer value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Integer value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Integer value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Integer> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Integer> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Integer value1, Integer value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Integer value1, Integer value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andReportAddrIsNull() {
            addCriterion("reportAddr is null");
            return (Criteria) this;
        }

        public Criteria andReportAddrIsNotNull() {
            addCriterion("reportAddr is not null");
            return (Criteria) this;
        }

        public Criteria andReportAddrEqualTo(String value) {
            addCriterion("reportAddr =", value, "reportAddr");
            return (Criteria) this;
        }

        public Criteria andReportAddrNotEqualTo(String value) {
            addCriterion("reportAddr <>", value, "reportAddr");
            return (Criteria) this;
        }

        public Criteria andReportAddrGreaterThan(String value) {
            addCriterion("reportAddr >", value, "reportAddr");
            return (Criteria) this;
        }

        public Criteria andReportAddrGreaterThanOrEqualTo(String value) {
            addCriterion("reportAddr >=", value, "reportAddr");
            return (Criteria) this;
        }

        public Criteria andReportAddrLessThan(String value) {
            addCriterion("reportAddr <", value, "reportAddr");
            return (Criteria) this;
        }

        public Criteria andReportAddrLessThanOrEqualTo(String value) {
            addCriterion("reportAddr <=", value, "reportAddr");
            return (Criteria) this;
        }

        public Criteria andReportAddrLike(String value) {
            addCriterion("reportAddr like", value, "reportAddr");
            return (Criteria) this;
        }

        public Criteria andReportAddrNotLike(String value) {
            addCriterion("reportAddr not like", value, "reportAddr");
            return (Criteria) this;
        }

        public Criteria andReportAddrIn(List<String> values) {
            addCriterion("reportAddr in", values, "reportAddr");
            return (Criteria) this;
        }

        public Criteria andReportAddrNotIn(List<String> values) {
            addCriterion("reportAddr not in", values, "reportAddr");
            return (Criteria) this;
        }

        public Criteria andReportAddrBetween(String value1, String value2) {
            addCriterion("reportAddr between", value1, value2, "reportAddr");
            return (Criteria) this;
        }

        public Criteria andReportAddrNotBetween(String value1, String value2) {
            addCriterion("reportAddr not between", value1, value2, "reportAddr");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNull() {
            addCriterion("orgName is null");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNotNull() {
            addCriterion("orgName is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNameEqualTo(String value) {
            addCriterion("orgName =", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotEqualTo(String value) {
            addCriterion("orgName <>", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThan(String value) {
            addCriterion("orgName >", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("orgName >=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThan(String value) {
            addCriterion("orgName <", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThanOrEqualTo(String value) {
            addCriterion("orgName <=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLike(String value) {
            addCriterion("orgName like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotLike(String value) {
            addCriterion("orgName not like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameIn(List<String> values) {
            addCriterion("orgName in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotIn(List<String> values) {
            addCriterion("orgName not in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameBetween(String value1, String value2) {
            addCriterion("orgName between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotBetween(String value1, String value2) {
            addCriterion("orgName not between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIsNull() {
            addCriterion("orgCode is null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIsNotNull() {
            addCriterion("orgCode is not null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeEqualTo(String value) {
            addCriterion("orgCode =", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotEqualTo(String value) {
            addCriterion("orgCode <>", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThan(String value) {
            addCriterion("orgCode >", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("orgCode >=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThan(String value) {
            addCriterion("orgCode <", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThanOrEqualTo(String value) {
            addCriterion("orgCode <=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLike(String value) {
            addCriterion("orgCode like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotLike(String value) {
            addCriterion("orgCode not like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIn(List<String> values) {
            addCriterion("orgCode in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotIn(List<String> values) {
            addCriterion("orgCode not in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeBetween(String value1, String value2) {
            addCriterion("orgCode between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotBetween(String value1, String value2) {
            addCriterion("orgCode not between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andSysCreateNameIsNull() {
            addCriterion("sysCreateName is null");
            return (Criteria) this;
        }

        public Criteria andSysCreateNameIsNotNull() {
            addCriterion("sysCreateName is not null");
            return (Criteria) this;
        }

        public Criteria andSysCreateNameEqualTo(String value) {
            addCriterion("sysCreateName =", value, "sysCreateName");
            return (Criteria) this;
        }

        public Criteria andSysCreateNameNotEqualTo(String value) {
            addCriterion("sysCreateName <>", value, "sysCreateName");
            return (Criteria) this;
        }

        public Criteria andSysCreateNameGreaterThan(String value) {
            addCriterion("sysCreateName >", value, "sysCreateName");
            return (Criteria) this;
        }

        public Criteria andSysCreateNameGreaterThanOrEqualTo(String value) {
            addCriterion("sysCreateName >=", value, "sysCreateName");
            return (Criteria) this;
        }

        public Criteria andSysCreateNameLessThan(String value) {
            addCriterion("sysCreateName <", value, "sysCreateName");
            return (Criteria) this;
        }

        public Criteria andSysCreateNameLessThanOrEqualTo(String value) {
            addCriterion("sysCreateName <=", value, "sysCreateName");
            return (Criteria) this;
        }

        public Criteria andSysCreateNameLike(String value) {
            addCriterion("sysCreateName like", value, "sysCreateName");
            return (Criteria) this;
        }

        public Criteria andSysCreateNameNotLike(String value) {
            addCriterion("sysCreateName not like", value, "sysCreateName");
            return (Criteria) this;
        }

        public Criteria andSysCreateNameIn(List<String> values) {
            addCriterion("sysCreateName in", values, "sysCreateName");
            return (Criteria) this;
        }

        public Criteria andSysCreateNameNotIn(List<String> values) {
            addCriterion("sysCreateName not in", values, "sysCreateName");
            return (Criteria) this;
        }

        public Criteria andSysCreateNameBetween(String value1, String value2) {
            addCriterion("sysCreateName between", value1, value2, "sysCreateName");
            return (Criteria) this;
        }

        public Criteria andSysCreateNameNotBetween(String value1, String value2) {
            addCriterion("sysCreateName not between", value1, value2, "sysCreateName");
            return (Criteria) this;
        }

        public Criteria andSysCreateCodeIsNull() {
            addCriterion("sysCreateCode is null");
            return (Criteria) this;
        }

        public Criteria andSysCreateCodeIsNotNull() {
            addCriterion("sysCreateCode is not null");
            return (Criteria) this;
        }

        public Criteria andSysCreateCodeEqualTo(String value) {
            addCriterion("sysCreateCode =", value, "sysCreateCode");
            return (Criteria) this;
        }

        public Criteria andSysCreateCodeNotEqualTo(String value) {
            addCriterion("sysCreateCode <>", value, "sysCreateCode");
            return (Criteria) this;
        }

        public Criteria andSysCreateCodeGreaterThan(String value) {
            addCriterion("sysCreateCode >", value, "sysCreateCode");
            return (Criteria) this;
        }

        public Criteria andSysCreateCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sysCreateCode >=", value, "sysCreateCode");
            return (Criteria) this;
        }

        public Criteria andSysCreateCodeLessThan(String value) {
            addCriterion("sysCreateCode <", value, "sysCreateCode");
            return (Criteria) this;
        }

        public Criteria andSysCreateCodeLessThanOrEqualTo(String value) {
            addCriterion("sysCreateCode <=", value, "sysCreateCode");
            return (Criteria) this;
        }

        public Criteria andSysCreateCodeLike(String value) {
            addCriterion("sysCreateCode like", value, "sysCreateCode");
            return (Criteria) this;
        }

        public Criteria andSysCreateCodeNotLike(String value) {
            addCriterion("sysCreateCode not like", value, "sysCreateCode");
            return (Criteria) this;
        }

        public Criteria andSysCreateCodeIn(List<String> values) {
            addCriterion("sysCreateCode in", values, "sysCreateCode");
            return (Criteria) this;
        }

        public Criteria andSysCreateCodeNotIn(List<String> values) {
            addCriterion("sysCreateCode not in", values, "sysCreateCode");
            return (Criteria) this;
        }

        public Criteria andSysCreateCodeBetween(String value1, String value2) {
            addCriterion("sysCreateCode between", value1, value2, "sysCreateCode");
            return (Criteria) this;
        }

        public Criteria andSysCreateCodeNotBetween(String value1, String value2) {
            addCriterion("sysCreateCode not between", value1, value2, "sysCreateCode");
            return (Criteria) this;
        }

        public Criteria andSysCreateTimeIsNull() {
            addCriterion("sysCreateTime is null");
            return (Criteria) this;
        }

        public Criteria andSysCreateTimeIsNotNull() {
            addCriterion("sysCreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andSysCreateTimeEqualTo(Date value) {
            addCriterion("sysCreateTime =", value, "sysCreateTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateTimeNotEqualTo(Date value) {
            addCriterion("sysCreateTime <>", value, "sysCreateTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateTimeGreaterThan(Date value) {
            addCriterion("sysCreateTime >", value, "sysCreateTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sysCreateTime >=", value, "sysCreateTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateTimeLessThan(Date value) {
            addCriterion("sysCreateTime <", value, "sysCreateTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("sysCreateTime <=", value, "sysCreateTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateTimeIn(List<Date> values) {
            addCriterion("sysCreateTime in", values, "sysCreateTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateTimeNotIn(List<Date> values) {
            addCriterion("sysCreateTime not in", values, "sysCreateTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateTimeBetween(Date value1, Date value2) {
            addCriterion("sysCreateTime between", value1, value2, "sysCreateTime");
            return (Criteria) this;
        }

        public Criteria andSysCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("sysCreateTime not between", value1, value2, "sysCreateTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdateNameIsNull() {
            addCriterion("sysUpdateName is null");
            return (Criteria) this;
        }

        public Criteria andSysUpdateNameIsNotNull() {
            addCriterion("sysUpdateName is not null");
            return (Criteria) this;
        }

        public Criteria andSysUpdateNameEqualTo(String value) {
            addCriterion("sysUpdateName =", value, "sysUpdateName");
            return (Criteria) this;
        }

        public Criteria andSysUpdateNameNotEqualTo(String value) {
            addCriterion("sysUpdateName <>", value, "sysUpdateName");
            return (Criteria) this;
        }

        public Criteria andSysUpdateNameGreaterThan(String value) {
            addCriterion("sysUpdateName >", value, "sysUpdateName");
            return (Criteria) this;
        }

        public Criteria andSysUpdateNameGreaterThanOrEqualTo(String value) {
            addCriterion("sysUpdateName >=", value, "sysUpdateName");
            return (Criteria) this;
        }

        public Criteria andSysUpdateNameLessThan(String value) {
            addCriterion("sysUpdateName <", value, "sysUpdateName");
            return (Criteria) this;
        }

        public Criteria andSysUpdateNameLessThanOrEqualTo(String value) {
            addCriterion("sysUpdateName <=", value, "sysUpdateName");
            return (Criteria) this;
        }

        public Criteria andSysUpdateNameLike(String value) {
            addCriterion("sysUpdateName like", value, "sysUpdateName");
            return (Criteria) this;
        }

        public Criteria andSysUpdateNameNotLike(String value) {
            addCriterion("sysUpdateName not like", value, "sysUpdateName");
            return (Criteria) this;
        }

        public Criteria andSysUpdateNameIn(List<String> values) {
            addCriterion("sysUpdateName in", values, "sysUpdateName");
            return (Criteria) this;
        }

        public Criteria andSysUpdateNameNotIn(List<String> values) {
            addCriterion("sysUpdateName not in", values, "sysUpdateName");
            return (Criteria) this;
        }

        public Criteria andSysUpdateNameBetween(String value1, String value2) {
            addCriterion("sysUpdateName between", value1, value2, "sysUpdateName");
            return (Criteria) this;
        }

        public Criteria andSysUpdateNameNotBetween(String value1, String value2) {
            addCriterion("sysUpdateName not between", value1, value2, "sysUpdateName");
            return (Criteria) this;
        }

        public Criteria andSysUpdateCodeIsNull() {
            addCriterion("sysUpdateCode is null");
            return (Criteria) this;
        }

        public Criteria andSysUpdateCodeIsNotNull() {
            addCriterion("sysUpdateCode is not null");
            return (Criteria) this;
        }

        public Criteria andSysUpdateCodeEqualTo(String value) {
            addCriterion("sysUpdateCode =", value, "sysUpdateCode");
            return (Criteria) this;
        }

        public Criteria andSysUpdateCodeNotEqualTo(String value) {
            addCriterion("sysUpdateCode <>", value, "sysUpdateCode");
            return (Criteria) this;
        }

        public Criteria andSysUpdateCodeGreaterThan(String value) {
            addCriterion("sysUpdateCode >", value, "sysUpdateCode");
            return (Criteria) this;
        }

        public Criteria andSysUpdateCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sysUpdateCode >=", value, "sysUpdateCode");
            return (Criteria) this;
        }

        public Criteria andSysUpdateCodeLessThan(String value) {
            addCriterion("sysUpdateCode <", value, "sysUpdateCode");
            return (Criteria) this;
        }

        public Criteria andSysUpdateCodeLessThanOrEqualTo(String value) {
            addCriterion("sysUpdateCode <=", value, "sysUpdateCode");
            return (Criteria) this;
        }

        public Criteria andSysUpdateCodeLike(String value) {
            addCriterion("sysUpdateCode like", value, "sysUpdateCode");
            return (Criteria) this;
        }

        public Criteria andSysUpdateCodeNotLike(String value) {
            addCriterion("sysUpdateCode not like", value, "sysUpdateCode");
            return (Criteria) this;
        }

        public Criteria andSysUpdateCodeIn(List<String> values) {
            addCriterion("sysUpdateCode in", values, "sysUpdateCode");
            return (Criteria) this;
        }

        public Criteria andSysUpdateCodeNotIn(List<String> values) {
            addCriterion("sysUpdateCode not in", values, "sysUpdateCode");
            return (Criteria) this;
        }

        public Criteria andSysUpdateCodeBetween(String value1, String value2) {
            addCriterion("sysUpdateCode between", value1, value2, "sysUpdateCode");
            return (Criteria) this;
        }

        public Criteria andSysUpdateCodeNotBetween(String value1, String value2) {
            addCriterion("sysUpdateCode not between", value1, value2, "sysUpdateCode");
            return (Criteria) this;
        }

        public Criteria andSysUpdateTimeIsNull() {
            addCriterion("sysUpdateTime is null");
            return (Criteria) this;
        }

        public Criteria andSysUpdateTimeIsNotNull() {
            addCriterion("sysUpdateTime is not null");
            return (Criteria) this;
        }

        public Criteria andSysUpdateTimeEqualTo(Date value) {
            addCriterion("sysUpdateTime =", value, "sysUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdateTimeNotEqualTo(Date value) {
            addCriterion("sysUpdateTime <>", value, "sysUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdateTimeGreaterThan(Date value) {
            addCriterion("sysUpdateTime >", value, "sysUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sysUpdateTime >=", value, "sysUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdateTimeLessThan(Date value) {
            addCriterion("sysUpdateTime <", value, "sysUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("sysUpdateTime <=", value, "sysUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdateTimeIn(List<Date> values) {
            addCriterion("sysUpdateTime in", values, "sysUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdateTimeNotIn(List<Date> values) {
            addCriterion("sysUpdateTime not in", values, "sysUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("sysUpdateTime between", value1, value2, "sysUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSysUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("sysUpdateTime not between", value1, value2, "sysUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSysStatusIsNull() {
            addCriterion("sysStatus is null");
            return (Criteria) this;
        }

        public Criteria andSysStatusIsNotNull() {
            addCriterion("sysStatus is not null");
            return (Criteria) this;
        }

        public Criteria andSysStatusEqualTo(Integer value) {
            addCriterion("sysStatus =", value, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusNotEqualTo(Integer value) {
            addCriterion("sysStatus <>", value, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusGreaterThan(Integer value) {
            addCriterion("sysStatus >", value, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("sysStatus >=", value, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusLessThan(Integer value) {
            addCriterion("sysStatus <", value, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusLessThanOrEqualTo(Integer value) {
            addCriterion("sysStatus <=", value, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusIn(List<Integer> values) {
            addCriterion("sysStatus in", values, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusNotIn(List<Integer> values) {
            addCriterion("sysStatus not in", values, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusBetween(Integer value1, Integer value2) {
            addCriterion("sysStatus between", value1, value2, "sysStatus");
            return (Criteria) this;
        }

        public Criteria andSysStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("sysStatus not between", value1, value2, "sysStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}