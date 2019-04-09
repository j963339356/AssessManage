package com.wjc.assess.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andCountIdIsNull() {
            addCriterion("countId is null");
            return (Criteria) this;
        }

        public Criteria andCountIdIsNotNull() {
            addCriterion("countId is not null");
            return (Criteria) this;
        }

        public Criteria andCountIdEqualTo(String value) {
            addCriterion("countId =", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdNotEqualTo(String value) {
            addCriterion("countId <>", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdGreaterThan(String value) {
            addCriterion("countId >", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdGreaterThanOrEqualTo(String value) {
            addCriterion("countId >=", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdLessThan(String value) {
            addCriterion("countId <", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdLessThanOrEqualTo(String value) {
            addCriterion("countId <=", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdLike(String value) {
            addCriterion("countId like", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdNotLike(String value) {
            addCriterion("countId not like", value, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdIn(List<String> values) {
            addCriterion("countId in", values, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdNotIn(List<String> values) {
            addCriterion("countId not in", values, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdBetween(String value1, String value2) {
            addCriterion("countId between", value1, value2, "countId");
            return (Criteria) this;
        }

        public Criteria andCountIdNotBetween(String value1, String value2) {
            addCriterion("countId not between", value1, value2, "countId");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
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

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
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

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
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

        public Criteria andOrgCodeEqualTo(Integer value) {
            addCriterion("orgCode =", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotEqualTo(Integer value) {
            addCriterion("orgCode <>", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThan(Integer value) {
            addCriterion("orgCode >", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("orgCode >=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThan(Integer value) {
            addCriterion("orgCode <", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThanOrEqualTo(Integer value) {
            addCriterion("orgCode <=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIn(List<Integer> values) {
            addCriterion("orgCode in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotIn(List<Integer> values) {
            addCriterion("orgCode not in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeBetween(Integer value1, Integer value2) {
            addCriterion("orgCode between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotBetween(Integer value1, Integer value2) {
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