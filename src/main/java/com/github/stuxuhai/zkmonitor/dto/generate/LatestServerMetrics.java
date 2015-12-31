package com.github.stuxuhai.zkmonitor.dto.generate;

import java.io.Serializable;

public class LatestServerMetrics implements Serializable {
    private Long metricsId;

    private Integer serverId;

    private Integer clusterId;

    private Long collectTime;

    private Integer serverStatus;

    private String zxid;

    private Integer watchingPaths;

    private Integer avgLatency;

    private Integer maxLatency;

    private Long packetsReceived;

    private Long packetsSent;

    private Integer aliveConnections;

    private Integer outstandingRequests;

    private String serverMode;

    private Integer znodeCount;

    private Integer watchCount;

    private Integer ephemeralsCount;

    private Long approximateDataSize;

    private Integer openFileDescriptorCount;

    private Integer maxFileDescriptorCount;

    private static final long serialVersionUID = 1L;

    public Long getMetricsId() {
        return metricsId;
    }

    public void setMetricsId(Long metricsId) {
        this.metricsId = metricsId;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public Integer getClusterId() {
        return clusterId;
    }

    public void setClusterId(Integer clusterId) {
        this.clusterId = clusterId;
    }

    public Long getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Long collectTime) {
        this.collectTime = collectTime;
    }

    public Integer getServerStatus() {
        return serverStatus;
    }

    public void setServerStatus(Integer serverStatus) {
        this.serverStatus = serverStatus;
    }

    public String getZxid() {
        return zxid;
    }

    public void setZxid(String zxid) {
        this.zxid = zxid;
    }

    public Integer getWatchingPaths() {
        return watchingPaths;
    }

    public void setWatchingPaths(Integer watchingPaths) {
        this.watchingPaths = watchingPaths;
    }

    public Integer getAvgLatency() {
        return avgLatency;
    }

    public void setAvgLatency(Integer avgLatency) {
        this.avgLatency = avgLatency;
    }

    public Integer getMaxLatency() {
        return maxLatency;
    }

    public void setMaxLatency(Integer maxLatency) {
        this.maxLatency = maxLatency;
    }

    public Long getPacketsReceived() {
        return packetsReceived;
    }

    public void setPacketsReceived(Long packetsReceived) {
        this.packetsReceived = packetsReceived;
    }

    public Long getPacketsSent() {
        return packetsSent;
    }

    public void setPacketsSent(Long packetsSent) {
        this.packetsSent = packetsSent;
    }

    public Integer getAliveConnections() {
        return aliveConnections;
    }

    public void setAliveConnections(Integer aliveConnections) {
        this.aliveConnections = aliveConnections;
    }

    public Integer getOutstandingRequests() {
        return outstandingRequests;
    }

    public void setOutstandingRequests(Integer outstandingRequests) {
        this.outstandingRequests = outstandingRequests;
    }

    public String getServerMode() {
        return serverMode;
    }

    public void setServerMode(String serverMode) {
        this.serverMode = serverMode;
    }

    public Integer getZnodeCount() {
        return znodeCount;
    }

    public void setZnodeCount(Integer znodeCount) {
        this.znodeCount = znodeCount;
    }

    public Integer getWatchCount() {
        return watchCount;
    }

    public void setWatchCount(Integer watchCount) {
        this.watchCount = watchCount;
    }

    public Integer getEphemeralsCount() {
        return ephemeralsCount;
    }

    public void setEphemeralsCount(Integer ephemeralsCount) {
        this.ephemeralsCount = ephemeralsCount;
    }

    public Long getApproximateDataSize() {
        return approximateDataSize;
    }

    public void setApproximateDataSize(Long approximateDataSize) {
        this.approximateDataSize = approximateDataSize;
    }

    public Integer getOpenFileDescriptorCount() {
        return openFileDescriptorCount;
    }

    public void setOpenFileDescriptorCount(Integer openFileDescriptorCount) {
        this.openFileDescriptorCount = openFileDescriptorCount;
    }

    public Integer getMaxFileDescriptorCount() {
        return maxFileDescriptorCount;
    }

    public void setMaxFileDescriptorCount(Integer maxFileDescriptorCount) {
        this.maxFileDescriptorCount = maxFileDescriptorCount;
    }
}