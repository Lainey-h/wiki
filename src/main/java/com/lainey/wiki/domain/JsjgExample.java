package com.lainey.wiki.domain;

import java.util.ArrayList;
import java.util.List;

public class JsjgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JsjgExample() {
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

        public Criteria andTgdbsdIsNull() {
            addCriterion("tgdbsd is null");
            return (Criteria) this;
        }

        public Criteria andTgdbsdIsNotNull() {
            addCriterion("tgdbsd is not null");
            return (Criteria) this;
        }

        public Criteria andTgdbsdEqualTo(Double value) {
            addCriterion("tgdbsd =", value, "tgdbsd");
            return (Criteria) this;
        }

        public Criteria andTgdbsdNotEqualTo(Double value) {
            addCriterion("tgdbsd <>", value, "tgdbsd");
            return (Criteria) this;
        }

        public Criteria andTgdbsdGreaterThan(Double value) {
            addCriterion("tgdbsd >", value, "tgdbsd");
            return (Criteria) this;
        }

        public Criteria andTgdbsdGreaterThanOrEqualTo(Double value) {
            addCriterion("tgdbsd >=", value, "tgdbsd");
            return (Criteria) this;
        }

        public Criteria andTgdbsdLessThan(Double value) {
            addCriterion("tgdbsd <", value, "tgdbsd");
            return (Criteria) this;
        }

        public Criteria andTgdbsdLessThanOrEqualTo(Double value) {
            addCriterion("tgdbsd <=", value, "tgdbsd");
            return (Criteria) this;
        }

        public Criteria andTgdbsdIn(List<Double> values) {
            addCriterion("tgdbsd in", values, "tgdbsd");
            return (Criteria) this;
        }

        public Criteria andTgdbsdNotIn(List<Double> values) {
            addCriterion("tgdbsd not in", values, "tgdbsd");
            return (Criteria) this;
        }

        public Criteria andTgdbsdBetween(Double value1, Double value2) {
            addCriterion("tgdbsd between", value1, value2, "tgdbsd");
            return (Criteria) this;
        }

        public Criteria andTgdbsdNotBetween(Double value1, Double value2) {
            addCriterion("tgdbsd not between", value1, value2, "tgdbsd");
            return (Criteria) this;
        }

        public Criteria andTgwjIsNull() {
            addCriterion("tgwj is null");
            return (Criteria) this;
        }

        public Criteria andTgwjIsNotNull() {
            addCriterion("tgwj is not null");
            return (Criteria) this;
        }

        public Criteria andTgwjEqualTo(Double value) {
            addCriterion("tgwj =", value, "tgwj");
            return (Criteria) this;
        }

        public Criteria andTgwjNotEqualTo(Double value) {
            addCriterion("tgwj <>", value, "tgwj");
            return (Criteria) this;
        }

        public Criteria andTgwjGreaterThan(Double value) {
            addCriterion("tgwj >", value, "tgwj");
            return (Criteria) this;
        }

        public Criteria andTgwjGreaterThanOrEqualTo(Double value) {
            addCriterion("tgwj >=", value, "tgwj");
            return (Criteria) this;
        }

        public Criteria andTgwjLessThan(Double value) {
            addCriterion("tgwj <", value, "tgwj");
            return (Criteria) this;
        }

        public Criteria andTgwjLessThanOrEqualTo(Double value) {
            addCriterion("tgwj <=", value, "tgwj");
            return (Criteria) this;
        }

        public Criteria andTgwjIn(List<Double> values) {
            addCriterion("tgwj in", values, "tgwj");
            return (Criteria) this;
        }

        public Criteria andTgwjNotIn(List<Double> values) {
            addCriterion("tgwj not in", values, "tgwj");
            return (Criteria) this;
        }

        public Criteria andTgwjBetween(Double value1, Double value2) {
            addCriterion("tgwj between", value1, value2, "tgwj");
            return (Criteria) this;
        }

        public Criteria andTgwjNotBetween(Double value1, Double value2) {
            addCriterion("tgwj not between", value1, value2, "tgwj");
            return (Criteria) this;
        }

        public Criteria andTgxsdIsNull() {
            addCriterion("tgxsd is null");
            return (Criteria) this;
        }

        public Criteria andTgxsdIsNotNull() {
            addCriterion("tgxsd is not null");
            return (Criteria) this;
        }

        public Criteria andTgxsdEqualTo(Double value) {
            addCriterion("tgxsd =", value, "tgxsd");
            return (Criteria) this;
        }

        public Criteria andTgxsdNotEqualTo(Double value) {
            addCriterion("tgxsd <>", value, "tgxsd");
            return (Criteria) this;
        }

        public Criteria andTgxsdGreaterThan(Double value) {
            addCriterion("tgxsd >", value, "tgxsd");
            return (Criteria) this;
        }

        public Criteria andTgxsdGreaterThanOrEqualTo(Double value) {
            addCriterion("tgxsd >=", value, "tgxsd");
            return (Criteria) this;
        }

        public Criteria andTgxsdLessThan(Double value) {
            addCriterion("tgxsd <", value, "tgxsd");
            return (Criteria) this;
        }

        public Criteria andTgxsdLessThanOrEqualTo(Double value) {
            addCriterion("tgxsd <=", value, "tgxsd");
            return (Criteria) this;
        }

        public Criteria andTgxsdIn(List<Double> values) {
            addCriterion("tgxsd in", values, "tgxsd");
            return (Criteria) this;
        }

        public Criteria andTgxsdNotIn(List<Double> values) {
            addCriterion("tgxsd not in", values, "tgxsd");
            return (Criteria) this;
        }

        public Criteria andTgxsdBetween(Double value1, Double value2) {
            addCriterion("tgxsd between", value1, value2, "tgxsd");
            return (Criteria) this;
        }

        public Criteria andTgxsdNotBetween(Double value1, Double value2) {
            addCriterion("tgxsd not between", value1, value2, "tgxsd");
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