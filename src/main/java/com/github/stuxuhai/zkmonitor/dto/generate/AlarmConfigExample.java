package com.github.stuxuhai.zkmonitor.dto.generate;

import java.util.ArrayList;
import java.util.List;

public class AlarmConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AlarmConfigExample() {
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

        public Criteria andAlarmIdIsNull() {
            addCriterion("alarmId is null");
            return (Criteria) this;
        }

        public Criteria andAlarmIdIsNotNull() {
            addCriterion("alarmId is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmIdEqualTo(Integer value) {
            addCriterion("alarmId =", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdNotEqualTo(Integer value) {
            addCriterion("alarmId <>", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdGreaterThan(Integer value) {
            addCriterion("alarmId >", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("alarmId >=", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdLessThan(Integer value) {
            addCriterion("alarmId <", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdLessThanOrEqualTo(Integer value) {
            addCriterion("alarmId <=", value, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdIn(List<Integer> values) {
            addCriterion("alarmId in", values, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdNotIn(List<Integer> values) {
            addCriterion("alarmId not in", values, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdBetween(Integer value1, Integer value2) {
            addCriterion("alarmId between", value1, value2, "alarmId");
            return (Criteria) this;
        }

        public Criteria andAlarmIdNotBetween(Integer value1, Integer value2) {
            addCriterion("alarmId not between", value1, value2, "alarmId");
            return (Criteria) this;
        }

        public Criteria andClusterIdIsNull() {
            addCriterion("clusterId is null");
            return (Criteria) this;
        }

        public Criteria andClusterIdIsNotNull() {
            addCriterion("clusterId is not null");
            return (Criteria) this;
        }

        public Criteria andClusterIdEqualTo(Integer value) {
            addCriterion("clusterId =", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdNotEqualTo(Integer value) {
            addCriterion("clusterId <>", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdGreaterThan(Integer value) {
            addCriterion("clusterId >", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("clusterId >=", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdLessThan(Integer value) {
            addCriterion("clusterId <", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdLessThanOrEqualTo(Integer value) {
            addCriterion("clusterId <=", value, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdIn(List<Integer> values) {
            addCriterion("clusterId in", values, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdNotIn(List<Integer> values) {
            addCriterion("clusterId not in", values, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdBetween(Integer value1, Integer value2) {
            addCriterion("clusterId between", value1, value2, "clusterId");
            return (Criteria) this;
        }

        public Criteria andClusterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("clusterId not between", value1, value2, "clusterId");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeIsNull() {
            addCriterion("alarmType is null");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeIsNotNull() {
            addCriterion("alarmType is not null");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeEqualTo(String value) {
            addCriterion("alarmType =", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeNotEqualTo(String value) {
            addCriterion("alarmType <>", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeGreaterThan(String value) {
            addCriterion("alarmType >", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeGreaterThanOrEqualTo(String value) {
            addCriterion("alarmType >=", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeLessThan(String value) {
            addCriterion("alarmType <", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeLessThanOrEqualTo(String value) {
            addCriterion("alarmType <=", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeLike(String value) {
            addCriterion("alarmType like", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeNotLike(String value) {
            addCriterion("alarmType not like", value, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeIn(List<String> values) {
            addCriterion("alarmType in", values, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeNotIn(List<String> values) {
            addCriterion("alarmType not in", values, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeBetween(String value1, String value2) {
            addCriterion("alarmType between", value1, value2, "alarmType");
            return (Criteria) this;
        }

        public Criteria andAlarmTypeNotBetween(String value1, String value2) {
            addCriterion("alarmType not between", value1, value2, "alarmType");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNull() {
            addCriterion("receiver is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNotNull() {
            addCriterion("receiver is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverEqualTo(String value) {
            addCriterion("receiver =", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotEqualTo(String value) {
            addCriterion("receiver <>", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThan(String value) {
            addCriterion("receiver >", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThanOrEqualTo(String value) {
            addCriterion("receiver >=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThan(String value) {
            addCriterion("receiver <", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThanOrEqualTo(String value) {
            addCriterion("receiver <=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLike(String value) {
            addCriterion("receiver like", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotLike(String value) {
            addCriterion("receiver not like", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverIn(List<String> values) {
            addCriterion("receiver in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotIn(List<String> values) {
            addCriterion("receiver not in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverBetween(String value1, String value2) {
            addCriterion("receiver between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotBetween(String value1, String value2) {
            addCriterion("receiver not between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andEnableIsNull() {
            addCriterion("enable is null");
            return (Criteria) this;
        }

        public Criteria andEnableIsNotNull() {
            addCriterion("enable is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEqualTo(Integer value) {
            addCriterion("enable =", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualTo(Integer value) {
            addCriterion("enable <>", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThan(Integer value) {
            addCriterion("enable >", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualTo(Integer value) {
            addCriterion("enable >=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThan(Integer value) {
            addCriterion("enable <", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualTo(Integer value) {
            addCriterion("enable <=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableIn(List<Integer> values) {
            addCriterion("enable in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotIn(List<Integer> values) {
            addCriterion("enable not in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableBetween(Integer value1, Integer value2) {
            addCriterion("enable between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotBetween(Integer value1, Integer value2) {
            addCriterion("enable not between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andWatchingPathsThresholdIsNull() {
            addCriterion("watchingPathsThreshold is null");
            return (Criteria) this;
        }

        public Criteria andWatchingPathsThresholdIsNotNull() {
            addCriterion("watchingPathsThreshold is not null");
            return (Criteria) this;
        }

        public Criteria andWatchingPathsThresholdEqualTo(Integer value) {
            addCriterion("watchingPathsThreshold =", value, "watchingPathsThreshold");
            return (Criteria) this;
        }

        public Criteria andWatchingPathsThresholdNotEqualTo(Integer value) {
            addCriterion("watchingPathsThreshold <>", value, "watchingPathsThreshold");
            return (Criteria) this;
        }

        public Criteria andWatchingPathsThresholdGreaterThan(Integer value) {
            addCriterion("watchingPathsThreshold >", value, "watchingPathsThreshold");
            return (Criteria) this;
        }

        public Criteria andWatchingPathsThresholdGreaterThanOrEqualTo(Integer value) {
            addCriterion("watchingPathsThreshold >=", value, "watchingPathsThreshold");
            return (Criteria) this;
        }

        public Criteria andWatchingPathsThresholdLessThan(Integer value) {
            addCriterion("watchingPathsThreshold <", value, "watchingPathsThreshold");
            return (Criteria) this;
        }

        public Criteria andWatchingPathsThresholdLessThanOrEqualTo(Integer value) {
            addCriterion("watchingPathsThreshold <=", value, "watchingPathsThreshold");
            return (Criteria) this;
        }

        public Criteria andWatchingPathsThresholdIn(List<Integer> values) {
            addCriterion("watchingPathsThreshold in", values, "watchingPathsThreshold");
            return (Criteria) this;
        }

        public Criteria andWatchingPathsThresholdNotIn(List<Integer> values) {
            addCriterion("watchingPathsThreshold not in", values, "watchingPathsThreshold");
            return (Criteria) this;
        }

        public Criteria andWatchingPathsThresholdBetween(Integer value1, Integer value2) {
            addCriterion("watchingPathsThreshold between", value1, value2, "watchingPathsThreshold");
            return (Criteria) this;
        }

        public Criteria andWatchingPathsThresholdNotBetween(Integer value1, Integer value2) {
            addCriterion("watchingPathsThreshold not between", value1, value2, "watchingPathsThreshold");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyThresholdIsNull() {
            addCriterion("avgLatencyThreshold is null");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyThresholdIsNotNull() {
            addCriterion("avgLatencyThreshold is not null");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyThresholdEqualTo(Integer value) {
            addCriterion("avgLatencyThreshold =", value, "avgLatencyThreshold");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyThresholdNotEqualTo(Integer value) {
            addCriterion("avgLatencyThreshold <>", value, "avgLatencyThreshold");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyThresholdGreaterThan(Integer value) {
            addCriterion("avgLatencyThreshold >", value, "avgLatencyThreshold");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyThresholdGreaterThanOrEqualTo(Integer value) {
            addCriterion("avgLatencyThreshold >=", value, "avgLatencyThreshold");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyThresholdLessThan(Integer value) {
            addCriterion("avgLatencyThreshold <", value, "avgLatencyThreshold");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyThresholdLessThanOrEqualTo(Integer value) {
            addCriterion("avgLatencyThreshold <=", value, "avgLatencyThreshold");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyThresholdIn(List<Integer> values) {
            addCriterion("avgLatencyThreshold in", values, "avgLatencyThreshold");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyThresholdNotIn(List<Integer> values) {
            addCriterion("avgLatencyThreshold not in", values, "avgLatencyThreshold");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyThresholdBetween(Integer value1, Integer value2) {
            addCriterion("avgLatencyThreshold between", value1, value2, "avgLatencyThreshold");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyThresholdNotBetween(Integer value1, Integer value2) {
            addCriterion("avgLatencyThreshold not between", value1, value2, "avgLatencyThreshold");
            return (Criteria) this;
        }

        public Criteria andMaxLatencyThresholdIsNull() {
            addCriterion("maxLatencyThreshold is null");
            return (Criteria) this;
        }

        public Criteria andMaxLatencyThresholdIsNotNull() {
            addCriterion("maxLatencyThreshold is not null");
            return (Criteria) this;
        }

        public Criteria andMaxLatencyThresholdEqualTo(Integer value) {
            addCriterion("maxLatencyThreshold =", value, "maxLatencyThreshold");
            return (Criteria) this;
        }

        public Criteria andMaxLatencyThresholdNotEqualTo(Integer value) {
            addCriterion("maxLatencyThreshold <>", value, "maxLatencyThreshold");
            return (Criteria) this;
        }

        public Criteria andMaxLatencyThresholdGreaterThan(Integer value) {
            addCriterion("maxLatencyThreshold >", value, "maxLatencyThreshold");
            return (Criteria) this;
        }

        public Criteria andMaxLatencyThresholdGreaterThanOrEqualTo(Integer value) {
            addCriterion("maxLatencyThreshold >=", value, "maxLatencyThreshold");
            return (Criteria) this;
        }

        public Criteria andMaxLatencyThresholdLessThan(Integer value) {
            addCriterion("maxLatencyThreshold <", value, "maxLatencyThreshold");
            return (Criteria) this;
        }

        public Criteria andMaxLatencyThresholdLessThanOrEqualTo(Integer value) {
            addCriterion("maxLatencyThreshold <=", value, "maxLatencyThreshold");
            return (Criteria) this;
        }

        public Criteria andMaxLatencyThresholdIn(List<Integer> values) {
            addCriterion("maxLatencyThreshold in", values, "maxLatencyThreshold");
            return (Criteria) this;
        }

        public Criteria andMaxLatencyThresholdNotIn(List<Integer> values) {
            addCriterion("maxLatencyThreshold not in", values, "maxLatencyThreshold");
            return (Criteria) this;
        }

        public Criteria andMaxLatencyThresholdBetween(Integer value1, Integer value2) {
            addCriterion("maxLatencyThreshold between", value1, value2, "maxLatencyThreshold");
            return (Criteria) this;
        }

        public Criteria andMaxLatencyThresholdNotBetween(Integer value1, Integer value2) {
            addCriterion("maxLatencyThreshold not between", value1, value2, "maxLatencyThreshold");
            return (Criteria) this;
        }

        public Criteria andAliveConnectionsThresholdIsNull() {
            addCriterion("aliveConnectionsThreshold is null");
            return (Criteria) this;
        }

        public Criteria andAliveConnectionsThresholdIsNotNull() {
            addCriterion("aliveConnectionsThreshold is not null");
            return (Criteria) this;
        }

        public Criteria andAliveConnectionsThresholdEqualTo(Integer value) {
            addCriterion("aliveConnectionsThreshold =", value, "aliveConnectionsThreshold");
            return (Criteria) this;
        }

        public Criteria andAliveConnectionsThresholdNotEqualTo(Integer value) {
            addCriterion("aliveConnectionsThreshold <>", value, "aliveConnectionsThreshold");
            return (Criteria) this;
        }

        public Criteria andAliveConnectionsThresholdGreaterThan(Integer value) {
            addCriterion("aliveConnectionsThreshold >", value, "aliveConnectionsThreshold");
            return (Criteria) this;
        }

        public Criteria andAliveConnectionsThresholdGreaterThanOrEqualTo(Integer value) {
            addCriterion("aliveConnectionsThreshold >=", value, "aliveConnectionsThreshold");
            return (Criteria) this;
        }

        public Criteria andAliveConnectionsThresholdLessThan(Integer value) {
            addCriterion("aliveConnectionsThreshold <", value, "aliveConnectionsThreshold");
            return (Criteria) this;
        }

        public Criteria andAliveConnectionsThresholdLessThanOrEqualTo(Integer value) {
            addCriterion("aliveConnectionsThreshold <=", value, "aliveConnectionsThreshold");
            return (Criteria) this;
        }

        public Criteria andAliveConnectionsThresholdIn(List<Integer> values) {
            addCriterion("aliveConnectionsThreshold in", values, "aliveConnectionsThreshold");
            return (Criteria) this;
        }

        public Criteria andAliveConnectionsThresholdNotIn(List<Integer> values) {
            addCriterion("aliveConnectionsThreshold not in", values, "aliveConnectionsThreshold");
            return (Criteria) this;
        }

        public Criteria andAliveConnectionsThresholdBetween(Integer value1, Integer value2) {
            addCriterion("aliveConnectionsThreshold between", value1, value2, "aliveConnectionsThreshold");
            return (Criteria) this;
        }

        public Criteria andAliveConnectionsThresholdNotBetween(Integer value1, Integer value2) {
            addCriterion("aliveConnectionsThreshold not between", value1, value2, "aliveConnectionsThreshold");
            return (Criteria) this;
        }

        public Criteria andOutstandingRequestsThresholdIsNull() {
            addCriterion("outstandingRequestsThreshold is null");
            return (Criteria) this;
        }

        public Criteria andOutstandingRequestsThresholdIsNotNull() {
            addCriterion("outstandingRequestsThreshold is not null");
            return (Criteria) this;
        }

        public Criteria andOutstandingRequestsThresholdEqualTo(Integer value) {
            addCriterion("outstandingRequestsThreshold =", value, "outstandingRequestsThreshold");
            return (Criteria) this;
        }

        public Criteria andOutstandingRequestsThresholdNotEqualTo(Integer value) {
            addCriterion("outstandingRequestsThreshold <>", value, "outstandingRequestsThreshold");
            return (Criteria) this;
        }

        public Criteria andOutstandingRequestsThresholdGreaterThan(Integer value) {
            addCriterion("outstandingRequestsThreshold >", value, "outstandingRequestsThreshold");
            return (Criteria) this;
        }

        public Criteria andOutstandingRequestsThresholdGreaterThanOrEqualTo(Integer value) {
            addCriterion("outstandingRequestsThreshold >=", value, "outstandingRequestsThreshold");
            return (Criteria) this;
        }

        public Criteria andOutstandingRequestsThresholdLessThan(Integer value) {
            addCriterion("outstandingRequestsThreshold <", value, "outstandingRequestsThreshold");
            return (Criteria) this;
        }

        public Criteria andOutstandingRequestsThresholdLessThanOrEqualTo(Integer value) {
            addCriterion("outstandingRequestsThreshold <=", value, "outstandingRequestsThreshold");
            return (Criteria) this;
        }

        public Criteria andOutstandingRequestsThresholdIn(List<Integer> values) {
            addCriterion("outstandingRequestsThreshold in", values, "outstandingRequestsThreshold");
            return (Criteria) this;
        }

        public Criteria andOutstandingRequestsThresholdNotIn(List<Integer> values) {
            addCriterion("outstandingRequestsThreshold not in", values, "outstandingRequestsThreshold");
            return (Criteria) this;
        }

        public Criteria andOutstandingRequestsThresholdBetween(Integer value1, Integer value2) {
            addCriterion("outstandingRequestsThreshold between", value1, value2, "outstandingRequestsThreshold");
            return (Criteria) this;
        }

        public Criteria andOutstandingRequestsThresholdNotBetween(Integer value1, Integer value2) {
            addCriterion("outstandingRequestsThreshold not between", value1, value2, "outstandingRequestsThreshold");
            return (Criteria) this;
        }

        public Criteria andZnodeCountThresholdIsNull() {
            addCriterion("znodeCountThreshold is null");
            return (Criteria) this;
        }

        public Criteria andZnodeCountThresholdIsNotNull() {
            addCriterion("znodeCountThreshold is not null");
            return (Criteria) this;
        }

        public Criteria andZnodeCountThresholdEqualTo(Integer value) {
            addCriterion("znodeCountThreshold =", value, "znodeCountThreshold");
            return (Criteria) this;
        }

        public Criteria andZnodeCountThresholdNotEqualTo(Integer value) {
            addCriterion("znodeCountThreshold <>", value, "znodeCountThreshold");
            return (Criteria) this;
        }

        public Criteria andZnodeCountThresholdGreaterThan(Integer value) {
            addCriterion("znodeCountThreshold >", value, "znodeCountThreshold");
            return (Criteria) this;
        }

        public Criteria andZnodeCountThresholdGreaterThanOrEqualTo(Integer value) {
            addCriterion("znodeCountThreshold >=", value, "znodeCountThreshold");
            return (Criteria) this;
        }

        public Criteria andZnodeCountThresholdLessThan(Integer value) {
            addCriterion("znodeCountThreshold <", value, "znodeCountThreshold");
            return (Criteria) this;
        }

        public Criteria andZnodeCountThresholdLessThanOrEqualTo(Integer value) {
            addCriterion("znodeCountThreshold <=", value, "znodeCountThreshold");
            return (Criteria) this;
        }

        public Criteria andZnodeCountThresholdIn(List<Integer> values) {
            addCriterion("znodeCountThreshold in", values, "znodeCountThreshold");
            return (Criteria) this;
        }

        public Criteria andZnodeCountThresholdNotIn(List<Integer> values) {
            addCriterion("znodeCountThreshold not in", values, "znodeCountThreshold");
            return (Criteria) this;
        }

        public Criteria andZnodeCountThresholdBetween(Integer value1, Integer value2) {
            addCriterion("znodeCountThreshold between", value1, value2, "znodeCountThreshold");
            return (Criteria) this;
        }

        public Criteria andZnodeCountThresholdNotBetween(Integer value1, Integer value2) {
            addCriterion("znodeCountThreshold not between", value1, value2, "znodeCountThreshold");
            return (Criteria) this;
        }

        public Criteria andWatchCountThresholdIsNull() {
            addCriterion("watchCountThreshold is null");
            return (Criteria) this;
        }

        public Criteria andWatchCountThresholdIsNotNull() {
            addCriterion("watchCountThreshold is not null");
            return (Criteria) this;
        }

        public Criteria andWatchCountThresholdEqualTo(Integer value) {
            addCriterion("watchCountThreshold =", value, "watchCountThreshold");
            return (Criteria) this;
        }

        public Criteria andWatchCountThresholdNotEqualTo(Integer value) {
            addCriterion("watchCountThreshold <>", value, "watchCountThreshold");
            return (Criteria) this;
        }

        public Criteria andWatchCountThresholdGreaterThan(Integer value) {
            addCriterion("watchCountThreshold >", value, "watchCountThreshold");
            return (Criteria) this;
        }

        public Criteria andWatchCountThresholdGreaterThanOrEqualTo(Integer value) {
            addCriterion("watchCountThreshold >=", value, "watchCountThreshold");
            return (Criteria) this;
        }

        public Criteria andWatchCountThresholdLessThan(Integer value) {
            addCriterion("watchCountThreshold <", value, "watchCountThreshold");
            return (Criteria) this;
        }

        public Criteria andWatchCountThresholdLessThanOrEqualTo(Integer value) {
            addCriterion("watchCountThreshold <=", value, "watchCountThreshold");
            return (Criteria) this;
        }

        public Criteria andWatchCountThresholdIn(List<Integer> values) {
            addCriterion("watchCountThreshold in", values, "watchCountThreshold");
            return (Criteria) this;
        }

        public Criteria andWatchCountThresholdNotIn(List<Integer> values) {
            addCriterion("watchCountThreshold not in", values, "watchCountThreshold");
            return (Criteria) this;
        }

        public Criteria andWatchCountThresholdBetween(Integer value1, Integer value2) {
            addCriterion("watchCountThreshold between", value1, value2, "watchCountThreshold");
            return (Criteria) this;
        }

        public Criteria andWatchCountThresholdNotBetween(Integer value1, Integer value2) {
            addCriterion("watchCountThreshold not between", value1, value2, "watchCountThreshold");
            return (Criteria) this;
        }

        public Criteria andOpenFileDescriptorCountThresholdIsNull() {
            addCriterion("openFileDescriptorCountThreshold is null");
            return (Criteria) this;
        }

        public Criteria andOpenFileDescriptorCountThresholdIsNotNull() {
            addCriterion("openFileDescriptorCountThreshold is not null");
            return (Criteria) this;
        }

        public Criteria andOpenFileDescriptorCountThresholdEqualTo(Integer value) {
            addCriterion("openFileDescriptorCountThreshold =", value, "openFileDescriptorCountThreshold");
            return (Criteria) this;
        }

        public Criteria andOpenFileDescriptorCountThresholdNotEqualTo(Integer value) {
            addCriterion("openFileDescriptorCountThreshold <>", value, "openFileDescriptorCountThreshold");
            return (Criteria) this;
        }

        public Criteria andOpenFileDescriptorCountThresholdGreaterThan(Integer value) {
            addCriterion("openFileDescriptorCountThreshold >", value, "openFileDescriptorCountThreshold");
            return (Criteria) this;
        }

        public Criteria andOpenFileDescriptorCountThresholdGreaterThanOrEqualTo(Integer value) {
            addCriterion("openFileDescriptorCountThreshold >=", value, "openFileDescriptorCountThreshold");
            return (Criteria) this;
        }

        public Criteria andOpenFileDescriptorCountThresholdLessThan(Integer value) {
            addCriterion("openFileDescriptorCountThreshold <", value, "openFileDescriptorCountThreshold");
            return (Criteria) this;
        }

        public Criteria andOpenFileDescriptorCountThresholdLessThanOrEqualTo(Integer value) {
            addCriterion("openFileDescriptorCountThreshold <=", value, "openFileDescriptorCountThreshold");
            return (Criteria) this;
        }

        public Criteria andOpenFileDescriptorCountThresholdIn(List<Integer> values) {
            addCriterion("openFileDescriptorCountThreshold in", values, "openFileDescriptorCountThreshold");
            return (Criteria) this;
        }

        public Criteria andOpenFileDescriptorCountThresholdNotIn(List<Integer> values) {
            addCriterion("openFileDescriptorCountThreshold not in", values, "openFileDescriptorCountThreshold");
            return (Criteria) this;
        }

        public Criteria andOpenFileDescriptorCountThresholdBetween(Integer value1, Integer value2) {
            addCriterion("openFileDescriptorCountThreshold between", value1, value2, "openFileDescriptorCountThreshold");
            return (Criteria) this;
        }

        public Criteria andOpenFileDescriptorCountThresholdNotBetween(Integer value1, Integer value2) {
            addCriterion("openFileDescriptorCountThreshold not between", value1, value2, "openFileDescriptorCountThreshold");
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