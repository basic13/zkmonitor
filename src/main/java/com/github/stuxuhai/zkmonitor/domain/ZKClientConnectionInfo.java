/*
 * Author: wuya
 * Create Date: 2015年11月26日 下午3:55:02
 */

package com.github.stuxuhai.zkmonitor.domain;

public class ZKClientConnectionInfo {

    private String ip;
    private int port;
    private int interestOps;
    private int outstandingRequests;
    private long packetsReceived;
    private long packetsSent;
    private String sessionId;
    private String lastOperation;
    private long establishTime;
    private int sessionTimeout;
    private String lastCxid;
    private String lastZxid;
    private long lastResponseTime;
    private int lastLatency;
    private int lastMinLatency;
    private int lastAvgLatency;
    private int lastMaxLatency;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getInterestOps() {
        return interestOps;
    }

    public void setInterestOps(int interestOps) {
        this.interestOps = interestOps;
    }

    public int getOutstandingRequests() {
        return outstandingRequests;
    }

    public void setOutstandingRequests(int outstandingRequests) {
        this.outstandingRequests = outstandingRequests;
    }

    public long getPacketsReceived() {
        return packetsReceived;
    }

    public void setPacketsReceived(long packetsReceived) {
        this.packetsReceived = packetsReceived;
    }

    public long getPacketsSent() {
        return packetsSent;
    }

    public void setPacketsSent(long packetsSent) {
        this.packetsSent = packetsSent;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getLastOperation() {
        return lastOperation;
    }

    public void setLastOperation(String lastOperation) {
        this.lastOperation = lastOperation;
    }

    public long getEstablishTime() {
        return establishTime;
    }

    public void setEstablishTime(long establishTime) {
        this.establishTime = establishTime;
    }

    public int getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(int sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public String getLastZxid() {
        return lastZxid;
    }

    public void setLastZxid(String lastZxid) {
        this.lastZxid = lastZxid;
    }

    public long getLastResponseTime() {
        return lastResponseTime;
    }

    public void setLastResponseTime(long lastResponseTime) {
        this.lastResponseTime = lastResponseTime;
    }

    public int getLastLatency() {
        return lastLatency;
    }

    public void setLastLatency(int lastLatency) {
        this.lastLatency = lastLatency;
    }

    public int getLastMinLatency() {
        return lastMinLatency;
    }

    public void setLastMinLatency(int lastMinLatency) {
        this.lastMinLatency = lastMinLatency;
    }

    public int getLastAvgLatency() {
        return lastAvgLatency;
    }

    public void setLastAvgLatency(int lastAvgLatency) {
        this.lastAvgLatency = lastAvgLatency;
    }

    public int getLastMaxLatency() {
        return lastMaxLatency;
    }

    public void setLastMaxLatency(int lastMaxLatency) {
        this.lastMaxLatency = lastMaxLatency;
    }

    public String getLastCxid() {
        return lastCxid;
    }

    public void setLastCxid(String lastCxid) {
        this.lastCxid = lastCxid;
    }

}
