package com.github.stuxuhai.zkmonitor.dto.generate;

import java.io.Serializable;

public class AlarmConfig implements Serializable {
    private Integer alarmId;

    private Integer clusterId;

    private String alarmType;

    private String receiver;

    private Integer enable;

    private Integer watchingPathsThreshold;

    private Integer avgLatencyThreshold;

    private Integer maxLatencyThreshold;

    private Integer aliveConnectionsThreshold;

    private Integer outstandingRequestsThreshold;

    private Integer znodeCountThreshold;

    private Integer watchCountThreshold;

    private Integer openFileDescriptorCountThreshold;

    private static final long serialVersionUID = 1L;

    public Integer getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(Integer alarmId) {
        this.alarmId = alarmId;
    }

    public Integer getClusterId() {
        return clusterId;
    }

    public void setClusterId(Integer clusterId) {
        this.clusterId = clusterId;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getWatchingPathsThreshold() {
        return watchingPathsThreshold;
    }

    public void setWatchingPathsThreshold(Integer watchingPathsThreshold) {
        this.watchingPathsThreshold = watchingPathsThreshold;
    }

    public Integer getAvgLatencyThreshold() {
        return avgLatencyThreshold;
    }

    public void setAvgLatencyThreshold(Integer avgLatencyThreshold) {
        this.avgLatencyThreshold = avgLatencyThreshold;
    }

    public Integer getMaxLatencyThreshold() {
        return maxLatencyThreshold;
    }

    public void setMaxLatencyThreshold(Integer maxLatencyThreshold) {
        this.maxLatencyThreshold = maxLatencyThreshold;
    }

    public Integer getAliveConnectionsThreshold() {
        return aliveConnectionsThreshold;
    }

    public void setAliveConnectionsThreshold(Integer aliveConnectionsThreshold) {
        this.aliveConnectionsThreshold = aliveConnectionsThreshold;
    }

    public Integer getOutstandingRequestsThreshold() {
        return outstandingRequestsThreshold;
    }

    public void setOutstandingRequestsThreshold(Integer outstandingRequestsThreshold) {
        this.outstandingRequestsThreshold = outstandingRequestsThreshold;
    }

    public Integer getZnodeCountThreshold() {
        return znodeCountThreshold;
    }

    public void setZnodeCountThreshold(Integer znodeCountThreshold) {
        this.znodeCountThreshold = znodeCountThreshold;
    }

    public Integer getWatchCountThreshold() {
        return watchCountThreshold;
    }

    public void setWatchCountThreshold(Integer watchCountThreshold) {
        this.watchCountThreshold = watchCountThreshold;
    }

    public Integer getOpenFileDescriptorCountThreshold() {
        return openFileDescriptorCountThreshold;
    }

    public void setOpenFileDescriptorCountThreshold(Integer openFileDescriptorCountThreshold) {
        this.openFileDescriptorCountThreshold = openFileDescriptorCountThreshold;
    }
}