/*
 * Author: wuya
 * Create Date: 2015年11月27日 下午3:58:22
 */

package com.github.stuxuhai.zkmonitor;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Vector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.github.stuxuhai.zkmonitor.alarm.AlarmUtils;
import com.github.stuxuhai.zkmonitor.command.ZKCommand;
import com.github.stuxuhai.zkmonitor.command.ZKMntrCommand;
import com.github.stuxuhai.zkmonitor.command.ZKRuokCommand;
import com.github.stuxuhai.zkmonitor.command.ZKSrvrCommand;
import com.github.stuxuhai.zkmonitor.command.ZKStatCommand;
import com.github.stuxuhai.zkmonitor.command.ZKWchsCommand;
import com.github.stuxuhai.zkmonitor.dao.generate.LatestServerMetricsMapper;
import com.github.stuxuhai.zkmonitor.dao.generate.ServerMetricsMapper;
import com.github.stuxuhai.zkmonitor.domain.ZKServerInfo;
import com.github.stuxuhai.zkmonitor.dto.generate.AlarmConfig;
import com.github.stuxuhai.zkmonitor.dto.generate.LatestServerMetrics;
import com.github.stuxuhai.zkmonitor.dto.generate.LatestServerMetricsExample;
import com.github.stuxuhai.zkmonitor.dto.generate.Server;
import com.github.stuxuhai.zkmonitor.dto.generate.ServerMetrics;
import com.github.stuxuhai.zkmonitor.util.SocketUtils;
import com.google.common.collect.Maps;

@Repository
@Scope("prototype")
public class MetricCollector extends Thread {

    @Autowired
    private ServerMetricsMapper metricsMapper;

    @Autowired
    private LatestServerMetricsMapper latestMetricsMapper;

    @Autowired
    private ZKMetaStore zkMetaStore;

    private Queue<ZKServerInfo> queue;

    public MetricCollector() {
    }

    public MetricCollector(Queue<ZKServerInfo> queue) {
        this.queue = queue;
    }

    private static List<ZKCommand> zkCommands = new Vector<>();
    private static final Logger LOGGER = LogManager.getLogger();

    static {
        zkCommands.add(new ZKRuokCommand());
        zkCommands.add(new ZKSrvrCommand());
        zkCommands.add(new ZKStatCommand());
        zkCommands.add(new ZKMntrCommand());
        zkCommands.add(new ZKWchsCommand());
    }

    @Override
    public void run() {
        while (true) {
            ZKServerInfo zkServer = queue.poll();
            if (zkServer == null) {
                yield();
                continue;
            }

            String ip = zkServer.getIp();
            int port = zkServer.getPort();
            ZKServerInfo zkServerInfo = new ZKServerInfo(ip, port);

            Map<String, Object> metrics = Maps.newHashMap();
            for (ZKCommand zkCommand : zkCommands) {
                try {
                    List<String> lines = SocketUtils.sendCommand(ip, port, zkCommand.getCommand());
                    metrics.putAll(zkCommand.parseMetrics(lines));
                } catch (IOException e) {
                    LOGGER.error("", e);
                }
            }

            DateTime now = DateTime.now();
            ServerMetrics serverMetrics = new ServerMetrics();

            Server server = zkMetaStore.getServerInfo().get(zkServerInfo);
            serverMetrics.setServerId(server.getServerId());
            serverMetrics.setClusterId(server.getClusterId());
            serverMetrics.setCollectTime(now.getMillis() / 1000);
            serverMetrics.setServerStatus(metrics.get("ruok").toString().equals("imok") ? 1 : 0);
            serverMetrics.setZxid(metrics.get("Zxid").toString());
            serverMetrics.setWatchingPaths(Integer.parseInt(metrics.get("watching.paths").toString()));
            serverMetrics.setAvgLatency(Integer.parseInt(metrics.get("zk_avg_latency").toString()));
            serverMetrics.setMaxLatency(Integer.parseInt(metrics.get("zk_max_latency").toString()));
            serverMetrics.setPacketsReceived(Long.parseLong(metrics.get("zk_packets_received").toString()));
            serverMetrics.setPacketsSent(Long.parseLong(metrics.get("zk_packets_sent").toString()));
            serverMetrics.setAliveConnections(Integer.parseInt(metrics.get("zk_num_alive_connections").toString()));
            serverMetrics.setOutstandingRequests(Integer.parseInt(metrics.get("zk_outstanding_requests").toString()));
            serverMetrics.setServerMode(metrics.get("zk_server_state").toString());
            serverMetrics.setZnodeCount(Integer.parseInt(metrics.get("zk_znode_count").toString()));
            serverMetrics.setWatchCount(Integer.parseInt(metrics.get("zk_watch_count").toString()));
            serverMetrics.setEphemeralsCount(Integer.parseInt(metrics.get("zk_ephemerals_count").toString()));
            serverMetrics.setApproximateDataSize(Long.parseLong(metrics.get("zk_approximate_data_size").toString()));
            serverMetrics.setOpenFileDescriptorCount(Integer.parseInt(metrics.get("zk_open_file_descriptor_count").toString()));
            serverMetrics.setMaxFileDescriptorCount(Integer.parseInt(metrics.get("zk_max_file_descriptor_count").toString()));
            metricsMapper.insertSelective(serverMetrics);

            /**
             * 更新最近记录中server记录的信息
             */
            LatestServerMetrics latestServerMetrics = new LatestServerMetrics();
            LatestServerMetricsExample latestrMetricsExample = new LatestServerMetricsExample();

            latestServerMetrics.setServerId(server.getServerId());
            latestServerMetrics.setClusterId(server.getClusterId());
            latestServerMetrics.setCollectTime(now.getMillis() / 1000);
            latestServerMetrics.setServerStatus(metrics.get("ruok").toString().equals("imok") ? 1 : 0);
            latestServerMetrics.setZxid(metrics.get("Zxid").toString());
            latestServerMetrics.setWatchingPaths(Integer.parseInt(metrics.get("watching.paths").toString()));
            latestServerMetrics.setAvgLatency(Integer.parseInt(metrics.get("zk_avg_latency").toString()));
            latestServerMetrics.setMaxLatency(Integer.parseInt(metrics.get("zk_max_latency").toString()));
            latestServerMetrics.setPacketsReceived(Long.parseLong(metrics.get("zk_packets_received").toString()));
            latestServerMetrics.setPacketsSent(Long.parseLong(metrics.get("zk_packets_sent").toString()));
            latestServerMetrics.setAliveConnections(Integer.parseInt(metrics.get("zk_num_alive_connections").toString()));
            latestServerMetrics.setOutstandingRequests(Integer.parseInt(metrics.get("zk_outstanding_requests").toString()));
            latestServerMetrics.setServerMode(metrics.get("zk_server_state").toString());
            latestServerMetrics.setZnodeCount(Integer.parseInt(metrics.get("zk_znode_count").toString()));
            latestServerMetrics.setWatchCount(Integer.parseInt(metrics.get("zk_watch_count").toString()));
            latestServerMetrics.setEphemeralsCount(Integer.parseInt(metrics.get("zk_ephemerals_count").toString()));
            latestServerMetrics.setApproximateDataSize(Long.parseLong(metrics.get("zk_approximate_data_size").toString()));
            latestServerMetrics.setOpenFileDescriptorCount(Integer.parseInt(metrics.get("zk_open_file_descriptor_count").toString()));
            latestServerMetrics.setMaxFileDescriptorCount(Integer.parseInt(metrics.get("zk_max_file_descriptor_count").toString()));

            /**
             * 删除latest_server_metrics表中原有的该server metric记录
             */
            latestrMetricsExample.or().andServerIdEqualTo(server.getServerId());
            latestMetricsMapper.deleteByExample(latestrMetricsExample);

            latestMetricsMapper.insertSelective(latestServerMetrics);

            AlarmConfig alarmConfig = zkMetaStore.getAlarmConfigInfo().get(server.getClusterId());
            if (alarmConfig.getEnable().intValue() == 1) {
                AlarmUtils.checkAlarm(alarmConfig, serverMetrics, server);
            }
        }
    }

}
