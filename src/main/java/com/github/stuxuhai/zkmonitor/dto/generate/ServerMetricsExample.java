package com.github.stuxuhai.zkmonitor.dto.generate;

import java.util.ArrayList;
import java.util.List;

public class ServerMetricsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServerMetricsExample() {
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

        public Criteria andMetricsIdIsNull() {
            addCriterion("metricsId is null");
            return (Criteria) this;
        }

        public Criteria andMetricsIdIsNotNull() {
            addCriterion("metricsId is not null");
            return (Criteria) this;
        }

        public Criteria andMetricsIdEqualTo(Long value) {
            addCriterion("metricsId =", value, "metricsId");
            return (Criteria) this;
        }

        public Criteria andMetricsIdNotEqualTo(Long value) {
            addCriterion("metricsId <>", value, "metricsId");
            return (Criteria) this;
        }

        public Criteria andMetricsIdGreaterThan(Long value) {
            addCriterion("metricsId >", value, "metricsId");
            return (Criteria) this;
        }

        public Criteria andMetricsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("metricsId >=", value, "metricsId");
            return (Criteria) this;
        }

        public Criteria andMetricsIdLessThan(Long value) {
            addCriterion("metricsId <", value, "metricsId");
            return (Criteria) this;
        }

        public Criteria andMetricsIdLessThanOrEqualTo(Long value) {
            addCriterion("metricsId <=", value, "metricsId");
            return (Criteria) this;
        }

        public Criteria andMetricsIdIn(List<Long> values) {
            addCriterion("metricsId in", values, "metricsId");
            return (Criteria) this;
        }

        public Criteria andMetricsIdNotIn(List<Long> values) {
            addCriterion("metricsId not in", values, "metricsId");
            return (Criteria) this;
        }

        public Criteria andMetricsIdBetween(Long value1, Long value2) {
            addCriterion("metricsId between", value1, value2, "metricsId");
            return (Criteria) this;
        }

        public Criteria andMetricsIdNotBetween(Long value1, Long value2) {
            addCriterion("metricsId not between", value1, value2, "metricsId");
            return (Criteria) this;
        }

        public Criteria andServerIdIsNull() {
            addCriterion("serverId is null");
            return (Criteria) this;
        }

        public Criteria andServerIdIsNotNull() {
            addCriterion("serverId is not null");
            return (Criteria) this;
        }

        public Criteria andServerIdEqualTo(Integer value) {
            addCriterion("serverId =", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotEqualTo(Integer value) {
            addCriterion("serverId <>", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThan(Integer value) {
            addCriterion("serverId >", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("serverId >=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThan(Integer value) {
            addCriterion("serverId <", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdLessThanOrEqualTo(Integer value) {
            addCriterion("serverId <=", value, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdIn(List<Integer> values) {
            addCriterion("serverId in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotIn(List<Integer> values) {
            addCriterion("serverId not in", values, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdBetween(Integer value1, Integer value2) {
            addCriterion("serverId between", value1, value2, "serverId");
            return (Criteria) this;
        }

        public Criteria andServerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("serverId not between", value1, value2, "serverId");
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

        public Criteria andCollectTimeIsNull() {
            addCriterion("collectTime is null");
            return (Criteria) this;
        }

        public Criteria andCollectTimeIsNotNull() {
            addCriterion("collectTime is not null");
            return (Criteria) this;
        }

        public Criteria andCollectTimeEqualTo(Long value) {
            addCriterion("collectTime =", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeNotEqualTo(Long value) {
            addCriterion("collectTime <>", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeGreaterThan(Long value) {
            addCriterion("collectTime >", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("collectTime >=", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeLessThan(Long value) {
            addCriterion("collectTime <", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeLessThanOrEqualTo(Long value) {
            addCriterion("collectTime <=", value, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeIn(List<Long> values) {
            addCriterion("collectTime in", values, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeNotIn(List<Long> values) {
            addCriterion("collectTime not in", values, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeBetween(Long value1, Long value2) {
            addCriterion("collectTime between", value1, value2, "collectTime");
            return (Criteria) this;
        }

        public Criteria andCollectTimeNotBetween(Long value1, Long value2) {
            addCriterion("collectTime not between", value1, value2, "collectTime");
            return (Criteria) this;
        }

        public Criteria andServerStatusIsNull() {
            addCriterion("serverStatus is null");
            return (Criteria) this;
        }

        public Criteria andServerStatusIsNotNull() {
            addCriterion("serverStatus is not null");
            return (Criteria) this;
        }

        public Criteria andServerStatusEqualTo(Integer value) {
            addCriterion("serverStatus =", value, "serverStatus");
            return (Criteria) this;
        }

        public Criteria andServerStatusNotEqualTo(Integer value) {
            addCriterion("serverStatus <>", value, "serverStatus");
            return (Criteria) this;
        }

        public Criteria andServerStatusGreaterThan(Integer value) {
            addCriterion("serverStatus >", value, "serverStatus");
            return (Criteria) this;
        }

        public Criteria andServerStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("serverStatus >=", value, "serverStatus");
            return (Criteria) this;
        }

        public Criteria andServerStatusLessThan(Integer value) {
            addCriterion("serverStatus <", value, "serverStatus");
            return (Criteria) this;
        }

        public Criteria andServerStatusLessThanOrEqualTo(Integer value) {
            addCriterion("serverStatus <=", value, "serverStatus");
            return (Criteria) this;
        }

        public Criteria andServerStatusIn(List<Integer> values) {
            addCriterion("serverStatus in", values, "serverStatus");
            return (Criteria) this;
        }

        public Criteria andServerStatusNotIn(List<Integer> values) {
            addCriterion("serverStatus not in", values, "serverStatus");
            return (Criteria) this;
        }

        public Criteria andServerStatusBetween(Integer value1, Integer value2) {
            addCriterion("serverStatus between", value1, value2, "serverStatus");
            return (Criteria) this;
        }

        public Criteria andServerStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("serverStatus not between", value1, value2, "serverStatus");
            return (Criteria) this;
        }

        public Criteria andZxidIsNull() {
            addCriterion("zxid is null");
            return (Criteria) this;
        }

        public Criteria andZxidIsNotNull() {
            addCriterion("zxid is not null");
            return (Criteria) this;
        }

        public Criteria andZxidEqualTo(String value) {
            addCriterion("zxid =", value, "zxid");
            return (Criteria) this;
        }

        public Criteria andZxidNotEqualTo(String value) {
            addCriterion("zxid <>", value, "zxid");
            return (Criteria) this;
        }

        public Criteria andZxidGreaterThan(String value) {
            addCriterion("zxid >", value, "zxid");
            return (Criteria) this;
        }

        public Criteria andZxidGreaterThanOrEqualTo(String value) {
            addCriterion("zxid >=", value, "zxid");
            return (Criteria) this;
        }

        public Criteria andZxidLessThan(String value) {
            addCriterion("zxid <", value, "zxid");
            return (Criteria) this;
        }

        public Criteria andZxidLessThanOrEqualTo(String value) {
            addCriterion("zxid <=", value, "zxid");
            return (Criteria) this;
        }

        public Criteria andZxidLike(String value) {
            addCriterion("zxid like", value, "zxid");
            return (Criteria) this;
        }

        public Criteria andZxidNotLike(String value) {
            addCriterion("zxid not like", value, "zxid");
            return (Criteria) this;
        }

        public Criteria andZxidIn(List<String> values) {
            addCriterion("zxid in", values, "zxid");
            return (Criteria) this;
        }

        public Criteria andZxidNotIn(List<String> values) {
            addCriterion("zxid not in", values, "zxid");
            return (Criteria) this;
        }

        public Criteria andZxidBetween(String value1, String value2) {
            addCriterion("zxid between", value1, value2, "zxid");
            return (Criteria) this;
        }

        public Criteria andZxidNotBetween(String value1, String value2) {
            addCriterion("zxid not between", value1, value2, "zxid");
            return (Criteria) this;
        }

        public Criteria andWatchingPathsIsNull() {
            addCriterion("watchingPaths is null");
            return (Criteria) this;
        }

        public Criteria andWatchingPathsIsNotNull() {
            addCriterion("watchingPaths is not null");
            return (Criteria) this;
        }

        public Criteria andWatchingPathsEqualTo(Integer value) {
            addCriterion("watchingPaths =", value, "watchingPaths");
            return (Criteria) this;
        }

        public Criteria andWatchingPathsNotEqualTo(Integer value) {
            addCriterion("watchingPaths <>", value, "watchingPaths");
            return (Criteria) this;
        }

        public Criteria andWatchingPathsGreaterThan(Integer value) {
            addCriterion("watchingPaths >", value, "watchingPaths");
            return (Criteria) this;
        }

        public Criteria andWatchingPathsGreaterThanOrEqualTo(Integer value) {
            addCriterion("watchingPaths >=", value, "watchingPaths");
            return (Criteria) this;
        }

        public Criteria andWatchingPathsLessThan(Integer value) {
            addCriterion("watchingPaths <", value, "watchingPaths");
            return (Criteria) this;
        }

        public Criteria andWatchingPathsLessThanOrEqualTo(Integer value) {
            addCriterion("watchingPaths <=", value, "watchingPaths");
            return (Criteria) this;
        }

        public Criteria andWatchingPathsIn(List<Integer> values) {
            addCriterion("watchingPaths in", values, "watchingPaths");
            return (Criteria) this;
        }

        public Criteria andWatchingPathsNotIn(List<Integer> values) {
            addCriterion("watchingPaths not in", values, "watchingPaths");
            return (Criteria) this;
        }

        public Criteria andWatchingPathsBetween(Integer value1, Integer value2) {
            addCriterion("watchingPaths between", value1, value2, "watchingPaths");
            return (Criteria) this;
        }

        public Criteria andWatchingPathsNotBetween(Integer value1, Integer value2) {
            addCriterion("watchingPaths not between", value1, value2, "watchingPaths");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyIsNull() {
            addCriterion("avgLatency is null");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyIsNotNull() {
            addCriterion("avgLatency is not null");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyEqualTo(Integer value) {
            addCriterion("avgLatency =", value, "avgLatency");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyNotEqualTo(Integer value) {
            addCriterion("avgLatency <>", value, "avgLatency");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyGreaterThan(Integer value) {
            addCriterion("avgLatency >", value, "avgLatency");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("avgLatency >=", value, "avgLatency");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyLessThan(Integer value) {
            addCriterion("avgLatency <", value, "avgLatency");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyLessThanOrEqualTo(Integer value) {
            addCriterion("avgLatency <=", value, "avgLatency");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyIn(List<Integer> values) {
            addCriterion("avgLatency in", values, "avgLatency");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyNotIn(List<Integer> values) {
            addCriterion("avgLatency not in", values, "avgLatency");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyBetween(Integer value1, Integer value2) {
            addCriterion("avgLatency between", value1, value2, "avgLatency");
            return (Criteria) this;
        }

        public Criteria andAvgLatencyNotBetween(Integer value1, Integer value2) {
            addCriterion("avgLatency not between", value1, value2, "avgLatency");
            return (Criteria) this;
        }

        public Criteria andMaxLatencyIsNull() {
            addCriterion("maxLatency is null");
            return (Criteria) this;
        }

        public Criteria andMaxLatencyIsNotNull() {
            addCriterion("maxLatency is not null");
            return (Criteria) this;
        }

        public Criteria andMaxLatencyEqualTo(Integer value) {
            addCriterion("maxLatency =", value, "maxLatency");
            return (Criteria) this;
        }

        public Criteria andMaxLatencyNotEqualTo(Integer value) {
            addCriterion("maxLatency <>", value, "maxLatency");
            return (Criteria) this;
        }

        public Criteria andMaxLatencyGreaterThan(Integer value) {
            addCriterion("maxLatency >", value, "maxLatency");
            return (Criteria) this;
        }

        public Criteria andMaxLatencyGreaterThanOrEqualTo(Integer value) {
            addCriterion("maxLatency >=", value, "maxLatency");
            return (Criteria) this;
        }

        public Criteria andMaxLatencyLessThan(Integer value) {
            addCriterion("maxLatency <", value, "maxLatency");
            return (Criteria) this;
        }

        public Criteria andMaxLatencyLessThanOrEqualTo(Integer value) {
            addCriterion("maxLatency <=", value, "maxLatency");
            return (Criteria) this;
        }

        public Criteria andMaxLatencyIn(List<Integer> values) {
            addCriterion("maxLatency in", values, "maxLatency");
            return (Criteria) this;
        }

        public Criteria andMaxLatencyNotIn(List<Integer> values) {
            addCriterion("maxLatency not in", values, "maxLatency");
            return (Criteria) this;
        }

        public Criteria andMaxLatencyBetween(Integer value1, Integer value2) {
            addCriterion("maxLatency between", value1, value2, "maxLatency");
            return (Criteria) this;
        }

        public Criteria andMaxLatencyNotBetween(Integer value1, Integer value2) {
            addCriterion("maxLatency not between", value1, value2, "maxLatency");
            return (Criteria) this;
        }

        public Criteria andPacketsReceivedIsNull() {
            addCriterion("packetsReceived is null");
            return (Criteria) this;
        }

        public Criteria andPacketsReceivedIsNotNull() {
            addCriterion("packetsReceived is not null");
            return (Criteria) this;
        }

        public Criteria andPacketsReceivedEqualTo(Long value) {
            addCriterion("packetsReceived =", value, "packetsReceived");
            return (Criteria) this;
        }

        public Criteria andPacketsReceivedNotEqualTo(Long value) {
            addCriterion("packetsReceived <>", value, "packetsReceived");
            return (Criteria) this;
        }

        public Criteria andPacketsReceivedGreaterThan(Long value) {
            addCriterion("packetsReceived >", value, "packetsReceived");
            return (Criteria) this;
        }

        public Criteria andPacketsReceivedGreaterThanOrEqualTo(Long value) {
            addCriterion("packetsReceived >=", value, "packetsReceived");
            return (Criteria) this;
        }

        public Criteria andPacketsReceivedLessThan(Long value) {
            addCriterion("packetsReceived <", value, "packetsReceived");
            return (Criteria) this;
        }

        public Criteria andPacketsReceivedLessThanOrEqualTo(Long value) {
            addCriterion("packetsReceived <=", value, "packetsReceived");
            return (Criteria) this;
        }

        public Criteria andPacketsReceivedIn(List<Long> values) {
            addCriterion("packetsReceived in", values, "packetsReceived");
            return (Criteria) this;
        }

        public Criteria andPacketsReceivedNotIn(List<Long> values) {
            addCriterion("packetsReceived not in", values, "packetsReceived");
            return (Criteria) this;
        }

        public Criteria andPacketsReceivedBetween(Long value1, Long value2) {
            addCriterion("packetsReceived between", value1, value2, "packetsReceived");
            return (Criteria) this;
        }

        public Criteria andPacketsReceivedNotBetween(Long value1, Long value2) {
            addCriterion("packetsReceived not between", value1, value2, "packetsReceived");
            return (Criteria) this;
        }

        public Criteria andPacketsSentIsNull() {
            addCriterion("packetsSent is null");
            return (Criteria) this;
        }

        public Criteria andPacketsSentIsNotNull() {
            addCriterion("packetsSent is not null");
            return (Criteria) this;
        }

        public Criteria andPacketsSentEqualTo(Long value) {
            addCriterion("packetsSent =", value, "packetsSent");
            return (Criteria) this;
        }

        public Criteria andPacketsSentNotEqualTo(Long value) {
            addCriterion("packetsSent <>", value, "packetsSent");
            return (Criteria) this;
        }

        public Criteria andPacketsSentGreaterThan(Long value) {
            addCriterion("packetsSent >", value, "packetsSent");
            return (Criteria) this;
        }

        public Criteria andPacketsSentGreaterThanOrEqualTo(Long value) {
            addCriterion("packetsSent >=", value, "packetsSent");
            return (Criteria) this;
        }

        public Criteria andPacketsSentLessThan(Long value) {
            addCriterion("packetsSent <", value, "packetsSent");
            return (Criteria) this;
        }

        public Criteria andPacketsSentLessThanOrEqualTo(Long value) {
            addCriterion("packetsSent <=", value, "packetsSent");
            return (Criteria) this;
        }

        public Criteria andPacketsSentIn(List<Long> values) {
            addCriterion("packetsSent in", values, "packetsSent");
            return (Criteria) this;
        }

        public Criteria andPacketsSentNotIn(List<Long> values) {
            addCriterion("packetsSent not in", values, "packetsSent");
            return (Criteria) this;
        }

        public Criteria andPacketsSentBetween(Long value1, Long value2) {
            addCriterion("packetsSent between", value1, value2, "packetsSent");
            return (Criteria) this;
        }

        public Criteria andPacketsSentNotBetween(Long value1, Long value2) {
            addCriterion("packetsSent not between", value1, value2, "packetsSent");
            return (Criteria) this;
        }

        public Criteria andAliveConnectionsIsNull() {
            addCriterion("aliveConnections is null");
            return (Criteria) this;
        }

        public Criteria andAliveConnectionsIsNotNull() {
            addCriterion("aliveConnections is not null");
            return (Criteria) this;
        }

        public Criteria andAliveConnectionsEqualTo(Integer value) {
            addCriterion("aliveConnections =", value, "aliveConnections");
            return (Criteria) this;
        }

        public Criteria andAliveConnectionsNotEqualTo(Integer value) {
            addCriterion("aliveConnections <>", value, "aliveConnections");
            return (Criteria) this;
        }

        public Criteria andAliveConnectionsGreaterThan(Integer value) {
            addCriterion("aliveConnections >", value, "aliveConnections");
            return (Criteria) this;
        }

        public Criteria andAliveConnectionsGreaterThanOrEqualTo(Integer value) {
            addCriterion("aliveConnections >=", value, "aliveConnections");
            return (Criteria) this;
        }

        public Criteria andAliveConnectionsLessThan(Integer value) {
            addCriterion("aliveConnections <", value, "aliveConnections");
            return (Criteria) this;
        }

        public Criteria andAliveConnectionsLessThanOrEqualTo(Integer value) {
            addCriterion("aliveConnections <=", value, "aliveConnections");
            return (Criteria) this;
        }

        public Criteria andAliveConnectionsIn(List<Integer> values) {
            addCriterion("aliveConnections in", values, "aliveConnections");
            return (Criteria) this;
        }

        public Criteria andAliveConnectionsNotIn(List<Integer> values) {
            addCriterion("aliveConnections not in", values, "aliveConnections");
            return (Criteria) this;
        }

        public Criteria andAliveConnectionsBetween(Integer value1, Integer value2) {
            addCriterion("aliveConnections between", value1, value2, "aliveConnections");
            return (Criteria) this;
        }

        public Criteria andAliveConnectionsNotBetween(Integer value1, Integer value2) {
            addCriterion("aliveConnections not between", value1, value2, "aliveConnections");
            return (Criteria) this;
        }

        public Criteria andOutstandingRequestsIsNull() {
            addCriterion("outstandingRequests is null");
            return (Criteria) this;
        }

        public Criteria andOutstandingRequestsIsNotNull() {
            addCriterion("outstandingRequests is not null");
            return (Criteria) this;
        }

        public Criteria andOutstandingRequestsEqualTo(Integer value) {
            addCriterion("outstandingRequests =", value, "outstandingRequests");
            return (Criteria) this;
        }

        public Criteria andOutstandingRequestsNotEqualTo(Integer value) {
            addCriterion("outstandingRequests <>", value, "outstandingRequests");
            return (Criteria) this;
        }

        public Criteria andOutstandingRequestsGreaterThan(Integer value) {
            addCriterion("outstandingRequests >", value, "outstandingRequests");
            return (Criteria) this;
        }

        public Criteria andOutstandingRequestsGreaterThanOrEqualTo(Integer value) {
            addCriterion("outstandingRequests >=", value, "outstandingRequests");
            return (Criteria) this;
        }

        public Criteria andOutstandingRequestsLessThan(Integer value) {
            addCriterion("outstandingRequests <", value, "outstandingRequests");
            return (Criteria) this;
        }

        public Criteria andOutstandingRequestsLessThanOrEqualTo(Integer value) {
            addCriterion("outstandingRequests <=", value, "outstandingRequests");
            return (Criteria) this;
        }

        public Criteria andOutstandingRequestsIn(List<Integer> values) {
            addCriterion("outstandingRequests in", values, "outstandingRequests");
            return (Criteria) this;
        }

        public Criteria andOutstandingRequestsNotIn(List<Integer> values) {
            addCriterion("outstandingRequests not in", values, "outstandingRequests");
            return (Criteria) this;
        }

        public Criteria andOutstandingRequestsBetween(Integer value1, Integer value2) {
            addCriterion("outstandingRequests between", value1, value2, "outstandingRequests");
            return (Criteria) this;
        }

        public Criteria andOutstandingRequestsNotBetween(Integer value1, Integer value2) {
            addCriterion("outstandingRequests not between", value1, value2, "outstandingRequests");
            return (Criteria) this;
        }

        public Criteria andServerModeIsNull() {
            addCriterion("serverMode is null");
            return (Criteria) this;
        }

        public Criteria andServerModeIsNotNull() {
            addCriterion("serverMode is not null");
            return (Criteria) this;
        }

        public Criteria andServerModeEqualTo(String value) {
            addCriterion("serverMode =", value, "serverMode");
            return (Criteria) this;
        }

        public Criteria andServerModeNotEqualTo(String value) {
            addCriterion("serverMode <>", value, "serverMode");
            return (Criteria) this;
        }

        public Criteria andServerModeGreaterThan(String value) {
            addCriterion("serverMode >", value, "serverMode");
            return (Criteria) this;
        }

        public Criteria andServerModeGreaterThanOrEqualTo(String value) {
            addCriterion("serverMode >=", value, "serverMode");
            return (Criteria) this;
        }

        public Criteria andServerModeLessThan(String value) {
            addCriterion("serverMode <", value, "serverMode");
            return (Criteria) this;
        }

        public Criteria andServerModeLessThanOrEqualTo(String value) {
            addCriterion("serverMode <=", value, "serverMode");
            return (Criteria) this;
        }

        public Criteria andServerModeLike(String value) {
            addCriterion("serverMode like", value, "serverMode");
            return (Criteria) this;
        }

        public Criteria andServerModeNotLike(String value) {
            addCriterion("serverMode not like", value, "serverMode");
            return (Criteria) this;
        }

        public Criteria andServerModeIn(List<String> values) {
            addCriterion("serverMode in", values, "serverMode");
            return (Criteria) this;
        }

        public Criteria andServerModeNotIn(List<String> values) {
            addCriterion("serverMode not in", values, "serverMode");
            return (Criteria) this;
        }

        public Criteria andServerModeBetween(String value1, String value2) {
            addCriterion("serverMode between", value1, value2, "serverMode");
            return (Criteria) this;
        }

        public Criteria andServerModeNotBetween(String value1, String value2) {
            addCriterion("serverMode not between", value1, value2, "serverMode");
            return (Criteria) this;
        }

        public Criteria andZnodeCountIsNull() {
            addCriterion("znodeCount is null");
            return (Criteria) this;
        }

        public Criteria andZnodeCountIsNotNull() {
            addCriterion("znodeCount is not null");
            return (Criteria) this;
        }

        public Criteria andZnodeCountEqualTo(Integer value) {
            addCriterion("znodeCount =", value, "znodeCount");
            return (Criteria) this;
        }

        public Criteria andZnodeCountNotEqualTo(Integer value) {
            addCriterion("znodeCount <>", value, "znodeCount");
            return (Criteria) this;
        }

        public Criteria andZnodeCountGreaterThan(Integer value) {
            addCriterion("znodeCount >", value, "znodeCount");
            return (Criteria) this;
        }

        public Criteria andZnodeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("znodeCount >=", value, "znodeCount");
            return (Criteria) this;
        }

        public Criteria andZnodeCountLessThan(Integer value) {
            addCriterion("znodeCount <", value, "znodeCount");
            return (Criteria) this;
        }

        public Criteria andZnodeCountLessThanOrEqualTo(Integer value) {
            addCriterion("znodeCount <=", value, "znodeCount");
            return (Criteria) this;
        }

        public Criteria andZnodeCountIn(List<Integer> values) {
            addCriterion("znodeCount in", values, "znodeCount");
            return (Criteria) this;
        }

        public Criteria andZnodeCountNotIn(List<Integer> values) {
            addCriterion("znodeCount not in", values, "znodeCount");
            return (Criteria) this;
        }

        public Criteria andZnodeCountBetween(Integer value1, Integer value2) {
            addCriterion("znodeCount between", value1, value2, "znodeCount");
            return (Criteria) this;
        }

        public Criteria andZnodeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("znodeCount not between", value1, value2, "znodeCount");
            return (Criteria) this;
        }

        public Criteria andWatchCountIsNull() {
            addCriterion("watchCount is null");
            return (Criteria) this;
        }

        public Criteria andWatchCountIsNotNull() {
            addCriterion("watchCount is not null");
            return (Criteria) this;
        }

        public Criteria andWatchCountEqualTo(Integer value) {
            addCriterion("watchCount =", value, "watchCount");
            return (Criteria) this;
        }

        public Criteria andWatchCountNotEqualTo(Integer value) {
            addCriterion("watchCount <>", value, "watchCount");
            return (Criteria) this;
        }

        public Criteria andWatchCountGreaterThan(Integer value) {
            addCriterion("watchCount >", value, "watchCount");
            return (Criteria) this;
        }

        public Criteria andWatchCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("watchCount >=", value, "watchCount");
            return (Criteria) this;
        }

        public Criteria andWatchCountLessThan(Integer value) {
            addCriterion("watchCount <", value, "watchCount");
            return (Criteria) this;
        }

        public Criteria andWatchCountLessThanOrEqualTo(Integer value) {
            addCriterion("watchCount <=", value, "watchCount");
            return (Criteria) this;
        }

        public Criteria andWatchCountIn(List<Integer> values) {
            addCriterion("watchCount in", values, "watchCount");
            return (Criteria) this;
        }

        public Criteria andWatchCountNotIn(List<Integer> values) {
            addCriterion("watchCount not in", values, "watchCount");
            return (Criteria) this;
        }

        public Criteria andWatchCountBetween(Integer value1, Integer value2) {
            addCriterion("watchCount between", value1, value2, "watchCount");
            return (Criteria) this;
        }

        public Criteria andWatchCountNotBetween(Integer value1, Integer value2) {
            addCriterion("watchCount not between", value1, value2, "watchCount");
            return (Criteria) this;
        }

        public Criteria andEphemeralsCountIsNull() {
            addCriterion("ephemeralsCount is null");
            return (Criteria) this;
        }

        public Criteria andEphemeralsCountIsNotNull() {
            addCriterion("ephemeralsCount is not null");
            return (Criteria) this;
        }

        public Criteria andEphemeralsCountEqualTo(Integer value) {
            addCriterion("ephemeralsCount =", value, "ephemeralsCount");
            return (Criteria) this;
        }

        public Criteria andEphemeralsCountNotEqualTo(Integer value) {
            addCriterion("ephemeralsCount <>", value, "ephemeralsCount");
            return (Criteria) this;
        }

        public Criteria andEphemeralsCountGreaterThan(Integer value) {
            addCriterion("ephemeralsCount >", value, "ephemeralsCount");
            return (Criteria) this;
        }

        public Criteria andEphemeralsCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("ephemeralsCount >=", value, "ephemeralsCount");
            return (Criteria) this;
        }

        public Criteria andEphemeralsCountLessThan(Integer value) {
            addCriterion("ephemeralsCount <", value, "ephemeralsCount");
            return (Criteria) this;
        }

        public Criteria andEphemeralsCountLessThanOrEqualTo(Integer value) {
            addCriterion("ephemeralsCount <=", value, "ephemeralsCount");
            return (Criteria) this;
        }

        public Criteria andEphemeralsCountIn(List<Integer> values) {
            addCriterion("ephemeralsCount in", values, "ephemeralsCount");
            return (Criteria) this;
        }

        public Criteria andEphemeralsCountNotIn(List<Integer> values) {
            addCriterion("ephemeralsCount not in", values, "ephemeralsCount");
            return (Criteria) this;
        }

        public Criteria andEphemeralsCountBetween(Integer value1, Integer value2) {
            addCriterion("ephemeralsCount between", value1, value2, "ephemeralsCount");
            return (Criteria) this;
        }

        public Criteria andEphemeralsCountNotBetween(Integer value1, Integer value2) {
            addCriterion("ephemeralsCount not between", value1, value2, "ephemeralsCount");
            return (Criteria) this;
        }

        public Criteria andApproximateDataSizeIsNull() {
            addCriterion("approximateDataSize is null");
            return (Criteria) this;
        }

        public Criteria andApproximateDataSizeIsNotNull() {
            addCriterion("approximateDataSize is not null");
            return (Criteria) this;
        }

        public Criteria andApproximateDataSizeEqualTo(Long value) {
            addCriterion("approximateDataSize =", value, "approximateDataSize");
            return (Criteria) this;
        }

        public Criteria andApproximateDataSizeNotEqualTo(Long value) {
            addCriterion("approximateDataSize <>", value, "approximateDataSize");
            return (Criteria) this;
        }

        public Criteria andApproximateDataSizeGreaterThan(Long value) {
            addCriterion("approximateDataSize >", value, "approximateDataSize");
            return (Criteria) this;
        }

        public Criteria andApproximateDataSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("approximateDataSize >=", value, "approximateDataSize");
            return (Criteria) this;
        }

        public Criteria andApproximateDataSizeLessThan(Long value) {
            addCriterion("approximateDataSize <", value, "approximateDataSize");
            return (Criteria) this;
        }

        public Criteria andApproximateDataSizeLessThanOrEqualTo(Long value) {
            addCriterion("approximateDataSize <=", value, "approximateDataSize");
            return (Criteria) this;
        }

        public Criteria andApproximateDataSizeIn(List<Long> values) {
            addCriterion("approximateDataSize in", values, "approximateDataSize");
            return (Criteria) this;
        }

        public Criteria andApproximateDataSizeNotIn(List<Long> values) {
            addCriterion("approximateDataSize not in", values, "approximateDataSize");
            return (Criteria) this;
        }

        public Criteria andApproximateDataSizeBetween(Long value1, Long value2) {
            addCriterion("approximateDataSize between", value1, value2, "approximateDataSize");
            return (Criteria) this;
        }

        public Criteria andApproximateDataSizeNotBetween(Long value1, Long value2) {
            addCriterion("approximateDataSize not between", value1, value2, "approximateDataSize");
            return (Criteria) this;
        }

        public Criteria andOpenFileDescriptorCountIsNull() {
            addCriterion("openFileDescriptorCount is null");
            return (Criteria) this;
        }

        public Criteria andOpenFileDescriptorCountIsNotNull() {
            addCriterion("openFileDescriptorCount is not null");
            return (Criteria) this;
        }

        public Criteria andOpenFileDescriptorCountEqualTo(Integer value) {
            addCriterion("openFileDescriptorCount =", value, "openFileDescriptorCount");
            return (Criteria) this;
        }

        public Criteria andOpenFileDescriptorCountNotEqualTo(Integer value) {
            addCriterion("openFileDescriptorCount <>", value, "openFileDescriptorCount");
            return (Criteria) this;
        }

        public Criteria andOpenFileDescriptorCountGreaterThan(Integer value) {
            addCriterion("openFileDescriptorCount >", value, "openFileDescriptorCount");
            return (Criteria) this;
        }

        public Criteria andOpenFileDescriptorCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("openFileDescriptorCount >=", value, "openFileDescriptorCount");
            return (Criteria) this;
        }

        public Criteria andOpenFileDescriptorCountLessThan(Integer value) {
            addCriterion("openFileDescriptorCount <", value, "openFileDescriptorCount");
            return (Criteria) this;
        }

        public Criteria andOpenFileDescriptorCountLessThanOrEqualTo(Integer value) {
            addCriterion("openFileDescriptorCount <=", value, "openFileDescriptorCount");
            return (Criteria) this;
        }

        public Criteria andOpenFileDescriptorCountIn(List<Integer> values) {
            addCriterion("openFileDescriptorCount in", values, "openFileDescriptorCount");
            return (Criteria) this;
        }

        public Criteria andOpenFileDescriptorCountNotIn(List<Integer> values) {
            addCriterion("openFileDescriptorCount not in", values, "openFileDescriptorCount");
            return (Criteria) this;
        }

        public Criteria andOpenFileDescriptorCountBetween(Integer value1, Integer value2) {
            addCriterion("openFileDescriptorCount between", value1, value2, "openFileDescriptorCount");
            return (Criteria) this;
        }

        public Criteria andOpenFileDescriptorCountNotBetween(Integer value1, Integer value2) {
            addCriterion("openFileDescriptorCount not between", value1, value2, "openFileDescriptorCount");
            return (Criteria) this;
        }

        public Criteria andMaxFileDescriptorCountIsNull() {
            addCriterion("maxFileDescriptorCount is null");
            return (Criteria) this;
        }

        public Criteria andMaxFileDescriptorCountIsNotNull() {
            addCriterion("maxFileDescriptorCount is not null");
            return (Criteria) this;
        }

        public Criteria andMaxFileDescriptorCountEqualTo(Integer value) {
            addCriterion("maxFileDescriptorCount =", value, "maxFileDescriptorCount");
            return (Criteria) this;
        }

        public Criteria andMaxFileDescriptorCountNotEqualTo(Integer value) {
            addCriterion("maxFileDescriptorCount <>", value, "maxFileDescriptorCount");
            return (Criteria) this;
        }

        public Criteria andMaxFileDescriptorCountGreaterThan(Integer value) {
            addCriterion("maxFileDescriptorCount >", value, "maxFileDescriptorCount");
            return (Criteria) this;
        }

        public Criteria andMaxFileDescriptorCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("maxFileDescriptorCount >=", value, "maxFileDescriptorCount");
            return (Criteria) this;
        }

        public Criteria andMaxFileDescriptorCountLessThan(Integer value) {
            addCriterion("maxFileDescriptorCount <", value, "maxFileDescriptorCount");
            return (Criteria) this;
        }

        public Criteria andMaxFileDescriptorCountLessThanOrEqualTo(Integer value) {
            addCriterion("maxFileDescriptorCount <=", value, "maxFileDescriptorCount");
            return (Criteria) this;
        }

        public Criteria andMaxFileDescriptorCountIn(List<Integer> values) {
            addCriterion("maxFileDescriptorCount in", values, "maxFileDescriptorCount");
            return (Criteria) this;
        }

        public Criteria andMaxFileDescriptorCountNotIn(List<Integer> values) {
            addCriterion("maxFileDescriptorCount not in", values, "maxFileDescriptorCount");
            return (Criteria) this;
        }

        public Criteria andMaxFileDescriptorCountBetween(Integer value1, Integer value2) {
            addCriterion("maxFileDescriptorCount between", value1, value2, "maxFileDescriptorCount");
            return (Criteria) this;
        }

        public Criteria andMaxFileDescriptorCountNotBetween(Integer value1, Integer value2) {
            addCriterion("maxFileDescriptorCount not between", value1, value2, "maxFileDescriptorCount");
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