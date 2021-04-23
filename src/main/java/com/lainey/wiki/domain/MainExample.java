package com.lainey.wiki.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MainExample() {
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

        public Criteria andAlbhEqualTo(Long value) {
            addCriterion("albh =", value, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhNotEqualTo(Long value) {
            addCriterion("albh <>", value, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhGreaterThan(Long value) {
            addCriterion("albh >", value, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhGreaterThanOrEqualTo(Long value) {
            addCriterion("albh >=", value, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhLessThan(Long value) {
            addCriterion("albh <", value, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhLessThanOrEqualTo(Long value) {
            addCriterion("albh <=", value, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhIn(List<Long> values) {
            addCriterion("albh in", values, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhNotIn(List<Long> values) {
            addCriterion("albh not in", values, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhBetween(Long value1, Long value2) {
            addCriterion("albh between", value1, value2, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhNotBetween(Long value1, Long value2) {
            addCriterion("albh not between", value1, value2, "albh");
            return (Criteria) this;
        }

        public Criteria andJhIsNull() {
            addCriterion("jh is null");
            return (Criteria) this;
        }

        public Criteria andJhIsNotNull() {
            addCriterion("jh is not null");
            return (Criteria) this;
        }

        public Criteria andJhEqualTo(String value) {
            addCriterion("jh =", value, "jh");
            return (Criteria) this;
        }

        public Criteria andJhNotEqualTo(String value) {
            addCriterion("jh <>", value, "jh");
            return (Criteria) this;
        }

        public Criteria andJhGreaterThan(String value) {
            addCriterion("jh >", value, "jh");
            return (Criteria) this;
        }

        public Criteria andJhGreaterThanOrEqualTo(String value) {
            addCriterion("jh >=", value, "jh");
            return (Criteria) this;
        }

        public Criteria andJhLessThan(String value) {
            addCriterion("jh <", value, "jh");
            return (Criteria) this;
        }

        public Criteria andJhLessThanOrEqualTo(String value) {
            addCriterion("jh <=", value, "jh");
            return (Criteria) this;
        }

        public Criteria andJhLike(String value) {
            addCriterion("jh like", value, "jh");
            return (Criteria) this;
        }

        public Criteria andJhNotLike(String value) {
            addCriterion("jh not like", value, "jh");
            return (Criteria) this;
        }

        public Criteria andJhIn(List<String> values) {
            addCriterion("jh in", values, "jh");
            return (Criteria) this;
        }

        public Criteria andJhNotIn(List<String> values) {
            addCriterion("jh not in", values, "jh");
            return (Criteria) this;
        }

        public Criteria andJhBetween(String value1, String value2) {
            addCriterion("jh between", value1, value2, "jh");
            return (Criteria) this;
        }

        public Criteria andJhNotBetween(String value1, String value2) {
            addCriterion("jh not between", value1, value2, "jh");
            return (Criteria) this;
        }

        public Criteria andYtmcIsNull() {
            addCriterion("ytmc is null");
            return (Criteria) this;
        }

        public Criteria andYtmcIsNotNull() {
            addCriterion("ytmc is not null");
            return (Criteria) this;
        }

        public Criteria andYtmcEqualTo(String value) {
            addCriterion("ytmc =", value, "ytmc");
            return (Criteria) this;
        }

        public Criteria andYtmcNotEqualTo(String value) {
            addCriterion("ytmc <>", value, "ytmc");
            return (Criteria) this;
        }

        public Criteria andYtmcGreaterThan(String value) {
            addCriterion("ytmc >", value, "ytmc");
            return (Criteria) this;
        }

        public Criteria andYtmcGreaterThanOrEqualTo(String value) {
            addCriterion("ytmc >=", value, "ytmc");
            return (Criteria) this;
        }

        public Criteria andYtmcLessThan(String value) {
            addCriterion("ytmc <", value, "ytmc");
            return (Criteria) this;
        }

        public Criteria andYtmcLessThanOrEqualTo(String value) {
            addCriterion("ytmc <=", value, "ytmc");
            return (Criteria) this;
        }

        public Criteria andYtmcLike(String value) {
            addCriterion("ytmc like", value, "ytmc");
            return (Criteria) this;
        }

        public Criteria andYtmcNotLike(String value) {
            addCriterion("ytmc not like", value, "ytmc");
            return (Criteria) this;
        }

        public Criteria andYtmcIn(List<String> values) {
            addCriterion("ytmc in", values, "ytmc");
            return (Criteria) this;
        }

        public Criteria andYtmcNotIn(List<String> values) {
            addCriterion("ytmc not in", values, "ytmc");
            return (Criteria) this;
        }

        public Criteria andYtmcBetween(String value1, String value2) {
            addCriterion("ytmc between", value1, value2, "ytmc");
            return (Criteria) this;
        }

        public Criteria andYtmcNotBetween(String value1, String value2) {
            addCriterion("ytmc not between", value1, value2, "ytmc");
            return (Criteria) this;
        }

        public Criteria andJxIsNull() {
            addCriterion("jx is null");
            return (Criteria) this;
        }

        public Criteria andJxIsNotNull() {
            addCriterion("jx is not null");
            return (Criteria) this;
        }

        public Criteria andJxEqualTo(String value) {
            addCriterion("jx =", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxNotEqualTo(String value) {
            addCriterion("jx <>", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxGreaterThan(String value) {
            addCriterion("jx >", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxGreaterThanOrEqualTo(String value) {
            addCriterion("jx >=", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxLessThan(String value) {
            addCriterion("jx <", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxLessThanOrEqualTo(String value) {
            addCriterion("jx <=", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxLike(String value) {
            addCriterion("jx like", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxNotLike(String value) {
            addCriterion("jx not like", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxIn(List<String> values) {
            addCriterion("jx in", values, "jx");
            return (Criteria) this;
        }

        public Criteria andJxNotIn(List<String> values) {
            addCriterion("jx not in", values, "jx");
            return (Criteria) this;
        }

        public Criteria andJxBetween(String value1, String value2) {
            addCriterion("jx between", value1, value2, "jx");
            return (Criteria) this;
        }

        public Criteria andJxNotBetween(String value1, String value2) {
            addCriterion("jx not between", value1, value2, "jx");
            return (Criteria) this;
        }

        public Criteria andJbIsNull() {
            addCriterion("jb is null");
            return (Criteria) this;
        }

        public Criteria andJbIsNotNull() {
            addCriterion("jb is not null");
            return (Criteria) this;
        }

        public Criteria andJbEqualTo(String value) {
            addCriterion("jb =", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbNotEqualTo(String value) {
            addCriterion("jb <>", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbGreaterThan(String value) {
            addCriterion("jb >", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbGreaterThanOrEqualTo(String value) {
            addCriterion("jb >=", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbLessThan(String value) {
            addCriterion("jb <", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbLessThanOrEqualTo(String value) {
            addCriterion("jb <=", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbLike(String value) {
            addCriterion("jb like", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbNotLike(String value) {
            addCriterion("jb not like", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbIn(List<String> values) {
            addCriterion("jb in", values, "jb");
            return (Criteria) this;
        }

        public Criteria andJbNotIn(List<String> values) {
            addCriterion("jb not in", values, "jb");
            return (Criteria) this;
        }

        public Criteria andJbBetween(String value1, String value2) {
            addCriterion("jb between", value1, value2, "jb");
            return (Criteria) this;
        }

        public Criteria andJbNotBetween(String value1, String value2) {
            addCriterion("jb not between", value1, value2, "jb");
            return (Criteria) this;
        }

        public Criteria andGkIsNull() {
            addCriterion("gk is null");
            return (Criteria) this;
        }

        public Criteria andGkIsNotNull() {
            addCriterion("gk is not null");
            return (Criteria) this;
        }

        public Criteria andGkEqualTo(String value) {
            addCriterion("gk =", value, "gk");
            return (Criteria) this;
        }

        public Criteria andGkNotEqualTo(String value) {
            addCriterion("gk <>", value, "gk");
            return (Criteria) this;
        }

        public Criteria andGkGreaterThan(String value) {
            addCriterion("gk >", value, "gk");
            return (Criteria) this;
        }

        public Criteria andGkGreaterThanOrEqualTo(String value) {
            addCriterion("gk >=", value, "gk");
            return (Criteria) this;
        }

        public Criteria andGkLessThan(String value) {
            addCriterion("gk <", value, "gk");
            return (Criteria) this;
        }

        public Criteria andGkLessThanOrEqualTo(String value) {
            addCriterion("gk <=", value, "gk");
            return (Criteria) this;
        }

        public Criteria andGkLike(String value) {
            addCriterion("gk like", value, "gk");
            return (Criteria) this;
        }

        public Criteria andGkNotLike(String value) {
            addCriterion("gk not like", value, "gk");
            return (Criteria) this;
        }

        public Criteria andGkIn(List<String> values) {
            addCriterion("gk in", values, "gk");
            return (Criteria) this;
        }

        public Criteria andGkNotIn(List<String> values) {
            addCriterion("gk not in", values, "gk");
            return (Criteria) this;
        }

        public Criteria andGkBetween(String value1, String value2) {
            addCriterion("gk between", value1, value2, "gk");
            return (Criteria) this;
        }

        public Criteria andGkNotBetween(String value1, String value2) {
            addCriterion("gk not between", value1, value2, "gk");
            return (Criteria) this;
        }

        public Criteria andZsIsNull() {
            addCriterion("zs is null");
            return (Criteria) this;
        }

        public Criteria andZsIsNotNull() {
            addCriterion("zs is not null");
            return (Criteria) this;
        }

        public Criteria andZsEqualTo(Double value) {
            addCriterion("zs =", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsNotEqualTo(Double value) {
            addCriterion("zs <>", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsGreaterThan(Double value) {
            addCriterion("zs >", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsGreaterThanOrEqualTo(Double value) {
            addCriterion("zs >=", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsLessThan(Double value) {
            addCriterion("zs <", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsLessThanOrEqualTo(Double value) {
            addCriterion("zs <=", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsIn(List<Double> values) {
            addCriterion("zs in", values, "zs");
            return (Criteria) this;
        }

        public Criteria andZsNotIn(List<Double> values) {
            addCriterion("zs not in", values, "zs");
            return (Criteria) this;
        }

        public Criteria andZsBetween(Double value1, Double value2) {
            addCriterion("zs between", value1, value2, "zs");
            return (Criteria) this;
        }

        public Criteria andZsNotBetween(Double value1, Double value2) {
            addCriterion("zs not between", value1, value2, "zs");
            return (Criteria) this;
        }

        public Criteria andZzjsIsNull() {
            addCriterion("zzjs is null");
            return (Criteria) this;
        }

        public Criteria andZzjsIsNotNull() {
            addCriterion("zzjs is not null");
            return (Criteria) this;
        }

        public Criteria andZzjsEqualTo(Double value) {
            addCriterion("zzjs =", value, "zzjs");
            return (Criteria) this;
        }

        public Criteria andZzjsNotEqualTo(Double value) {
            addCriterion("zzjs <>", value, "zzjs");
            return (Criteria) this;
        }

        public Criteria andZzjsGreaterThan(Double value) {
            addCriterion("zzjs >", value, "zzjs");
            return (Criteria) this;
        }

        public Criteria andZzjsGreaterThanOrEqualTo(Double value) {
            addCriterion("zzjs >=", value, "zzjs");
            return (Criteria) this;
        }

        public Criteria andZzjsLessThan(Double value) {
            addCriterion("zzjs <", value, "zzjs");
            return (Criteria) this;
        }

        public Criteria andZzjsLessThanOrEqualTo(Double value) {
            addCriterion("zzjs <=", value, "zzjs");
            return (Criteria) this;
        }

        public Criteria andZzjsIn(List<Double> values) {
            addCriterion("zzjs in", values, "zzjs");
            return (Criteria) this;
        }

        public Criteria andZzjsNotIn(List<Double> values) {
            addCriterion("zzjs not in", values, "zzjs");
            return (Criteria) this;
        }

        public Criteria andZzjsBetween(Double value1, Double value2) {
            addCriterion("zzjs between", value1, value2, "zzjs");
            return (Criteria) this;
        }

        public Criteria andZzjsNotBetween(Double value1, Double value2) {
            addCriterion("zzjs not between", value1, value2, "zzjs");
            return (Criteria) this;
        }

        public Criteria andZydcIsNull() {
            addCriterion("zydc is null");
            return (Criteria) this;
        }

        public Criteria andZydcIsNotNull() {
            addCriterion("zydc is not null");
            return (Criteria) this;
        }

        public Criteria andZydcEqualTo(String value) {
            addCriterion("zydc =", value, "zydc");
            return (Criteria) this;
        }

        public Criteria andZydcNotEqualTo(String value) {
            addCriterion("zydc <>", value, "zydc");
            return (Criteria) this;
        }

        public Criteria andZydcGreaterThan(String value) {
            addCriterion("zydc >", value, "zydc");
            return (Criteria) this;
        }

        public Criteria andZydcGreaterThanOrEqualTo(String value) {
            addCriterion("zydc >=", value, "zydc");
            return (Criteria) this;
        }

        public Criteria andZydcLessThan(String value) {
            addCriterion("zydc <", value, "zydc");
            return (Criteria) this;
        }

        public Criteria andZydcLessThanOrEqualTo(String value) {
            addCriterion("zydc <=", value, "zydc");
            return (Criteria) this;
        }

        public Criteria andZydcLike(String value) {
            addCriterion("zydc like", value, "zydc");
            return (Criteria) this;
        }

        public Criteria andZydcNotLike(String value) {
            addCriterion("zydc not like", value, "zydc");
            return (Criteria) this;
        }

        public Criteria andZydcIn(List<String> values) {
            addCriterion("zydc in", values, "zydc");
            return (Criteria) this;
        }

        public Criteria andZydcNotIn(List<String> values) {
            addCriterion("zydc not in", values, "zydc");
            return (Criteria) this;
        }

        public Criteria andZydcBetween(String value1, String value2) {
            addCriterion("zydc between", value1, value2, "zydc");
            return (Criteria) this;
        }

        public Criteria andZydcNotBetween(String value1, String value2) {
            addCriterion("zydc not between", value1, value2, "zydc");
            return (Criteria) this;
        }

        public Criteria andYxIsNull() {
            addCriterion("yx is null");
            return (Criteria) this;
        }

        public Criteria andYxIsNotNull() {
            addCriterion("yx is not null");
            return (Criteria) this;
        }

        public Criteria andYxEqualTo(String value) {
            addCriterion("yx =", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxNotEqualTo(String value) {
            addCriterion("yx <>", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxGreaterThan(String value) {
            addCriterion("yx >", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxGreaterThanOrEqualTo(String value) {
            addCriterion("yx >=", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxLessThan(String value) {
            addCriterion("yx <", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxLessThanOrEqualTo(String value) {
            addCriterion("yx <=", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxLike(String value) {
            addCriterion("yx like", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxNotLike(String value) {
            addCriterion("yx not like", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxIn(List<String> values) {
            addCriterion("yx in", values, "yx");
            return (Criteria) this;
        }

        public Criteria andYxNotIn(List<String> values) {
            addCriterion("yx not in", values, "yx");
            return (Criteria) this;
        }

        public Criteria andYxBetween(String value1, String value2) {
            addCriterion("yx between", value1, value2, "yx");
            return (Criteria) this;
        }

        public Criteria andYxNotBetween(String value1, String value2) {
            addCriterion("yx not between", value1, value2, "yx");
            return (Criteria) this;
        }

        public Criteria andSllbIsNull() {
            addCriterion("sllb is null");
            return (Criteria) this;
        }

        public Criteria andSllbIsNotNull() {
            addCriterion("sllb is not null");
            return (Criteria) this;
        }

        public Criteria andSllbEqualTo(String value) {
            addCriterion("sllb =", value, "sllb");
            return (Criteria) this;
        }

        public Criteria andSllbNotEqualTo(String value) {
            addCriterion("sllb <>", value, "sllb");
            return (Criteria) this;
        }

        public Criteria andSllbGreaterThan(String value) {
            addCriterion("sllb >", value, "sllb");
            return (Criteria) this;
        }

        public Criteria andSllbGreaterThanOrEqualTo(String value) {
            addCriterion("sllb >=", value, "sllb");
            return (Criteria) this;
        }

        public Criteria andSllbLessThan(String value) {
            addCriterion("sllb <", value, "sllb");
            return (Criteria) this;
        }

        public Criteria andSllbLessThanOrEqualTo(String value) {
            addCriterion("sllb <=", value, "sllb");
            return (Criteria) this;
        }

        public Criteria andSllbLike(String value) {
            addCriterion("sllb like", value, "sllb");
            return (Criteria) this;
        }

        public Criteria andSllbNotLike(String value) {
            addCriterion("sllb not like", value, "sllb");
            return (Criteria) this;
        }

        public Criteria andSllbIn(List<String> values) {
            addCriterion("sllb in", values, "sllb");
            return (Criteria) this;
        }

        public Criteria andSllbNotIn(List<String> values) {
            addCriterion("sllb not in", values, "sllb");
            return (Criteria) this;
        }

        public Criteria andSllbBetween(String value1, String value2) {
            addCriterion("sllb between", value1, value2, "sllb");
            return (Criteria) this;
        }

        public Criteria andSllbNotBetween(String value1, String value2) {
            addCriterion("sllb not between", value1, value2, "sllb");
            return (Criteria) this;
        }

        public Criteria andSglxIsNull() {
            addCriterion("sglx is null");
            return (Criteria) this;
        }

        public Criteria andSglxIsNotNull() {
            addCriterion("sglx is not null");
            return (Criteria) this;
        }

        public Criteria andSglxEqualTo(String value) {
            addCriterion("sglx =", value, "sglx");
            return (Criteria) this;
        }

        public Criteria andSglxNotEqualTo(String value) {
            addCriterion("sglx <>", value, "sglx");
            return (Criteria) this;
        }

        public Criteria andSglxGreaterThan(String value) {
            addCriterion("sglx >", value, "sglx");
            return (Criteria) this;
        }

        public Criteria andSglxGreaterThanOrEqualTo(String value) {
            addCriterion("sglx >=", value, "sglx");
            return (Criteria) this;
        }

        public Criteria andSglxLessThan(String value) {
            addCriterion("sglx <", value, "sglx");
            return (Criteria) this;
        }

        public Criteria andSglxLessThanOrEqualTo(String value) {
            addCriterion("sglx <=", value, "sglx");
            return (Criteria) this;
        }

        public Criteria andSglxLike(String value) {
            addCriterion("sglx like", value, "sglx");
            return (Criteria) this;
        }

        public Criteria andSglxNotLike(String value) {
            addCriterion("sglx not like", value, "sglx");
            return (Criteria) this;
        }

        public Criteria andSglxIn(List<String> values) {
            addCriterion("sglx in", values, "sglx");
            return (Criteria) this;
        }

        public Criteria andSglxNotIn(List<String> values) {
            addCriterion("sglx not in", values, "sglx");
            return (Criteria) this;
        }

        public Criteria andSglxBetween(String value1, String value2) {
            addCriterion("sglx between", value1, value2, "sglx");
            return (Criteria) this;
        }

        public Criteria andSglxNotBetween(String value1, String value2) {
            addCriterion("sglx not between", value1, value2, "sglx");
            return (Criteria) this;
        }

        public Criteria andSgfssjIsNull() {
            addCriterion("sgfssj is null");
            return (Criteria) this;
        }

        public Criteria andSgfssjIsNotNull() {
            addCriterion("sgfssj is not null");
            return (Criteria) this;
        }

        public Criteria andSgfssjEqualTo(Date value) {
            addCriterion("sgfssj =", value, "sgfssj");
            return (Criteria) this;
        }

        public Criteria andSgfssjNotEqualTo(Date value) {
            addCriterion("sgfssj <>", value, "sgfssj");
            return (Criteria) this;
        }

        public Criteria andSgfssjGreaterThan(Date value) {
            addCriterion("sgfssj >", value, "sgfssj");
            return (Criteria) this;
        }

        public Criteria andSgfssjGreaterThanOrEqualTo(Date value) {
            addCriterion("sgfssj >=", value, "sgfssj");
            return (Criteria) this;
        }

        public Criteria andSgfssjLessThan(Date value) {
            addCriterion("sgfssj <", value, "sgfssj");
            return (Criteria) this;
        }

        public Criteria andSgfssjLessThanOrEqualTo(Date value) {
            addCriterion("sgfssj <=", value, "sgfssj");
            return (Criteria) this;
        }

        public Criteria andSgfssjIn(List<Date> values) {
            addCriterion("sgfssj in", values, "sgfssj");
            return (Criteria) this;
        }

        public Criteria andSgfssjNotIn(List<Date> values) {
            addCriterion("sgfssj not in", values, "sgfssj");
            return (Criteria) this;
        }

        public Criteria andSgfssjBetween(Date value1, Date value2) {
            addCriterion("sgfssj between", value1, value2, "sgfssj");
            return (Criteria) this;
        }

        public Criteria andSgfssjNotBetween(Date value1, Date value2) {
            addCriterion("sgfssj not between", value1, value2, "sgfssj");
            return (Criteria) this;
        }

        public Criteria andSssjIsNull() {
            addCriterion("sssj is null");
            return (Criteria) this;
        }

        public Criteria andSssjIsNotNull() {
            addCriterion("sssj is not null");
            return (Criteria) this;
        }

        public Criteria andSssjEqualTo(Double value) {
            addCriterion("sssj =", value, "sssj");
            return (Criteria) this;
        }

        public Criteria andSssjNotEqualTo(Double value) {
            addCriterion("sssj <>", value, "sssj");
            return (Criteria) this;
        }

        public Criteria andSssjGreaterThan(Double value) {
            addCriterion("sssj >", value, "sssj");
            return (Criteria) this;
        }

        public Criteria andSssjGreaterThanOrEqualTo(Double value) {
            addCriterion("sssj >=", value, "sssj");
            return (Criteria) this;
        }

        public Criteria andSssjLessThan(Double value) {
            addCriterion("sssj <", value, "sssj");
            return (Criteria) this;
        }

        public Criteria andSssjLessThanOrEqualTo(Double value) {
            addCriterion("sssj <=", value, "sssj");
            return (Criteria) this;
        }

        public Criteria andSssjIn(List<Double> values) {
            addCriterion("sssj in", values, "sssj");
            return (Criteria) this;
        }

        public Criteria andSssjNotIn(List<Double> values) {
            addCriterion("sssj not in", values, "sssj");
            return (Criteria) this;
        }

        public Criteria andSssjBetween(Double value1, Double value2) {
            addCriterion("sssj between", value1, value2, "sssj");
            return (Criteria) this;
        }

        public Criteria andSssjNotBetween(Double value1, Double value2) {
            addCriterion("sssj not between", value1, value2, "sssj");
            return (Criteria) this;
        }

        public Criteria andSllyIsNull() {
            addCriterion("slly is null");
            return (Criteria) this;
        }

        public Criteria andSllyIsNotNull() {
            addCriterion("slly is not null");
            return (Criteria) this;
        }

        public Criteria andSllyEqualTo(String value) {
            addCriterion("slly =", value, "slly");
            return (Criteria) this;
        }

        public Criteria andSllyNotEqualTo(String value) {
            addCriterion("slly <>", value, "slly");
            return (Criteria) this;
        }

        public Criteria andSllyGreaterThan(String value) {
            addCriterion("slly >", value, "slly");
            return (Criteria) this;
        }

        public Criteria andSllyGreaterThanOrEqualTo(String value) {
            addCriterion("slly >=", value, "slly");
            return (Criteria) this;
        }

        public Criteria andSllyLessThan(String value) {
            addCriterion("slly <", value, "slly");
            return (Criteria) this;
        }

        public Criteria andSllyLessThanOrEqualTo(String value) {
            addCriterion("slly <=", value, "slly");
            return (Criteria) this;
        }

        public Criteria andSllyLike(String value) {
            addCriterion("slly like", value, "slly");
            return (Criteria) this;
        }

        public Criteria andSllyNotLike(String value) {
            addCriterion("slly not like", value, "slly");
            return (Criteria) this;
        }

        public Criteria andSllyIn(List<String> values) {
            addCriterion("slly in", values, "slly");
            return (Criteria) this;
        }

        public Criteria andSllyNotIn(List<String> values) {
            addCriterion("slly not in", values, "slly");
            return (Criteria) this;
        }

        public Criteria andSllyBetween(String value1, String value2) {
            addCriterion("slly between", value1, value2, "slly");
            return (Criteria) this;
        }

        public Criteria andSllyNotBetween(String value1, String value2) {
            addCriterion("slly not between", value1, value2, "slly");
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