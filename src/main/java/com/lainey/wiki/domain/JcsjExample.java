package com.lainey.wiki.domain;

import java.util.ArrayList;
import java.util.List;

public class JcsjExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JcsjExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andAlbhIsNull() {
            addCriterion("albh is null");
            return (Criteria) this;
        }

        public Criteria andAlbhIsNotNull() {
            addCriterion("albh is not null");
            return (Criteria) this;
        }

        public Criteria andAlbhEqualTo(String value) {
            addCriterion("albh =", value, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhNotEqualTo(String value) {
            addCriterion("albh <>", value, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhGreaterThan(String value) {
            addCriterion("albh >", value, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhGreaterThanOrEqualTo(String value) {
            addCriterion("albh >=", value, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhLessThan(String value) {
            addCriterion("albh <", value, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhLessThanOrEqualTo(String value) {
            addCriterion("albh <=", value, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhLike(String value) {
            addCriterion("albh like", value, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhNotLike(String value) {
            addCriterion("albh not like", value, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhIn(List<String> values) {
            addCriterion("albh in", values, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhNotIn(List<String> values) {
            addCriterion("albh not in", values, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhBetween(String value1, String value2) {
            addCriterion("albh between", value1, value2, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhNotBetween(String value1, String value2) {
            addCriterion("albh not between", value1, value2, "albh");
            return (Criteria) this;
        }

        public Criteria andBzIsNull() {
            addCriterion("bz is null");
            return (Criteria) this;
        }

        public Criteria andBzIsNotNull() {
            addCriterion("bz is not null");
            return (Criteria) this;
        }

        public Criteria andBzEqualTo(String value) {
            addCriterion("bz =", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotEqualTo(String value) {
            addCriterion("bz <>", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThan(String value) {
            addCriterion("bz >", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThanOrEqualTo(String value) {
            addCriterion("bz >=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThan(String value) {
            addCriterion("bz <", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThanOrEqualTo(String value) {
            addCriterion("bz <=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLike(String value) {
            addCriterion("bz like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotLike(String value) {
            addCriterion("bz not like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzIn(List<String> values) {
            addCriterion("bz in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotIn(List<String> values) {
            addCriterion("bz not in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzBetween(String value1, String value2) {
            addCriterion("bz between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotBetween(String value1, String value2) {
            addCriterion("bz not between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andQzIsNull() {
            addCriterion("qz is null");
            return (Criteria) this;
        }

        public Criteria andQzIsNotNull() {
            addCriterion("qz is not null");
            return (Criteria) this;
        }

        public Criteria andQzEqualTo(Double value) {
            addCriterion("qz =", value, "qz");
            return (Criteria) this;
        }

        public Criteria andQzNotEqualTo(Double value) {
            addCriterion("qz <>", value, "qz");
            return (Criteria) this;
        }

        public Criteria andQzGreaterThan(Double value) {
            addCriterion("qz >", value, "qz");
            return (Criteria) this;
        }

        public Criteria andQzGreaterThanOrEqualTo(Double value) {
            addCriterion("qz >=", value, "qz");
            return (Criteria) this;
        }

        public Criteria andQzLessThan(Double value) {
            addCriterion("qz <", value, "qz");
            return (Criteria) this;
        }

        public Criteria andQzLessThanOrEqualTo(Double value) {
            addCriterion("qz <=", value, "qz");
            return (Criteria) this;
        }

        public Criteria andQzIn(List<Double> values) {
            addCriterion("qz in", values, "qz");
            return (Criteria) this;
        }

        public Criteria andQzNotIn(List<Double> values) {
            addCriterion("qz not in", values, "qz");
            return (Criteria) this;
        }

        public Criteria andQzBetween(Double value1, Double value2) {
            addCriterion("qz between", value1, value2, "qz");
            return (Criteria) this;
        }

        public Criteria andQzNotBetween(Double value1, Double value2) {
            addCriterion("qz not between", value1, value2, "qz");
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