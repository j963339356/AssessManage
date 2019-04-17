package com.wjc.assess.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssessManageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssessManageExample() {
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

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCountyIsNull() {
            addCriterion("county is null");
            return (Criteria) this;
        }

        public Criteria andCountyIsNotNull() {
            addCriterion("county is not null");
            return (Criteria) this;
        }

        public Criteria andCountyEqualTo(String value) {
            addCriterion("county =", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotEqualTo(String value) {
            addCriterion("county <>", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThan(String value) {
            addCriterion("county >", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThanOrEqualTo(String value) {
            addCriterion("county >=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThan(String value) {
            addCriterion("county <", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThanOrEqualTo(String value) {
            addCriterion("county <=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLike(String value) {
            addCriterion("county like", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotLike(String value) {
            addCriterion("county not like", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyIn(List<String> values) {
            addCriterion("county in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotIn(List<String> values) {
            addCriterion("county not in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyBetween(String value1, String value2) {
            addCriterion("county between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotBetween(String value1, String value2) {
            addCriterion("county not between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
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

        public Criteria andWriterIdIsNull() {
            addCriterion("writerId is null");
            return (Criteria) this;
        }

        public Criteria andWriterIdIsNotNull() {
            addCriterion("writerId is not null");
            return (Criteria) this;
        }

        public Criteria andWriterIdEqualTo(String value) {
            addCriterion("writerId =", value, "writerId");
            return (Criteria) this;
        }

        public Criteria andWriterIdNotEqualTo(String value) {
            addCriterion("writerId <>", value, "writerId");
            return (Criteria) this;
        }

        public Criteria andWriterIdGreaterThan(String value) {
            addCriterion("writerId >", value, "writerId");
            return (Criteria) this;
        }

        public Criteria andWriterIdGreaterThanOrEqualTo(String value) {
            addCriterion("writerId >=", value, "writerId");
            return (Criteria) this;
        }

        public Criteria andWriterIdLessThan(String value) {
            addCriterion("writerId <", value, "writerId");
            return (Criteria) this;
        }

        public Criteria andWriterIdLessThanOrEqualTo(String value) {
            addCriterion("writerId <=", value, "writerId");
            return (Criteria) this;
        }

        public Criteria andWriterIdLike(String value) {
            addCriterion("writerId like", value, "writerId");
            return (Criteria) this;
        }

        public Criteria andWriterIdNotLike(String value) {
            addCriterion("writerId not like", value, "writerId");
            return (Criteria) this;
        }

        public Criteria andWriterIdIn(List<String> values) {
            addCriterion("writerId in", values, "writerId");
            return (Criteria) this;
        }

        public Criteria andWriterIdNotIn(List<String> values) {
            addCriterion("writerId not in", values, "writerId");
            return (Criteria) this;
        }

        public Criteria andWriterIdBetween(String value1, String value2) {
            addCriterion("writerId between", value1, value2, "writerId");
            return (Criteria) this;
        }

        public Criteria andWriterIdNotBetween(String value1, String value2) {
            addCriterion("writerId not between", value1, value2, "writerId");
            return (Criteria) this;
        }

        public Criteria andWriterNameIsNull() {
            addCriterion("writerName is null");
            return (Criteria) this;
        }

        public Criteria andWriterNameIsNotNull() {
            addCriterion("writerName is not null");
            return (Criteria) this;
        }

        public Criteria andWriterNameEqualTo(String value) {
            addCriterion("writerName =", value, "writerName");
            return (Criteria) this;
        }

        public Criteria andWriterNameNotEqualTo(String value) {
            addCriterion("writerName <>", value, "writerName");
            return (Criteria) this;
        }

        public Criteria andWriterNameGreaterThan(String value) {
            addCriterion("writerName >", value, "writerName");
            return (Criteria) this;
        }

        public Criteria andWriterNameGreaterThanOrEqualTo(String value) {
            addCriterion("writerName >=", value, "writerName");
            return (Criteria) this;
        }

        public Criteria andWriterNameLessThan(String value) {
            addCriterion("writerName <", value, "writerName");
            return (Criteria) this;
        }

        public Criteria andWriterNameLessThanOrEqualTo(String value) {
            addCriterion("writerName <=", value, "writerName");
            return (Criteria) this;
        }

        public Criteria andWriterNameLike(String value) {
            addCriterion("writerName like", value, "writerName");
            return (Criteria) this;
        }

        public Criteria andWriterNameNotLike(String value) {
            addCriterion("writerName not like", value, "writerName");
            return (Criteria) this;
        }

        public Criteria andWriterNameIn(List<String> values) {
            addCriterion("writerName in", values, "writerName");
            return (Criteria) this;
        }

        public Criteria andWriterNameNotIn(List<String> values) {
            addCriterion("writerName not in", values, "writerName");
            return (Criteria) this;
        }

        public Criteria andWriterNameBetween(String value1, String value2) {
            addCriterion("writerName between", value1, value2, "writerName");
            return (Criteria) this;
        }

        public Criteria andWriterNameNotBetween(String value1, String value2) {
            addCriterion("writerName not between", value1, value2, "writerName");
            return (Criteria) this;
        }

        public Criteria andWriterPhoneIsNull() {
            addCriterion("writerPhone is null");
            return (Criteria) this;
        }

        public Criteria andWriterPhoneIsNotNull() {
            addCriterion("writerPhone is not null");
            return (Criteria) this;
        }

        public Criteria andWriterPhoneEqualTo(String value) {
            addCriterion("writerPhone =", value, "writerPhone");
            return (Criteria) this;
        }

        public Criteria andWriterPhoneNotEqualTo(String value) {
            addCriterion("writerPhone <>", value, "writerPhone");
            return (Criteria) this;
        }

        public Criteria andWriterPhoneGreaterThan(String value) {
            addCriterion("writerPhone >", value, "writerPhone");
            return (Criteria) this;
        }

        public Criteria andWriterPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("writerPhone >=", value, "writerPhone");
            return (Criteria) this;
        }

        public Criteria andWriterPhoneLessThan(String value) {
            addCriterion("writerPhone <", value, "writerPhone");
            return (Criteria) this;
        }

        public Criteria andWriterPhoneLessThanOrEqualTo(String value) {
            addCriterion("writerPhone <=", value, "writerPhone");
            return (Criteria) this;
        }

        public Criteria andWriterPhoneLike(String value) {
            addCriterion("writerPhone like", value, "writerPhone");
            return (Criteria) this;
        }

        public Criteria andWriterPhoneNotLike(String value) {
            addCriterion("writerPhone not like", value, "writerPhone");
            return (Criteria) this;
        }

        public Criteria andWriterPhoneIn(List<String> values) {
            addCriterion("writerPhone in", values, "writerPhone");
            return (Criteria) this;
        }

        public Criteria andWriterPhoneNotIn(List<String> values) {
            addCriterion("writerPhone not in", values, "writerPhone");
            return (Criteria) this;
        }

        public Criteria andWriterPhoneBetween(String value1, String value2) {
            addCriterion("writerPhone between", value1, value2, "writerPhone");
            return (Criteria) this;
        }

        public Criteria andWriterPhoneNotBetween(String value1, String value2) {
            addCriterion("writerPhone not between", value1, value2, "writerPhone");
            return (Criteria) this;
        }

        public Criteria andWriteDateIsNull() {
            addCriterion("writeDate is null");
            return (Criteria) this;
        }

        public Criteria andWriteDateIsNotNull() {
            addCriterion("writeDate is not null");
            return (Criteria) this;
        }

        public Criteria andWriteDateEqualTo(Date value) {
            addCriterion("writeDate =", value, "writeDate");
            return (Criteria) this;
        }

        public Criteria andWriteDateNotEqualTo(Date value) {
            addCriterion("writeDate <>", value, "writeDate");
            return (Criteria) this;
        }

        public Criteria andWriteDateGreaterThan(Date value) {
            addCriterion("writeDate >", value, "writeDate");
            return (Criteria) this;
        }

        public Criteria andWriteDateGreaterThanOrEqualTo(Date value) {
            addCriterion("writeDate >=", value, "writeDate");
            return (Criteria) this;
        }

        public Criteria andWriteDateLessThan(Date value) {
            addCriterion("writeDate <", value, "writeDate");
            return (Criteria) this;
        }

        public Criteria andWriteDateLessThanOrEqualTo(Date value) {
            addCriterion("writeDate <=", value, "writeDate");
            return (Criteria) this;
        }

        public Criteria andWriteDateIn(List<Date> values) {
            addCriterion("writeDate in", values, "writeDate");
            return (Criteria) this;
        }

        public Criteria andWriteDateNotIn(List<Date> values) {
            addCriterion("writeDate not in", values, "writeDate");
            return (Criteria) this;
        }

        public Criteria andWriteDateBetween(Date value1, Date value2) {
            addCriterion("writeDate between", value1, value2, "writeDate");
            return (Criteria) this;
        }

        public Criteria andWriteDateNotBetween(Date value1, Date value2) {
            addCriterion("writeDate not between", value1, value2, "writeDate");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andCountyScoreIsNull() {
            addCriterion("countyScore is null");
            return (Criteria) this;
        }

        public Criteria andCountyScoreIsNotNull() {
            addCriterion("countyScore is not null");
            return (Criteria) this;
        }

        public Criteria andCountyScoreEqualTo(Integer value) {
            addCriterion("countyScore =", value, "countyScore");
            return (Criteria) this;
        }

        public Criteria andCountyScoreNotEqualTo(Integer value) {
            addCriterion("countyScore <>", value, "countyScore");
            return (Criteria) this;
        }

        public Criteria andCountyScoreGreaterThan(Integer value) {
            addCriterion("countyScore >", value, "countyScore");
            return (Criteria) this;
        }

        public Criteria andCountyScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("countyScore >=", value, "countyScore");
            return (Criteria) this;
        }

        public Criteria andCountyScoreLessThan(Integer value) {
            addCriterion("countyScore <", value, "countyScore");
            return (Criteria) this;
        }

        public Criteria andCountyScoreLessThanOrEqualTo(Integer value) {
            addCriterion("countyScore <=", value, "countyScore");
            return (Criteria) this;
        }

        public Criteria andCountyScoreIn(List<Integer> values) {
            addCriterion("countyScore in", values, "countyScore");
            return (Criteria) this;
        }

        public Criteria andCountyScoreNotIn(List<Integer> values) {
            addCriterion("countyScore not in", values, "countyScore");
            return (Criteria) this;
        }

        public Criteria andCountyScoreBetween(Integer value1, Integer value2) {
            addCriterion("countyScore between", value1, value2, "countyScore");
            return (Criteria) this;
        }

        public Criteria andCountyScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("countyScore not between", value1, value2, "countyScore");
            return (Criteria) this;
        }

        public Criteria andCityScoreIsNull() {
            addCriterion("cityScore is null");
            return (Criteria) this;
        }

        public Criteria andCityScoreIsNotNull() {
            addCriterion("cityScore is not null");
            return (Criteria) this;
        }

        public Criteria andCityScoreEqualTo(Integer value) {
            addCriterion("cityScore =", value, "cityScore");
            return (Criteria) this;
        }

        public Criteria andCityScoreNotEqualTo(Integer value) {
            addCriterion("cityScore <>", value, "cityScore");
            return (Criteria) this;
        }

        public Criteria andCityScoreGreaterThan(Integer value) {
            addCriterion("cityScore >", value, "cityScore");
            return (Criteria) this;
        }

        public Criteria andCityScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("cityScore >=", value, "cityScore");
            return (Criteria) this;
        }

        public Criteria andCityScoreLessThan(Integer value) {
            addCriterion("cityScore <", value, "cityScore");
            return (Criteria) this;
        }

        public Criteria andCityScoreLessThanOrEqualTo(Integer value) {
            addCriterion("cityScore <=", value, "cityScore");
            return (Criteria) this;
        }

        public Criteria andCityScoreIn(List<Integer> values) {
            addCriterion("cityScore in", values, "cityScore");
            return (Criteria) this;
        }

        public Criteria andCityScoreNotIn(List<Integer> values) {
            addCriterion("cityScore not in", values, "cityScore");
            return (Criteria) this;
        }

        public Criteria andCityScoreBetween(Integer value1, Integer value2) {
            addCriterion("cityScore between", value1, value2, "cityScore");
            return (Criteria) this;
        }

        public Criteria andCityScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("cityScore not between", value1, value2, "cityScore");
            return (Criteria) this;
        }

        public Criteria andProvinceScoreIsNull() {
            addCriterion("provinceScore is null");
            return (Criteria) this;
        }

        public Criteria andProvinceScoreIsNotNull() {
            addCriterion("provinceScore is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceScoreEqualTo(Integer value) {
            addCriterion("provinceScore =", value, "provinceScore");
            return (Criteria) this;
        }

        public Criteria andProvinceScoreNotEqualTo(Integer value) {
            addCriterion("provinceScore <>", value, "provinceScore");
            return (Criteria) this;
        }

        public Criteria andProvinceScoreGreaterThan(Integer value) {
            addCriterion("provinceScore >", value, "provinceScore");
            return (Criteria) this;
        }

        public Criteria andProvinceScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("provinceScore >=", value, "provinceScore");
            return (Criteria) this;
        }

        public Criteria andProvinceScoreLessThan(Integer value) {
            addCriterion("provinceScore <", value, "provinceScore");
            return (Criteria) this;
        }

        public Criteria andProvinceScoreLessThanOrEqualTo(Integer value) {
            addCriterion("provinceScore <=", value, "provinceScore");
            return (Criteria) this;
        }

        public Criteria andProvinceScoreIn(List<Integer> values) {
            addCriterion("provinceScore in", values, "provinceScore");
            return (Criteria) this;
        }

        public Criteria andProvinceScoreNotIn(List<Integer> values) {
            addCriterion("provinceScore not in", values, "provinceScore");
            return (Criteria) this;
        }

        public Criteria andProvinceScoreBetween(Integer value1, Integer value2) {
            addCriterion("provinceScore between", value1, value2, "provinceScore");
            return (Criteria) this;
        }

        public Criteria andProvinceScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("provinceScore not between", value1, value2, "provinceScore");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andBackResonIsNull() {
            addCriterion("backReson is null");
            return (Criteria) this;
        }

        public Criteria andBackResonIsNotNull() {
            addCriterion("backReson is not null");
            return (Criteria) this;
        }

        public Criteria andBackResonEqualTo(String value) {
            addCriterion("backReson =", value, "backReson");
            return (Criteria) this;
        }

        public Criteria andBackResonNotEqualTo(String value) {
            addCriterion("backReson <>", value, "backReson");
            return (Criteria) this;
        }

        public Criteria andBackResonGreaterThan(String value) {
            addCriterion("backReson >", value, "backReson");
            return (Criteria) this;
        }

        public Criteria andBackResonGreaterThanOrEqualTo(String value) {
            addCriterion("backReson >=", value, "backReson");
            return (Criteria) this;
        }

        public Criteria andBackResonLessThan(String value) {
            addCriterion("backReson <", value, "backReson");
            return (Criteria) this;
        }

        public Criteria andBackResonLessThanOrEqualTo(String value) {
            addCriterion("backReson <=", value, "backReson");
            return (Criteria) this;
        }

        public Criteria andBackResonLike(String value) {
            addCriterion("backReson like", value, "backReson");
            return (Criteria) this;
        }

        public Criteria andBackResonNotLike(String value) {
            addCriterion("backReson not like", value, "backReson");
            return (Criteria) this;
        }

        public Criteria andBackResonIn(List<String> values) {
            addCriterion("backReson in", values, "backReson");
            return (Criteria) this;
        }

        public Criteria andBackResonNotIn(List<String> values) {
            addCriterion("backReson not in", values, "backReson");
            return (Criteria) this;
        }

        public Criteria andBackResonBetween(String value1, String value2) {
            addCriterion("backReson between", value1, value2, "backReson");
            return (Criteria) this;
        }

        public Criteria andBackResonNotBetween(String value1, String value2) {
            addCriterion("backReson not between", value1, value2, "backReson");
            return (Criteria) this;
        }

        public Criteria andProcessNameIsNull() {
            addCriterion("processName is null");
            return (Criteria) this;
        }

        public Criteria andProcessNameIsNotNull() {
            addCriterion("processName is not null");
            return (Criteria) this;
        }

        public Criteria andProcessNameEqualTo(String value) {
            addCriterion("processName =", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotEqualTo(String value) {
            addCriterion("processName <>", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameGreaterThan(String value) {
            addCriterion("processName >", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameGreaterThanOrEqualTo(String value) {
            addCriterion("processName >=", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLessThan(String value) {
            addCriterion("processName <", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLessThanOrEqualTo(String value) {
            addCriterion("processName <=", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLike(String value) {
            addCriterion("processName like", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotLike(String value) {
            addCriterion("processName not like", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameIn(List<String> values) {
            addCriterion("processName in", values, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotIn(List<String> values) {
            addCriterion("processName not in", values, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameBetween(String value1, String value2) {
            addCriterion("processName between", value1, value2, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotBetween(String value1, String value2) {
            addCriterion("processName not between", value1, value2, "processName");
            return (Criteria) this;
        }

        public Criteria andNoticeStartIsNull() {
            addCriterion("noticeStart is null");
            return (Criteria) this;
        }

        public Criteria andNoticeStartIsNotNull() {
            addCriterion("noticeStart is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeStartEqualTo(Date value) {
            addCriterion("noticeStart =", value, "noticeStart");
            return (Criteria) this;
        }

        public Criteria andNoticeStartNotEqualTo(Date value) {
            addCriterion("noticeStart <>", value, "noticeStart");
            return (Criteria) this;
        }

        public Criteria andNoticeStartGreaterThan(Date value) {
            addCriterion("noticeStart >", value, "noticeStart");
            return (Criteria) this;
        }

        public Criteria andNoticeStartGreaterThanOrEqualTo(Date value) {
            addCriterion("noticeStart >=", value, "noticeStart");
            return (Criteria) this;
        }

        public Criteria andNoticeStartLessThan(Date value) {
            addCriterion("noticeStart <", value, "noticeStart");
            return (Criteria) this;
        }

        public Criteria andNoticeStartLessThanOrEqualTo(Date value) {
            addCriterion("noticeStart <=", value, "noticeStart");
            return (Criteria) this;
        }

        public Criteria andNoticeStartIn(List<Date> values) {
            addCriterion("noticeStart in", values, "noticeStart");
            return (Criteria) this;
        }

        public Criteria andNoticeStartNotIn(List<Date> values) {
            addCriterion("noticeStart not in", values, "noticeStart");
            return (Criteria) this;
        }

        public Criteria andNoticeStartBetween(Date value1, Date value2) {
            addCriterion("noticeStart between", value1, value2, "noticeStart");
            return (Criteria) this;
        }

        public Criteria andNoticeStartNotBetween(Date value1, Date value2) {
            addCriterion("noticeStart not between", value1, value2, "noticeStart");
            return (Criteria) this;
        }

        public Criteria andNoticeEndIsNull() {
            addCriterion("noticeEnd is null");
            return (Criteria) this;
        }

        public Criteria andNoticeEndIsNotNull() {
            addCriterion("noticeEnd is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeEndEqualTo(Date value) {
            addCriterion("noticeEnd =", value, "noticeEnd");
            return (Criteria) this;
        }

        public Criteria andNoticeEndNotEqualTo(Date value) {
            addCriterion("noticeEnd <>", value, "noticeEnd");
            return (Criteria) this;
        }

        public Criteria andNoticeEndGreaterThan(Date value) {
            addCriterion("noticeEnd >", value, "noticeEnd");
            return (Criteria) this;
        }

        public Criteria andNoticeEndGreaterThanOrEqualTo(Date value) {
            addCriterion("noticeEnd >=", value, "noticeEnd");
            return (Criteria) this;
        }

        public Criteria andNoticeEndLessThan(Date value) {
            addCriterion("noticeEnd <", value, "noticeEnd");
            return (Criteria) this;
        }

        public Criteria andNoticeEndLessThanOrEqualTo(Date value) {
            addCriterion("noticeEnd <=", value, "noticeEnd");
            return (Criteria) this;
        }

        public Criteria andNoticeEndIn(List<Date> values) {
            addCriterion("noticeEnd in", values, "noticeEnd");
            return (Criteria) this;
        }

        public Criteria andNoticeEndNotIn(List<Date> values) {
            addCriterion("noticeEnd not in", values, "noticeEnd");
            return (Criteria) this;
        }

        public Criteria andNoticeEndBetween(Date value1, Date value2) {
            addCriterion("noticeEnd between", value1, value2, "noticeEnd");
            return (Criteria) this;
        }

        public Criteria andNoticeEndNotBetween(Date value1, Date value2) {
            addCriterion("noticeEnd not between", value1, value2, "noticeEnd");
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