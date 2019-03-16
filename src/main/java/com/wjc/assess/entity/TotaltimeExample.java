package com.wjc.assess.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TotaltimeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TotaltimeExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andMytimeIsNull() {
            addCriterion("mytime is null");
            return (Criteria) this;
        }

        public Criteria andMytimeIsNotNull() {
            addCriterion("mytime is not null");
            return (Criteria) this;
        }

        public Criteria andMytimeEqualTo(Date value) {
            addCriterion("mytime =", value, "mytime");
            return (Criteria) this;
        }

        public Criteria andMytimeNotEqualTo(Date value) {
            addCriterion("mytime <>", value, "mytime");
            return (Criteria) this;
        }

        public Criteria andMytimeGreaterThan(Date value) {
            addCriterion("mytime >", value, "mytime");
            return (Criteria) this;
        }

        public Criteria andMytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("mytime >=", value, "mytime");
            return (Criteria) this;
        }

        public Criteria andMytimeLessThan(Date value) {
            addCriterion("mytime <", value, "mytime");
            return (Criteria) this;
        }

        public Criteria andMytimeLessThanOrEqualTo(Date value) {
            addCriterion("mytime <=", value, "mytime");
            return (Criteria) this;
        }

        public Criteria andMytimeIn(List<Date> values) {
            addCriterion("mytime in", values, "mytime");
            return (Criteria) this;
        }

        public Criteria andMytimeNotIn(List<Date> values) {
            addCriterion("mytime not in", values, "mytime");
            return (Criteria) this;
        }

        public Criteria andMytimeBetween(Date value1, Date value2) {
            addCriterion("mytime between", value1, value2, "mytime");
            return (Criteria) this;
        }

        public Criteria andMytimeNotBetween(Date value1, Date value2) {
            addCriterion("mytime not between", value1, value2, "mytime");
            return (Criteria) this;
        }

        public Criteria andMydateIsNull() {
            addCriterion("mydate is null");
            return (Criteria) this;
        }

        public Criteria andMydateIsNotNull() {
            addCriterion("mydate is not null");
            return (Criteria) this;
        }

        public Criteria andMydateEqualTo(Date value) {
            addCriterionForJDBCDate("mydate =", value, "mydate");
            return (Criteria) this;
        }

        public Criteria andMydateNotEqualTo(Date value) {
            addCriterionForJDBCDate("mydate <>", value, "mydate");
            return (Criteria) this;
        }

        public Criteria andMydateGreaterThan(Date value) {
            addCriterionForJDBCDate("mydate >", value, "mydate");
            return (Criteria) this;
        }

        public Criteria andMydateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("mydate >=", value, "mydate");
            return (Criteria) this;
        }

        public Criteria andMydateLessThan(Date value) {
            addCriterionForJDBCDate("mydate <", value, "mydate");
            return (Criteria) this;
        }

        public Criteria andMydateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("mydate <=", value, "mydate");
            return (Criteria) this;
        }

        public Criteria andMydateIn(List<Date> values) {
            addCriterionForJDBCDate("mydate in", values, "mydate");
            return (Criteria) this;
        }

        public Criteria andMydateNotIn(List<Date> values) {
            addCriterionForJDBCDate("mydate not in", values, "mydate");
            return (Criteria) this;
        }

        public Criteria andMydateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("mydate between", value1, value2, "mydate");
            return (Criteria) this;
        }

        public Criteria andMydateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("mydate not between", value1, value2, "mydate");
            return (Criteria) this;
        }

        public Criteria andMystamtimeIsNull() {
            addCriterion("mystamtime is null");
            return (Criteria) this;
        }

        public Criteria andMystamtimeIsNotNull() {
            addCriterion("mystamtime is not null");
            return (Criteria) this;
        }

        public Criteria andMystamtimeEqualTo(Date value) {
            addCriterion("mystamtime =", value, "mystamtime");
            return (Criteria) this;
        }

        public Criteria andMystamtimeNotEqualTo(Date value) {
            addCriterion("mystamtime <>", value, "mystamtime");
            return (Criteria) this;
        }

        public Criteria andMystamtimeGreaterThan(Date value) {
            addCriterion("mystamtime >", value, "mystamtime");
            return (Criteria) this;
        }

        public Criteria andMystamtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("mystamtime >=", value, "mystamtime");
            return (Criteria) this;
        }

        public Criteria andMystamtimeLessThan(Date value) {
            addCriterion("mystamtime <", value, "mystamtime");
            return (Criteria) this;
        }

        public Criteria andMystamtimeLessThanOrEqualTo(Date value) {
            addCriterion("mystamtime <=", value, "mystamtime");
            return (Criteria) this;
        }

        public Criteria andMystamtimeIn(List<Date> values) {
            addCriterion("mystamtime in", values, "mystamtime");
            return (Criteria) this;
        }

        public Criteria andMystamtimeNotIn(List<Date> values) {
            addCriterion("mystamtime not in", values, "mystamtime");
            return (Criteria) this;
        }

        public Criteria andMystamtimeBetween(Date value1, Date value2) {
            addCriterion("mystamtime between", value1, value2, "mystamtime");
            return (Criteria) this;
        }

        public Criteria andMystamtimeNotBetween(Date value1, Date value2) {
            addCriterion("mystamtime not between", value1, value2, "mystamtime");
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