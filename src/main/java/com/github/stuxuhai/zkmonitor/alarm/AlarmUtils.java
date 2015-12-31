/*
 * Author: wuya
 * Create Date: 2015年11月26日 下午11:49:47
 */

package com.github.stuxuhai.zkmonitor.alarm;

import java.util.List;

import com.github.stuxuhai.zkmonitor.dto.generate.AlarmConfig;
import com.github.stuxuhai.zkmonitor.dto.generate.Server;
import com.github.stuxuhai.zkmonitor.dto.generate.ServerMetrics;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class AlarmUtils {

    private static Alarmer alarmer = new DefaultAlarmer();

    private static void checkThreshold(Integer threshold, int value, String metricName, List<String> list) {
        if (threshold != null && threshold.intValue() > 0 && value > threshold) {
            list.add(metricName + "超过阈值" + threshold + ",现值" + value);
        }
    }

    public static void checkAlarm(AlarmConfig alarmConfig, ServerMetrics serverMetrics, Server server) {
        List<String> list = Lists.newArrayList();
        checkThreshold(alarmConfig.getWatchingPathsThreshold(), serverMetrics.getWatchingPaths(), "WatchingPath", list);
        checkThreshold(alarmConfig.getAvgLatencyThreshold(), serverMetrics.getAvgLatency(), "平均延迟", list);
        checkThreshold(alarmConfig.getMaxLatencyThreshold(), serverMetrics.getMaxLatency(), "最大延迟", list);
        checkThreshold(alarmConfig.getAliveConnectionsThreshold(), serverMetrics.getAliveConnections(), "连接数", list);
        checkThreshold(alarmConfig.getOutstandingRequestsThreshold(), serverMetrics.getOutstandingRequests(), "OutstandingRequest", list);
        checkThreshold(alarmConfig.getZnodeCountThreshold(), serverMetrics.getZnodeCount(), "Znode数", list);
        checkThreshold(alarmConfig.getWatchCountThreshold(), serverMetrics.getWatchCount(), "Watch数", list);
        checkThreshold(alarmConfig.getOpenFileDescriptorCountThreshold(), serverMetrics.getOpenFileDescriptorCount(), "文件描述符打开数", list);

        if (list.size() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("ZooKeeper报警(机器");
            sb.append(server.getServerIp());
            sb.append("):");
            sb.append(Joiner.on(";").join(list));
            List<String> receiver = Lists.newArrayList(alarmConfig.getReceiver().split(","));
            alarmer.alarm(receiver, sb.toString());
        }
    }
}
