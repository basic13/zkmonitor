/*
 * Author: wuya
 * Create Date: 2015年12月1日 上午10:52:41
 */

package com.github.stuxuhai.zkmonitor.vo;

import java.util.List;

import com.github.stuxuhai.zkmonitor.dto.generate.AlarmConfig;
import com.github.stuxuhai.zkmonitor.dto.generate.Cluster;
import com.github.stuxuhai.zkmonitor.dto.generate.LatestServerMetrics;
import com.github.stuxuhai.zkmonitor.dto.generate.Server;
import com.github.stuxuhai.zkmonitor.dto.generate.ServerMetrics;

public class ClusterVO {

    private Cluster cluster;
    private List<Server> servers;
    private AlarmConfig alarmConfig;
    private List<ServerMetrics> serverMetricses;
    private List<LatestServerMetrics> latestServerMetricses;

    public Cluster getCluster() {
        return cluster;
    }

    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }

    public List<Server> getServers() {
        return servers;
    }

    public void setServers(List<Server> servers) {
        this.servers = servers;
    }

    public AlarmConfig getAlarmConfig() {
        return alarmConfig;
    }

    public void setAlarmConfig(AlarmConfig alarmConfig) {
        this.alarmConfig = alarmConfig;
    }

    public List<ServerMetrics> getServerMetricses() {
        return serverMetricses;
    }

    public void setServerMetricses(List<ServerMetrics> serverMetricses) {
        this.serverMetricses = serverMetricses;
    }

    public List<LatestServerMetrics> getLatestServerMetricses() {
        return latestServerMetricses;
    }

    public void setLatestServerMetricses(List<LatestServerMetrics> latestServerMetricses) {
        this.latestServerMetricses = latestServerMetricses;
    }
}
