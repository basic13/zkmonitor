/*
 * Author: wuya
 * Create Date: 2015年11月26日 下午11:16:17
 */

package com.github.stuxuhai.zkmonitor;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.stuxuhai.zkmonitor.dao.generate.AlarmConfigMapper;
import com.github.stuxuhai.zkmonitor.dao.generate.ServerMapper;
import com.github.stuxuhai.zkmonitor.domain.ZKServerInfo;
import com.github.stuxuhai.zkmonitor.dto.generate.AlarmConfig;
import com.github.stuxuhai.zkmonitor.dto.generate.AlarmConfigExample;
import com.github.stuxuhai.zkmonitor.dto.generate.Server;
import com.github.stuxuhai.zkmonitor.dto.generate.ServerExample;
import com.google.common.collect.Maps;

@Service
public class ZKMetaStore {

    @Autowired
    private AlarmConfigMapper alarmConfigMapper;

    @Autowired
    private ServerMapper serverMapper;

    private Map<ZKServerInfo, Server> serverMap = Maps.newConcurrentMap();

    private Map<Integer, AlarmConfig> alarmConfigMap = Maps.newConcurrentMap();

    @PostConstruct
    public void init() {
        AlarmConfigExample alarmConfigExample = new AlarmConfigExample();
        List<AlarmConfig> alarmConfigs = alarmConfigMapper.selectByExample(alarmConfigExample);
        for (AlarmConfig alarmConfig : alarmConfigs) {
            alarmConfigMap.put(alarmConfig.getClusterId(), alarmConfig);
        }

        ServerExample serverExample = new ServerExample();
        List<Server> servers = serverMapper.selectByExample(serverExample);
        for (Server server : servers) {
            serverMap.put(new ZKServerInfo(server.getServerIp(), server.getServerPort()), server);
        }
    }

    public Map<ZKServerInfo, Server> getServerInfo() {
        return serverMap;
    }

    public Map<Integer, AlarmConfig> getAlarmConfigInfo() {
        return alarmConfigMap;
    }
}
