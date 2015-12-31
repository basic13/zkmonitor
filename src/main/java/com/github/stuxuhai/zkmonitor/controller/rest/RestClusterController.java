/*
 * Author: wuya
 * Create Date: 2015年12月1日 上午9:51:51
 */

package com.github.stuxuhai.zkmonitor.controller.rest;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.stuxuhai.zkmonitor.ZKMetaStore;
import com.github.stuxuhai.zkmonitor.dao.generate.AlarmConfigMapper;
import com.github.stuxuhai.zkmonitor.dao.generate.ClusterMapper;
import com.github.stuxuhai.zkmonitor.dao.generate.LatestServerMetricsMapper;
import com.github.stuxuhai.zkmonitor.dao.generate.ServerMapper;
import com.github.stuxuhai.zkmonitor.dao.generate.ServerMetricsMapper;
import com.github.stuxuhai.zkmonitor.domain.RestBaseResult;
import com.github.stuxuhai.zkmonitor.domain.ZKServerInfo;
import com.github.stuxuhai.zkmonitor.dto.generate.AlarmConfig;
import com.github.stuxuhai.zkmonitor.dto.generate.AlarmConfigExample;
import com.github.stuxuhai.zkmonitor.dto.generate.Cluster;
import com.github.stuxuhai.zkmonitor.dto.generate.ClusterExample;
import com.github.stuxuhai.zkmonitor.dto.generate.LatestServerMetrics;
import com.github.stuxuhai.zkmonitor.dto.generate.LatestServerMetricsExample;
import com.github.stuxuhai.zkmonitor.dto.generate.Server;
import com.github.stuxuhai.zkmonitor.dto.generate.ServerExample;
import com.github.stuxuhai.zkmonitor.dto.generate.ServerMetrics;
import com.github.stuxuhai.zkmonitor.dto.generate.ServerMetricsExample;
import com.github.stuxuhai.zkmonitor.vo.ClusterVO;
import com.google.common.collect.Lists;

@Controller
@RequestMapping("/rest/clusters")
public class RestClusterController {

    @Autowired
    private ClusterMapper clusterMapper;

    @Autowired
    private ServerMapper serverMapper;

    @Autowired
    private AlarmConfigMapper alarmConfigMapper;

    @Autowired
    private ServerMetricsMapper serverMetricsMapper;

    @Autowired
    private LatestServerMetricsMapper latestServerMetricsMapper;

    @Autowired
    private ZKMetaStore zkMetaStore;

    /**
     * 创建集群
     * 
     * @param clusterVO
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public RestBaseResult addCluster(@RequestBody ClusterVO clusterVO) {
        RestBaseResult result = new RestBaseResult();
        result.setSuccess(false);

        Cluster cluster = clusterVO.getCluster();
        String clusterName = cluster.getClusterName();
        if (clusterName != null && !clusterName.trim().isEmpty()) {
            Map<ZKServerInfo, Server> serverMap = zkMetaStore.getServerInfo();
            Map<Integer, AlarmConfig> alarmConfigMap = zkMetaStore.getAlarmConfigInfo();

            try {
                clusterMapper.insertSelective(cluster);
                int clusterId = cluster.getClusterId();

                List<Server> servers = clusterVO.getServers();
                if (servers == null || servers.size() == 0) {
                    result.setMsg("Server列表为空");
                    return result;
                }

                for (Server server : servers) {
                    server.setClusterId(clusterId);
                    serverMapper.insertSelective(server);
                    serverMap.put(new ZKServerInfo(server.getServerIp(), server.getServerPort()), server);
                }

                AlarmConfig alarmConfig = clusterVO.getAlarmConfig();
                alarmConfig.setClusterId(clusterId);
                alarmConfig.setEnable(1);
                alarmConfig.setAlarmType("1");
                if (alarmConfig.getReceiver() == null || alarmConfig.getReceiver().trim().isEmpty()) {
                    result.setMsg("报警接收人不能为空");
                    return result;
                }

                alarmConfigMapper.insertSelective(alarmConfig);
                alarmConfigMap.put(clusterId, alarmConfig);

                result.setSuccess(true);
                result.setMsg("集群创建成功");
                return result;
            } catch (DuplicateKeyException e) {
                result.setMsg("集群名称 " + clusterName + " 已存在，请修改");
            }
        } else {
            result.setMsg("集群名称不能为空");
        }

        return result;
    }

    /**
     * 查看集群
     * 
     * @param clusterId
     * @return
     */
    @RequestMapping(value = "/{clusterId}", method = RequestMethod.GET)
    @ResponseBody
    public ClusterVO viewCluster(@PathVariable("clusterId") int clusterId) {
        ClusterVO result = new ClusterVO();
        Cluster cluster = clusterMapper.selectByPrimaryKey(clusterId);
        if (cluster != null) {
            result.setCluster(cluster);
            ServerExample serverExample = new ServerExample();
            serverExample.createCriteria().andClusterIdEqualTo(clusterId);
            List<Server> servers = serverMapper.selectByExample(serverExample);
            result.setServers(servers);

            AlarmConfigExample alarmConfigExample = new AlarmConfigExample();
            alarmConfigExample.createCriteria().andClusterIdEqualTo(clusterId);
            List<AlarmConfig> alarmConfigs = alarmConfigMapper.selectByExample(alarmConfigExample);
            result.setAlarmConfig(alarmConfigs.get(0));
        }

        return result;
    }

    /**
     * 查看集群
     * 
     * @param clusterId
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<ClusterVO> viewClusters() {
        List<ClusterVO> result = Lists.newArrayList();
        ClusterExample clusterExample = new ClusterExample();
        List<Cluster> clusters = clusterMapper.selectByExample(clusterExample);
        for (Cluster cluster : clusters) {
            int clusterId = cluster.getClusterId();
            ClusterVO clusterVO = new ClusterVO();
            clusterVO.setCluster(cluster);
            ServerExample serverExample = new ServerExample();
            serverExample.createCriteria().andClusterIdEqualTo(clusterId);
            List<Server> servers = serverMapper.selectByExample(serverExample);
            clusterVO.setServers(servers);

            AlarmConfigExample alarmConfigExample = new AlarmConfigExample();
            alarmConfigExample.createCriteria().andClusterIdEqualTo(clusterId);
            List<AlarmConfig> alarmConfigs = alarmConfigMapper.selectByExample(alarmConfigExample);
            clusterVO.setAlarmConfig(alarmConfigs.get(0));

            result.add(clusterVO);
        }

        return result;
    }

    /**
     * 删除集群
     * 
     * @param clusterId
     * @return
     */
    @RequestMapping(value = "/{clusterId}", method = RequestMethod.DELETE)
    @ResponseBody
    @Transactional
    public RestBaseResult deleteCluster(@PathVariable("clusterId") int clusterId) {
        RestBaseResult result = new RestBaseResult();
        clusterMapper.deleteByPrimaryKey(clusterId);

        ServerExample serverExample = new ServerExample();
        serverExample.createCriteria().andClusterIdEqualTo(clusterId);
        serverMapper.deleteByExample(serverExample);

        AlarmConfigExample alarmConfigExample = new AlarmConfigExample();
        alarmConfigExample.createCriteria().andClusterIdEqualTo(clusterId);
        alarmConfigMapper.deleteByExample(alarmConfigExample);

        Map<ZKServerInfo, Server> serverMap = zkMetaStore.getServerInfo();
        Iterator<Entry<ZKServerInfo, Server>> serverIterator = serverMap.entrySet().iterator();
        while (serverIterator.hasNext()) {
            Entry<ZKServerInfo, Server> entry = serverIterator.next();
            if (entry.getValue().getClusterId().intValue() == clusterId) {
                serverIterator.remove();
            }
        }

        Map<Integer, AlarmConfig> alarmConfigMap = zkMetaStore.getAlarmConfigInfo();
        Iterator<Entry<Integer, AlarmConfig>> alarmConfigIterator = alarmConfigMap.entrySet().iterator();
        while (alarmConfigIterator.hasNext()) {
            Entry<Integer, AlarmConfig> entry = alarmConfigIterator.next();
            if (entry.getValue().getClusterId().intValue() == clusterId) {
                alarmConfigIterator.remove();
            }
        }

        result.setSuccess(true);
        result.setMsg("集群删除成功");
        return result;
    }

    /**
     * 更新集群
     * 
     * @param clusterVO
     * @return
     */
    @RequestMapping(value = "/{clusterId}", method = RequestMethod.PUT)
    @ResponseBody
    @Transactional
    public RestBaseResult updateCluster(@RequestBody ClusterVO clusterVO, @PathVariable("clusterId") int clusterId) {
        RestBaseResult result = new RestBaseResult();
        Cluster cluster = clusterVO.getCluster();
        String clusterName = cluster.getClusterName();

        if (clusterName != null && !clusterName.trim().isEmpty()) {
            Map<ZKServerInfo, Server> serverMap = zkMetaStore.getServerInfo();
            Map<Integer, AlarmConfig> alarmConfigMap = zkMetaStore.getAlarmConfigInfo();

            try {
                clusterMapper.updateByPrimaryKeySelective(cluster);

                ServerExample serverExample = new ServerExample();
                serverExample.createCriteria().andClusterIdEqualTo(clusterId);
                serverMapper.deleteByExample(serverExample);

                AlarmConfigExample alarmConfigExample = new AlarmConfigExample();
                alarmConfigExample.createCriteria().andClusterIdEqualTo(clusterId);
                alarmConfigMapper.deleteByExample(alarmConfigExample);

                List<Server> servers = clusterVO.getServers();
                for (Server server : servers) {
                    server.setClusterId(clusterId);
                    serverMapper.insertSelective(server);
                    serverMap.put(new ZKServerInfo(server.getServerIp(), server.getServerPort()), server);
                }

                AlarmConfig alarmConfig = clusterVO.getAlarmConfig();
                alarmConfig.setClusterId(clusterId);
                alarmConfig.setEnable(1);
                alarmConfig.setAlarmType("1");

                alarmConfigMapper.insertSelective(alarmConfig);
                alarmConfigMap.put(clusterId, alarmConfig);

                result.setSuccess(true);
                result.setMsg("集群更新成功");
                return result;
            } catch (DuplicateKeyException e) {
                result.setMsg("集群名称 " + clusterName + " 已存在，请修改");
            }
        } else {
            result.setMsg("集群名称不能为空");
        }

        result.setSuccess(false);
        return result;
    }

    /**
     * 获取集群现状
     *
     * @param clusterId
     * @return
     */
    @RequestMapping(value = "/overview/{clusterId}", method = RequestMethod.GET)
    @ResponseBody
    public ClusterVO overviewCluster(@PathVariable("clusterId") int clusterId) {
        ClusterVO result = new ClusterVO();
        Cluster cluster = clusterMapper.selectByPrimaryKey(clusterId);
        if (cluster != null) {
            result.setCluster(cluster);
            ServerExample serverExample = new ServerExample();
            serverExample.createCriteria().andClusterIdEqualTo(clusterId);
            List<Server> servers = serverMapper.selectByExample(serverExample);
            result.setServers(servers);

            AlarmConfigExample alarmConfigExample = new AlarmConfigExample();
            alarmConfigExample.createCriteria().andClusterIdEqualTo(clusterId);
            List<AlarmConfig> alarmConfigs = alarmConfigMapper.selectByExample(alarmConfigExample);
            result.setAlarmConfig(alarmConfigs.get(0));

            LatestServerMetricsExample latestMetricsExample = new LatestServerMetricsExample();
            latestMetricsExample.createCriteria().andClusterIdEqualTo(clusterId);
            List<LatestServerMetrics> latestServerMetricses = latestServerMetricsMapper.selectByExample(latestMetricsExample);

            result.setLatestServerMetricses(latestServerMetricses);
        }

        return result;
    }

    @RequestMapping(value = "/metrics/{clusterId}", method = RequestMethod.GET)
    @ResponseBody
    public ClusterVO clusterMetrics(@PathVariable("clusterId") int clusterId) {
        ClusterVO result = new ClusterVO();
        List<ServerMetrics> serverMetricsList = null;
        ServerMetricsExample serverMetricsExample = new ServerMetricsExample();
        serverMetricsExample.createCriteria().andClusterIdEqualTo(clusterId);
        serverMetricsList = serverMetricsMapper.selectByExample(serverMetricsExample);
        if (serverMetricsExample != null) {
            result.setServerMetricses(serverMetricsList);
        }
        return result;
    }

}
