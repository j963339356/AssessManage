package com.wjc.assess.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssessTargetManageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AssessTargetManageExample() {
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

        public Criteria andAssessIdIsNull() {
            addCriterion("assessId is null");
            return (Criteria) this;
        }

        public Criteria andAssessIdIsNotNull() {
            addCriterion("assessId is not null");
            return (Criteria) this;
        }

        public Criteria andAssessIdEqualTo(String value) {
            addCriterion("assessId =", value, "assessId");
            return (Criteria) this;
        }

        public Criteria andAssessIdNotEqualTo(String value) {
            addCriterion("assessId <>", value, "assessId");
            return (Criteria) this;
        }

        public Criteria andAssessIdGreaterThan(String value) {
            addCriterion("assessId >", value, "assessId");
            return (Criteria) this;
        }

        public Criteria andAssessIdGreaterThanOrEqualTo(String value) {
            addCriterion("assessId >=", value, "assessId");
            return (Criteria) this;
        }

        public Criteria andAssessIdLessThan(String value) {
            addCriterion("assessId <", value, "assessId");
            return (Criteria) this;
        }

        public Criteria andAssessIdLessThanOrEqualTo(String value) {
            addCriterion("assessId <=", value, "assessId");
            return (Criteria) this;
        }

        public Criteria andAssessIdLike(String value) {
            addCriterion("assessId like", value, "assessId");
            return (Criteria) this;
        }

        public Criteria andAssessIdNotLike(String value) {
            addCriterion("assessId not like", value, "assessId");
            return (Criteria) this;
        }

        public Criteria andAssessIdIn(List<String> values) {
            addCriterion("assessId in", values, "assessId");
            return (Criteria) this;
        }

        public Criteria andAssessIdNotIn(List<String> values) {
            addCriterion("assessId not in", values, "assessId");
            return (Criteria) this;
        }

        public Criteria andAssessIdBetween(String value1, String value2) {
            addCriterion("assessId between", value1, value2, "assessId");
            return (Criteria) this;
        }

        public Criteria andAssessIdNotBetween(String value1, String value2) {
            addCriterion("assessId not between", value1, value2, "assessId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andMeansureIsNull() {
            addCriterion("meansure is null");
            return (Criteria) this;
        }

        public Criteria andMeansureIsNotNull() {
            addCriterion("meansure is not null");
            return (Criteria) this;
        }

        public Criteria andMeansureEqualTo(String value) {
            addCriterion("meansure =", value, "meansure");
            return (Criteria) this;
        }

        public Criteria andMeansureNotEqualTo(String value) {
            addCriterion("meansure <>", value, "meansure");
            return (Criteria) this;
        }

        public Criteria andMeansureGreaterThan(String value) {
            addCriterion("meansure >", value, "meansure");
            return (Criteria) this;
        }

        public Criteria andMeansureGreaterThanOrEqualTo(String value) {
            addCriterion("meansure >=", value, "meansure");
            return (Criteria) this;
        }

        public Criteria andMeansureLessThan(String value) {
            addCriterion("meansure <", value, "meansure");
            return (Criteria) this;
        }

        public Criteria andMeansureLessThanOrEqualTo(String value) {
            addCriterion("meansure <=", value, "meansure");
            return (Criteria) this;
        }

        public Criteria andMeansureLike(String value) {
            addCriterion("meansure like", value, "meansure");
            return (Criteria) this;
        }

        public Criteria andMeansureNotLike(String value) {
            addCriterion("meansure not like", value, "meansure");
            return (Criteria) this;
        }

        public Criteria andMeansureIn(List<String> values) {
            addCriterion("meansure in", values, "meansure");
            return (Criteria) this;
        }

        public Criteria andMeansureNotIn(List<String> values) {
            addCriterion("meansure not in", values, "meansure");
            return (Criteria) this;
        }

        public Criteria andMeansureBetween(String value1, String value2) {
            addCriterion("meansure between", value1, value2, "meansure");
            return (Criteria) this;
        }

        public Criteria andMeansureNotBetween(String value1, String value2) {
            addCriterion("meansure not between", value1, value2, "meansure");
            return (Criteria) this;
        }

        public Criteria andPIsNull() {
            addCriterion("p is null");
            return (Criteria) this;
        }

        public Criteria andPIsNotNull() {
            addCriterion("p is not null");
            return (Criteria) this;
        }

        public Criteria andPEqualTo(String value) {
            addCriterion("p =", value, "p");
            return (Criteria) this;
        }

        public Criteria andPNotEqualTo(String value) {
            addCriterion("p <>", value, "p");
            return (Criteria) this;
        }

        public Criteria andPGreaterThan(String value) {
            addCriterion("p >", value, "p");
            return (Criteria) this;
        }

        public Criteria andPGreaterThanOrEqualTo(String value) {
            addCriterion("p >=", value, "p");
            return (Criteria) this;
        }

        public Criteria andPLessThan(String value) {
            addCriterion("p <", value, "p");
            return (Criteria) this;
        }

        public Criteria andPLessThanOrEqualTo(String value) {
            addCriterion("p <=", value, "p");
            return (Criteria) this;
        }

        public Criteria andPLike(String value) {
            addCriterion("p like", value, "p");
            return (Criteria) this;
        }

        public Criteria andPNotLike(String value) {
            addCriterion("p not like", value, "p");
            return (Criteria) this;
        }

        public Criteria andPIn(List<String> values) {
            addCriterion("p in", values, "p");
            return (Criteria) this;
        }

        public Criteria andPNotIn(List<String> values) {
            addCriterion("p not in", values, "p");
            return (Criteria) this;
        }

        public Criteria andPBetween(String value1, String value2) {
            addCriterion("p between", value1, value2, "p");
            return (Criteria) this;
        }

        public Criteria andPNotBetween(String value1, String value2) {
            addCriterion("p not between", value1, value2, "p");
            return (Criteria) this;
        }

        public Criteria andTargetExplainIsNull() {
            addCriterion("targetExplain is null");
            return (Criteria) this;
        }

        public Criteria andTargetExplainIsNotNull() {
            addCriterion("targetExplain is not null");
            return (Criteria) this;
        }

        public Criteria andTargetExplainEqualTo(String value) {
            addCriterion("targetExplain =", value, "targetExplain");
            return (Criteria) this;
        }

        public Criteria andTargetExplainNotEqualTo(String value) {
            addCriterion("targetExplain <>", value, "targetExplain");
            return (Criteria) this;
        }

        public Criteria andTargetExplainGreaterThan(String value) {
            addCriterion("targetExplain >", value, "targetExplain");
            return (Criteria) this;
        }

        public Criteria andTargetExplainGreaterThanOrEqualTo(String value) {
            addCriterion("targetExplain >=", value, "targetExplain");
            return (Criteria) this;
        }

        public Criteria andTargetExplainLessThan(String value) {
            addCriterion("targetExplain <", value, "targetExplain");
            return (Criteria) this;
        }

        public Criteria andTargetExplainLessThanOrEqualTo(String value) {
            addCriterion("targetExplain <=", value, "targetExplain");
            return (Criteria) this;
        }

        public Criteria andTargetExplainLike(String value) {
            addCriterion("targetExplain like", value, "targetExplain");
            return (Criteria) this;
        }

        public Criteria andTargetExplainNotLike(String value) {
            addCriterion("targetExplain not like", value, "targetExplain");
            return (Criteria) this;
        }

        public Criteria andTargetExplainIn(List<String> values) {
            addCriterion("targetExplain in", values, "targetExplain");
            return (Criteria) this;
        }

        public Criteria andTargetExplainNotIn(List<String> values) {
            addCriterion("targetExplain not in", values, "targetExplain");
            return (Criteria) this;
        }

        public Criteria andTargetExplainBetween(String value1, String value2) {
            addCriterion("targetExplain between", value1, value2, "targetExplain");
            return (Criteria) this;
        }

        public Criteria andTargetExplainNotBetween(String value1, String value2) {
            addCriterion("targetExplain not between", value1, value2, "targetExplain");
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

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andValueTypeIsNull() {
            addCriterion("valueType is null");
            return (Criteria) this;
        }

        public Criteria andValueTypeIsNotNull() {
            addCriterion("valueType is not null");
            return (Criteria) this;
        }

        public Criteria andValueTypeEqualTo(String value) {
            addCriterion("valueType =", value, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeNotEqualTo(String value) {
            addCriterion("valueType <>", value, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeGreaterThan(String value) {
            addCriterion("valueType >", value, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeGreaterThanOrEqualTo(String value) {
            addCriterion("valueType >=", value, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeLessThan(String value) {
            addCriterion("valueType <", value, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeLessThanOrEqualTo(String value) {
            addCriterion("valueType <=", value, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeLike(String value) {
            addCriterion("valueType like", value, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeNotLike(String value) {
            addCriterion("valueType not like", value, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeIn(List<String> values) {
            addCriterion("valueType in", values, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeNotIn(List<String> values) {
            addCriterion("valueType not in", values, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeBetween(String value1, String value2) {
            addCriterion("valueType between", value1, value2, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeNotBetween(String value1, String value2) {
            addCriterion("valueType not between", value1, value2, "valueType");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andDimensionIsNull() {
            addCriterion("dimension is null");
            return (Criteria) this;
        }

        public Criteria andDimensionIsNotNull() {
            addCriterion("dimension is not null");
            return (Criteria) this;
        }

        public Criteria andDimensionEqualTo(String value) {
            addCriterion("dimension =", value, "dimension");
            return (Criteria) this;
        }

        public Criteria andDimensionNotEqualTo(String value) {
            addCriterion("dimension <>", value, "dimension");
            return (Criteria) this;
        }

        public Criteria andDimensionGreaterThan(String value) {
            addCriterion("dimension >", value, "dimension");
            return (Criteria) this;
        }

        public Criteria andDimensionGreaterThanOrEqualTo(String value) {
            addCriterion("dimension >=", value, "dimension");
            return (Criteria) this;
        }

        public Criteria andDimensionLessThan(String value) {
            addCriterion("dimension <", value, "dimension");
            return (Criteria) this;
        }

        public Criteria andDimensionLessThanOrEqualTo(String value) {
            addCriterion("dimension <=", value, "dimension");
            return (Criteria) this;
        }

        public Criteria andDimensionLike(String value) {
            addCriterion("dimension like", value, "dimension");
            return (Criteria) this;
        }

        public Criteria andDimensionNotLike(String value) {
            addCriterion("dimension not like", value, "dimension");
            return (Criteria) this;
        }

        public Criteria andDimensionIn(List<String> values) {
            addCriterion("dimension in", values, "dimension");
            return (Criteria) this;
        }

        public Criteria andDimensionNotIn(List<String> values) {
            addCriterion("dimension not in", values, "dimension");
            return (Criteria) this;
        }

        public Criteria andDimensionBetween(String value1, String value2) {
            addCriterion("dimension between", value1, value2, "dimension");
            return (Criteria) this;
        }

        public Criteria andDimensionNotBetween(String value1, String value2) {
            addCriterion("dimension not between", value1, value2, "dimension");
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

        public Criteria andOgrNameIsNull() {
            addCriterion("ogrName is null");
            return (Criteria) this;
        }

        public Criteria andOgrNameIsNotNull() {
            addCriterion("ogrName is not null");
            return (Criteria) this;
        }

        public Criteria andOgrNameEqualTo(String value) {
            addCriterion("ogrName =", value, "ogrName");
            return (Criteria) this;
        }

        public Criteria andOgrNameNotEqualTo(String value) {
            addCriterion("ogrName <>", value, "ogrName");
            return (Criteria) this;
        }

        public Criteria andOgrNameGreaterThan(String value) {
            addCriterion("ogrName >", value, "ogrName");
            return (Criteria) this;
        }

        public Criteria andOgrNameGreaterThanOrEqualTo(String value) {
            addCriterion("ogrName >=", value, "ogrName");
            return (Criteria) this;
        }

        public Criteria andOgrNameLessThan(String value) {
            addCriterion("ogrName <", value, "ogrName");
            return (Criteria) this;
        }

        public Criteria andOgrNameLessThanOrEqualTo(String value) {
            addCriterion("ogrName <=", value, "ogrName");
            return (Criteria) this;
        }

        public Criteria andOgrNameLike(String value) {
            addCriterion("ogrName like", value, "ogrName");
            return (Criteria) this;
        }

        public Criteria andOgrNameNotLike(String value) {
            addCriterion("ogrName not like", value, "ogrName");
            return (Criteria) this;
        }

        public Criteria andOgrNameIn(List<String> values) {
            addCriterion("ogrName in", values, "ogrName");
            return (Criteria) this;
        }

        public Criteria andOgrNameNotIn(List<String> values) {
            addCriterion("ogrName not in", values, "ogrName");
            return (Criteria) this;
        }

        public Criteria andOgrNameBetween(String value1, String value2) {
            addCriterion("ogrName between", value1, value2, "ogrName");
            return (Criteria) this;
        }

        public Criteria andOgrNameNotBetween(String value1, String value2) {
            addCriterion("ogrName not between", value1, value2, "ogrName");
            return (Criteria) this;
        }

        public Criteria andIsStartIsNull() {
            addCriterion("isStart is null");
            return (Criteria) this;
        }

        public Criteria andIsStartIsNotNull() {
            addCriterion("isStart is not null");
            return (Criteria) this;
        }

        public Criteria andIsStartEqualTo(Boolean value) {
            addCriterion("isStart =", value, "isStart");
            return (Criteria) this;
        }

        public Criteria andIsStartNotEqualTo(Boolean value) {
            addCriterion("isStart <>", value, "isStart");
            return (Criteria) this;
        }

        public Criteria andIsStartGreaterThan(Boolean value) {
            addCriterion("isStart >", value, "isStart");
            return (Criteria) this;
        }

        public Criteria andIsStartGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isStart >=", value, "isStart");
            return (Criteria) this;
        }

        public Criteria andIsStartLessThan(Boolean value) {
            addCriterion("isStart <", value, "isStart");
            return (Criteria) this;
        }

        public Criteria andIsStartLessThanOrEqualTo(Boolean value) {
            addCriterion("isStart <=", value, "isStart");
            return (Criteria) this;
        }

        public Criteria andIsStartIn(List<Boolean> values) {
            addCriterion("isStart in", values, "isStart");
            return (Criteria) this;
        }

        public Criteria andIsStartNotIn(List<Boolean> values) {
            addCriterion("isStart not in", values, "isStart");
            return (Criteria) this;
        }

        public Criteria andIsStartBetween(Boolean value1, Boolean value2) {
            addCriterion("isStart between", value1, value2, "isStart");
            return (Criteria) this;
        }

        public Criteria andIsStartNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isStart not between", value1, value2, "isStart");
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