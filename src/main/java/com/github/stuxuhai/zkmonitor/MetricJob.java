/*
 * Author: wuya
 * Create Date: 2015年11月27日 下午4:28:13
 */

package com.github.stuxuhai.zkmonitor;

import java.util.Map;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.github.stuxuhai.zkmonitor.domain.ZKServerInfo;
import com.github.stuxuhai.zkmonitor.dto.generate.Server;

@Repository
@Scope("prototype")
public class MetricJob extends Thread {

    @Autowired
    private ZKMetaStore zkMetaStore;

    private Queue<ZKServerInfo> queue;

    public MetricJob() {
    }

    public MetricJob(Queue<ZKServerInfo> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Map<ZKServerInfo, Server> servers = zkMetaStore.getServerInfo();
        for (ZKServerInfo zkServerInfo : servers.keySet()) {
            queue.offer(zkServerInfo);
        }
    }

}
