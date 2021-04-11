package com.lainey.wiki.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
            List<java.sql.Date> dateList = new ArrayList<>();
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

        public Criteria andAlbhIsNull() {
            addCriterion("ALBH is null");
            return (Criteria) this;
        }

        public Criteria andAlbhIsNotNull() {
            addCriterion("ALBH is not null");
            return (Criteria) this;
        }

        public Criteria andAlbhEqualTo(String value) {
            addCriterion("ALBH =", value, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhNotEqualTo(String value) {
            addCriterion("ALBH <>", value, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhGreaterThan(String value) {
            addCriterion("ALBH >", value, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhGreaterThanOrEqualTo(String value) {
            addCriterion("ALBH >=", value, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhLessThan(String value) {
            addCriterion("ALBH <", value, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhLessThanOrEqualTo(String value) {
            addCriterion("ALBH <=", value, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhLike(String value) {
            addCriterion("ALBH like", value, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhNotLike(String value) {
            addCriterion("ALBH not like", value, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhIn(List<String> values) {
            addCriterion("ALBH in", values, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhNotIn(List<String> values) {
            addCriterion("ALBH not in", values, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhBetween(String value1, String value2) {
            addCriterion("ALBH between", value1, value2, "albh");
            return (Criteria) this;
        }

        public Criteria andAlbhNotBetween(String value1, String value2) {
            addCriterion("ALBH not between", value1, value2, "albh");
            return (Criteria) this;
        }

        public Criteria andJhIsNull() {
            addCriterion("JH is null");
            return (Criteria) this;
        }

        public Criteria andJhIsNotNull() {
            addCriterion("JH is not null");
            return (Criteria) this;
        }

        public Criteria andJhEqualTo(String value) {
            addCriterion("JH =", value, "jh");
            return (Criteria) this;
        }

        public Criteria andJhNotEqualTo(String value) {
            addCriterion("JH <>", value, "jh");
            return (Criteria) this;
        }

        public Criteria andJhGreaterThan(String value) {
            addCriterion("JH >", value, "jh");
            return (Criteria) this;
        }

        public Criteria andJhGreaterThanOrEqualTo(String value) {
            addCriterion("JH >=", value, "jh");
            return (Criteria) this;
        }

        public Criteria andJhLessThan(String value) {
            addCriterion("JH <", value, "jh");
            return (Criteria) this;
        }

        public Criteria andJhLessThanOrEqualTo(String value) {
            addCriterion("JH <=", value, "jh");
            return (Criteria) this;
        }

        public Criteria andJhLike(String value) {
            addCriterion("JH like", value, "jh");
            return (Criteria) this;
        }

        public Criteria andJhNotLike(String value) {
            addCriterion("JH not like", value, "jh");
            return (Criteria) this;
        }

        public Criteria andJhIn(List<String> values) {
            addCriterion("JH in", values, "jh");
            return (Criteria) this;
        }

        public Criteria andJhNotIn(List<String> values) {
            addCriterion("JH not in", values, "jh");
            return (Criteria) this;
        }

        public Criteria andJhBetween(String value1, String value2) {
            addCriterion("JH between", value1, value2, "jh");
            return (Criteria) this;
        }

        public Criteria andJhNotBetween(String value1, String value2) {
            addCriterion("JH not between", value1, value2, "jh");
            return (Criteria) this;
        }

        public Criteria andYtmcIsNull() {
            addCriterion("YTMC is null");
            return (Criteria) this;
        }

        public Criteria andYtmcIsNotNull() {
            addCriterion("YTMC is not null");
            return (Criteria) this;
        }

        public Criteria andYtmcEqualTo(String value) {
            addCriterion("YTMC =", value, "ytmc");
            return (Criteria) this;
        }

        public Criteria andYtmcNotEqualTo(String value) {
            addCriterion("YTMC <>", value, "ytmc");
            return (Criteria) this;
        }

        public Criteria andYtmcGreaterThan(String value) {
            addCriterion("YTMC >", value, "ytmc");
            return (Criteria) this;
        }

        public Criteria andYtmcGreaterThanOrEqualTo(String value) {
            addCriterion("YTMC >=", value, "ytmc");
            return (Criteria) this;
        }

        public Criteria andYtmcLessThan(String value) {
            addCriterion("YTMC <", value, "ytmc");
            return (Criteria) this;
        }

        public Criteria andYtmcLessThanOrEqualTo(String value) {
            addCriterion("YTMC <=", value, "ytmc");
            return (Criteria) this;
        }

        public Criteria andYtmcLike(String value) {
            addCriterion("YTMC like", value, "ytmc");
            return (Criteria) this;
        }

        public Criteria andYtmcNotLike(String value) {
            addCriterion("YTMC not like", value, "ytmc");
            return (Criteria) this;
        }

        public Criteria andYtmcIn(List<String> values) {
            addCriterion("YTMC in", values, "ytmc");
            return (Criteria) this;
        }

        public Criteria andYtmcNotIn(List<String> values) {
            addCriterion("YTMC not in", values, "ytmc");
            return (Criteria) this;
        }

        public Criteria andYtmcBetween(String value1, String value2) {
            addCriterion("YTMC between", value1, value2, "ytmc");
            return (Criteria) this;
        }

        public Criteria andYtmcNotBetween(String value1, String value2) {
            addCriterion("YTMC not between", value1, value2, "ytmc");
            return (Criteria) this;
        }

        public Criteria andJxIsNull() {
            addCriterion("JX is null");
            return (Criteria) this;
        }

        public Criteria andJxIsNotNull() {
            addCriterion("JX is not null");
            return (Criteria) this;
        }

        public Criteria andJxEqualTo(String value) {
            addCriterion("JX =", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxNotEqualTo(String value) {
            addCriterion("JX <>", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxGreaterThan(String value) {
            addCriterion("JX >", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxGreaterThanOrEqualTo(String value) {
            addCriterion("JX >=", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxLessThan(String value) {
            addCriterion("JX <", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxLessThanOrEqualTo(String value) {
            addCriterion("JX <=", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxLike(String value) {
            addCriterion("JX like", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxNotLike(String value) {
            addCriterion("JX not like", value, "jx");
            return (Criteria) this;
        }

        public Criteria andJxIn(List<String> values) {
            addCriterion("JX in", values, "jx");
            return (Criteria) this;
        }

        public Criteria andJxNotIn(List<String> values) {
            addCriterion("JX not in", values, "jx");
            return (Criteria) this;
        }

        public Criteria andJxBetween(String value1, String value2) {
            addCriterion("JX between", value1, value2, "jx");
            return (Criteria) this;
        }

        public Criteria andJxNotBetween(String value1, String value2) {
            addCriterion("JX not between", value1, value2, "jx");
            return (Criteria) this;
        }

        public Criteria andJbIsNull() {
            addCriterion("JB is null");
            return (Criteria) this;
        }

        public Criteria andJbIsNotNull() {
            addCriterion("JB is not null");
            return (Criteria) this;
        }

        public Criteria andJbEqualTo(String value) {
            addCriterion("JB =", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbNotEqualTo(String value) {
            addCriterion("JB <>", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbGreaterThan(String value) {
            addCriterion("JB >", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbGreaterThanOrEqualTo(String value) {
            addCriterion("JB >=", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbLessThan(String value) {
            addCriterion("JB <", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbLessThanOrEqualTo(String value) {
            addCriterion("JB <=", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbLike(String value) {
            addCriterion("JB like", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbNotLike(String value) {
            addCriterion("JB not like", value, "jb");
            return (Criteria) this;
        }

        public Criteria andJbIn(List<String> values) {
            addCriterion("JB in", values, "jb");
            return (Criteria) this;
        }

        public Criteria andJbNotIn(List<String> values) {
            addCriterion("JB not in", values, "jb");
            return (Criteria) this;
        }

        public Criteria andJbBetween(String value1, String value2) {
            addCriterion("JB between", value1, value2, "jb");
            return (Criteria) this;
        }

        public Criteria andJbNotBetween(String value1, String value2) {
            addCriterion("JB not between", value1, value2, "jb");
            return (Criteria) this;
        }

        public Criteria andGkIsNull() {
            addCriterion("GK is null");
            return (Criteria) this;
        }

        public Criteria andGkIsNotNull() {
            addCriterion("GK is not null");
            return (Criteria) this;
        }

        public Criteria andGkEqualTo(String value) {
            addCriterion("GK =", value, "gk");
            return (Criteria) this;
        }

        public Criteria andGkNotEqualTo(String value) {
            addCriterion("GK <>", value, "gk");
            return (Criteria) this;
        }

        public Criteria andGkGreaterThan(String value) {
            addCriterion("GK >", value, "gk");
            return (Criteria) this;
        }

        public Criteria andGkGreaterThanOrEqualTo(String value) {
            addCriterion("GK >=", value, "gk");
            return (Criteria) this;
        }

        public Criteria andGkLessThan(String value) {
            addCriterion("GK <", value, "gk");
            return (Criteria) this;
        }

        public Criteria andGkLessThanOrEqualTo(String value) {
            addCriterion("GK <=", value, "gk");
            return (Criteria) this;
        }

        public Criteria andGkLike(String value) {
            addCriterion("GK like", value, "gk");
            return (Criteria) this;
        }

        public Criteria andGkNotLike(String value) {
            addCriterion("GK not like", value, "gk");
            return (Criteria) this;
        }

        public Criteria andGkIn(List<String> values) {
            addCriterion("GK in", values, "gk");
            return (Criteria) this;
        }

        public Criteria andGkNotIn(List<String> values) {
            addCriterion("GK not in", values, "gk");
            return (Criteria) this;
        }

        public Criteria andGkBetween(String value1, String value2) {
            addCriterion("GK between", value1, value2, "gk");
            return (Criteria) this;
        }

        public Criteria andGkNotBetween(String value1, String value2) {
            addCriterion("GK not between", value1, value2, "gk");
            return (Criteria) this;
        }

        public Criteria andZsIsNull() {
            addCriterion("ZS is null");
            return (Criteria) this;
        }

        public Criteria andZsIsNotNull() {
            addCriterion("ZS is not null");
            return (Criteria) this;
        }

        public Criteria andZsEqualTo(Double value) {
            addCriterion("ZS =", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsNotEqualTo(Double value) {
            addCriterion("ZS <>", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsGreaterThan(Double value) {
            addCriterion("ZS >", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsGreaterThanOrEqualTo(Double value) {
            addCriterion("ZS >=", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsLessThan(Double value) {
            addCriterion("ZS <", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsLessThanOrEqualTo(Double value) {
            addCriterion("ZS <=", value, "zs");
            return (Criteria) this;
        }

        public Criteria andZsIn(List<Double> values) {
            addCriterion("ZS in", values, "zs");
            return (Criteria) this;
        }

        public Criteria andZsNotIn(List<Double> values) {
            addCriterion("ZS not in", values, "zs");
            return (Criteria) this;
        }

        public Criteria andZsBetween(Double value1, Double value2) {
            addCriterion("ZS between", value1, value2, "zs");
            return (Criteria) this;
        }

        public Criteria andZsNotBetween(Double value1, Double value2) {
            addCriterion("ZS not between", value1, value2, "zs");
            return (Criteria) this;
        }

        public Criteria andZzjsIsNull() {
            addCriterion("ZZJS is null");
            return (Criteria) this;
        }

        public Criteria andZzjsIsNotNull() {
            addCriterion("ZZJS is not null");
            return (Criteria) this;
        }

        public Criteria andZzjsEqualTo(Double value) {
            addCriterion("ZZJS =", value, "zzjs");
            return (Criteria) this;
        }

        public Criteria andZzjsNotEqualTo(Double value) {
            addCriterion("ZZJS <>", value, "zzjs");
            return (Criteria) this;
        }

        public Criteria andZzjsGreaterThan(Double value) {
            addCriterion("ZZJS >", value, "zzjs");
            return (Criteria) this;
        }

        public Criteria andZzjsGreaterThanOrEqualTo(Double value) {
            addCriterion("ZZJS >=", value, "zzjs");
            return (Criteria) this;
        }

        public Criteria andZzjsLessThan(Double value) {
            addCriterion("ZZJS <", value, "zzjs");
            return (Criteria) this;
        }

        public Criteria andZzjsLessThanOrEqualTo(Double value) {
            addCriterion("ZZJS <=", value, "zzjs");
            return (Criteria) this;
        }

        public Criteria andZzjsIn(List<Double> values) {
            addCriterion("ZZJS in", values, "zzjs");
            return (Criteria) this;
        }

        public Criteria andZzjsNotIn(List<Double> values) {
            addCriterion("ZZJS not in", values, "zzjs");
            return (Criteria) this;
        }

        public Criteria andZzjsBetween(Double value1, Double value2) {
            addCriterion("ZZJS between", value1, value2, "zzjs");
            return (Criteria) this;
        }

        public Criteria andZzjsNotBetween(Double value1, Double value2) {
            addCriterion("ZZJS not between", value1, value2, "zzjs");
            return (Criteria) this;
        }

        public Criteria andZydcIsNull() {
            addCriterion("ZYDC is null");
            return (Criteria) this;
        }

        public Criteria andZydcIsNotNull() {
            addCriterion("ZYDC is not null");
            return (Criteria) this;
        }

        public Criteria andZydcEqualTo(String value) {
            addCriterion("ZYDC =", value, "zydc");
            return (Criteria) this;
        }

        public Criteria andZydcNotEqualTo(String value) {
            addCriterion("ZYDC <>", value, "zydc");
            return (Criteria) this;
        }

        public Criteria andZydcGreaterThan(String value) {
            addCriterion("ZYDC >", value, "zydc");
            return (Criteria) this;
        }

        public Criteria andZydcGreaterThanOrEqualTo(String value) {
            addCriterion("ZYDC >=", value, "zydc");
            return (Criteria) this;
        }

        public Criteria andZydcLessThan(String value) {
            addCriterion("ZYDC <", value, "zydc");
            return (Criteria) this;
        }

        public Criteria andZydcLessThanOrEqualTo(String value) {
            addCriterion("ZYDC <=", value, "zydc");
            return (Criteria) this;
        }

        public Criteria andZydcLike(String value) {
            addCriterion("ZYDC like", value, "zydc");
            return (Criteria) this;
        }

        public Criteria andZydcNotLike(String value) {
            addCriterion("ZYDC not like", value, "zydc");
            return (Criteria) this;
        }

        public Criteria andZydcIn(List<String> values) {
            addCriterion("ZYDC in", values, "zydc");
            return (Criteria) this;
        }

        public Criteria andZydcNotIn(List<String> values) {
            addCriterion("ZYDC not in", values, "zydc");
            return (Criteria) this;
        }

        public Criteria andZydcBetween(String value1, String value2) {
            addCriterion("ZYDC between", value1, value2, "zydc");
            return (Criteria) this;
        }

        public Criteria andZydcNotBetween(String value1, String value2) {
            addCriterion("ZYDC not between", value1, value2, "zydc");
            return (Criteria) this;
        }

        public Criteria andYxIsNull() {
            addCriterion("YX is null");
            return (Criteria) this;
        }

        public Criteria andYxIsNotNull() {
            addCriterion("YX is not null");
            return (Criteria) this;
        }

        public Criteria andYxEqualTo(String value) {
            addCriterion("YX =", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxNotEqualTo(String value) {
            addCriterion("YX <>", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxGreaterThan(String value) {
            addCriterion("YX >", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxGreaterThanOrEqualTo(String value) {
            addCriterion("YX >=", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxLessThan(String value) {
            addCriterion("YX <", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxLessThanOrEqualTo(String value) {
            addCriterion("YX <=", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxLike(String value) {
            addCriterion("YX like", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxNotLike(String value) {
            addCriterion("YX not like", value, "yx");
            return (Criteria) this;
        }

        public Criteria andYxIn(List<String> values) {
            addCriterion("YX in", values, "yx");
            return (Criteria) this;
        }

        public Criteria andYxNotIn(List<String> values) {
            addCriterion("YX not in", values, "yx");
            return (Criteria) this;
        }

        public Criteria andYxBetween(String value1, String value2) {
            addCriterion("YX between", value1, value2, "yx");
            return (Criteria) this;
        }

        public Criteria andYxNotBetween(String value1, String value2) {
            addCriterion("YX not between", value1, value2, "yx");
            return (Criteria) this;
        }

        public Criteria andSllbIsNull() {
            addCriterion("SLLB is null");
            return (Criteria) this;
        }

        public Criteria andSllbIsNotNull() {
            addCriterion("SLLB is not null");
            return (Criteria) this;
        }

        public Criteria andSllbEqualTo(String value) {
            addCriterion("SLLB =", value, "sllb");
            return (Criteria) this;
        }

        public Criteria andSllbNotEqualTo(String value) {
            addCriterion("SLLB <>", value, "sllb");
            return (Criteria) this;
        }

        public Criteria andSllbGreaterThan(String value) {
            addCriterion("SLLB >", value, "sllb");
            return (Criteria) this;
        }

        public Criteria andSllbGreaterThanOrEqualTo(String value) {
            addCriterion("SLLB >=", value, "sllb");
            return (Criteria) this;
        }

        public Criteria andSllbLessThan(String value) {
            addCriterion("SLLB <", value, "sllb");
            return (Criteria) this;
        }

        public Criteria andSllbLessThanOrEqualTo(String value) {
            addCriterion("SLLB <=", value, "sllb");
            return (Criteria) this;
        }

        public Criteria andSllbLike(String value) {
            addCriterion("SLLB like", value, "sllb");
            return (Criteria) this;
        }

        public Criteria andSllbNotLike(String value) {
            addCriterion("SLLB not like", value, "sllb");
            return (Criteria) this;
        }

        public Criteria andSllbIn(List<String> values) {
            addCriterion("SLLB in", values, "sllb");
            return (Criteria) this;
        }

        public Criteria andSllbNotIn(List<String> values) {
            addCriterion("SLLB not in", values, "sllb");
            return (Criteria) this;
        }

        public Criteria andSllbBetween(String value1, String value2) {
            addCriterion("SLLB between", value1, value2, "sllb");
            return (Criteria) this;
        }

        public Criteria andSllbNotBetween(String value1, String value2) {
            addCriterion("SLLB not between", value1, value2, "sllb");
            return (Criteria) this;
        }

        public Criteria andSglxIsNull() {
            addCriterion("SGLX is null");
            return (Criteria) this;
        }

        public Criteria andSglxIsNotNull() {
            addCriterion("SGLX is not null");
            return (Criteria) this;
        }

        public Criteria andSglxEqualTo(String value) {
            addCriterion("SGLX =", value, "sglx");
            return (Criteria) this;
        }

        public Criteria andSglxNotEqualTo(String value) {
            addCriterion("SGLX <>", value, "sglx");
            return (Criteria) this;
        }

        public Criteria andSglxGreaterThan(String value) {
            addCriterion("SGLX >", value, "sglx");
            return (Criteria) this;
        }

        public Criteria andSglxGreaterThanOrEqualTo(String value) {
            addCriterion("SGLX >=", value, "sglx");
            return (Criteria) this;
        }

        public Criteria andSglxLessThan(String value) {
            addCriterion("SGLX <", value, "sglx");
            return (Criteria) this;
        }

        public Criteria andSglxLessThanOrEqualTo(String value) {
            addCriterion("SGLX <=", value, "sglx");
            return (Criteria) this;
        }

        public Criteria andSglxLike(String value) {
            addCriterion("SGLX like", value, "sglx");
            return (Criteria) this;
        }

        public Criteria andSglxNotLike(String value) {
            addCriterion("SGLX not like", value, "sglx");
            return (Criteria) this;
        }

        public Criteria andSglxIn(List<String> values) {
            addCriterion("SGLX in", values, "sglx");
            return (Criteria) this;
        }

        public Criteria andSglxNotIn(List<String> values) {
            addCriterion("SGLX not in", values, "sglx");
            return (Criteria) this;
        }

        public Criteria andSglxBetween(String value1, String value2) {
            addCriterion("SGLX between", value1, value2, "sglx");
            return (Criteria) this;
        }

        public Criteria andSglxNotBetween(String value1, String value2) {
            addCriterion("SGLX not between", value1, value2, "sglx");
            return (Criteria) this;
        }

        public Criteria andSgfssjIsNull() {
            addCriterion("SGFSSJ is null");
            return (Criteria) this;
        }

        public Criteria andSgfssjIsNotNull() {
            addCriterion("SGFSSJ is not null");
            return (Criteria) this;
        }

        public Criteria andSgfssjEqualTo(Date value) {
            addCriterionForJDBCDate("SGFSSJ =", value, "sgfssj");
            return (Criteria) this;
        }

        public Criteria andSgfssjNotEqualTo(Date value) {
            addCriterionForJDBCDate("SGFSSJ <>", value, "sgfssj");
            return (Criteria) this;
        }

        public Criteria andSgfssjGreaterThan(Date value) {
            addCriterionForJDBCDate("SGFSSJ >", value, "sgfssj");
            return (Criteria) this;
        }

        public Criteria andSgfssjGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SGFSSJ >=", value, "sgfssj");
            return (Criteria) this;
        }

        public Criteria andSgfssjLessThan(Date value) {
            addCriterionForJDBCDate("SGFSSJ <", value, "sgfssj");
            return (Criteria) this;
        }

        public Criteria andSgfssjLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("SGFSSJ <=", value, "sgfssj");
            return (Criteria) this;
        }

        public Criteria andSgfssjIn(List<Date> values) {
            addCriterionForJDBCDate("SGFSSJ in", values, "sgfssj");
            return (Criteria) this;
        }

        public Criteria andSgfssjNotIn(List<Date> values) {
            addCriterionForJDBCDate("SGFSSJ not in", values, "sgfssj");
            return (Criteria) this;
        }

        public Criteria andSgfssjBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SGFSSJ between", value1, value2, "sgfssj");
            return (Criteria) this;
        }

        public Criteria andSgfssjNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("SGFSSJ not between", value1, value2, "sgfssj");
            return (Criteria) this;
        }

        public Criteria andSssjIsNull() {
            addCriterion("SSSJ is null");
            return (Criteria) this;
        }

        public Criteria andSssjIsNotNull() {
            addCriterion("SSSJ is not null");
            return (Criteria) this;
        }

        public Criteria andSssjEqualTo(Double value) {
            addCriterion("SSSJ =", value, "sssj");
            return (Criteria) this;
        }

        public Criteria andSssjNotEqualTo(Double value) {
            addCriterion("SSSJ <>", value, "sssj");
            return (Criteria) this;
        }

        public Criteria andSssjGreaterThan(Double value) {
            addCriterion("SSSJ >", value, "sssj");
            return (Criteria) this;
        }

        public Criteria andSssjGreaterThanOrEqualTo(Double value) {
            addCriterion("SSSJ >=", value, "sssj");
            return (Criteria) this;
        }

        public Criteria andSssjLessThan(Double value) {
            addCriterion("SSSJ <", value, "sssj");
            return (Criteria) this;
        }

        public Criteria andSssjLessThanOrEqualTo(Double value) {
            addCriterion("SSSJ <=", value, "sssj");
            return (Criteria) this;
        }

        public Criteria andSssjIn(List<Double> values) {
            addCriterion("SSSJ in", values, "sssj");
            return (Criteria) this;
        }

        public Criteria andSssjNotIn(List<Double> values) {
            addCriterion("SSSJ not in", values, "sssj");
            return (Criteria) this;
        }

        public Criteria andSssjBetween(Double value1, Double value2) {
            addCriterion("SSSJ between", value1, value2, "sssj");
            return (Criteria) this;
        }

        public Criteria andSssjNotBetween(Double value1, Double value2) {
            addCriterion("SSSJ not between", value1, value2, "sssj");
            return (Criteria) this;
        }

        public Criteria andSllyIsNull() {
            addCriterion("SLLY is null");
            return (Criteria) this;
        }

        public Criteria andSllyIsNotNull() {
            addCriterion("SLLY is not null");
            return (Criteria) this;
        }

        public Criteria andSllyEqualTo(String value) {
            addCriterion("SLLY =", value, "slly");
            return (Criteria) this;
        }

        public Criteria andSllyNotEqualTo(String value) {
            addCriterion("SLLY <>", value, "slly");
            return (Criteria) this;
        }

        public Criteria andSllyGreaterThan(String value) {
            addCriterion("SLLY >", value, "slly");
            return (Criteria) this;
        }

        public Criteria andSllyGreaterThanOrEqualTo(String value) {
            addCriterion("SLLY >=", value, "slly");
            return (Criteria) this;
        }

        public Criteria andSllyLessThan(String value) {
            addCriterion("SLLY <", value, "slly");
            return (Criteria) this;
        }

        public Criteria andSllyLessThanOrEqualTo(String value) {
            addCriterion("SLLY <=", value, "slly");
            return (Criteria) this;
        }

        public Criteria andSllyLike(String value) {
            addCriterion("SLLY like", value, "slly");
            return (Criteria) this;
        }

        public Criteria andSllyNotLike(String value) {
            addCriterion("SLLY not like", value, "slly");
            return (Criteria) this;
        }

        public Criteria andSllyIn(List<String> values) {
            addCriterion("SLLY in", values, "slly");
            return (Criteria) this;
        }

        public Criteria andSllyNotIn(List<String> values) {
            addCriterion("SLLY not in", values, "slly");
            return (Criteria) this;
        }

        public Criteria andSllyBetween(String value1, String value2) {
            addCriterion("SLLY between", value1, value2, "slly");
            return (Criteria) this;
        }

        public Criteria andSllyNotBetween(String value1, String value2) {
            addCriterion("SLLY not between", value1, value2, "slly");
            return (Criteria) this;
        }

        public Criteria andBzIsNull() {
            addCriterion("BZ is null");
            return (Criteria) this;
        }

        public Criteria andBzIsNotNull() {
            addCriterion("BZ is not null");
            return (Criteria) this;
        }

        public Criteria andBzEqualTo(String value) {
            addCriterion("BZ =", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotEqualTo(String value) {
            addCriterion("BZ <>", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThan(String value) {
            addCriterion("BZ >", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThanOrEqualTo(String value) {
            addCriterion("BZ >=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThan(String value) {
            addCriterion("BZ <", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThanOrEqualTo(String value) {
            addCriterion("BZ <=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLike(String value) {
            addCriterion("BZ like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotLike(String value) {
            addCriterion("BZ not like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzIn(List<String> values) {
            addCriterion("BZ in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotIn(List<String> values) {
            addCriterion("BZ not in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzBetween(String value1, String value2) {
            addCriterion("BZ between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotBetween(String value1, String value2) {
            addCriterion("BZ not between", value1, value2, "bz");
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