/*
 * Author: wuya
 * Create Date: 2015年11月30日 下午10:54:17
 */

package com.github.stuxuhai.zkmonitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cluster")
public class ClusterController {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCluster() {
        return "addCluster";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String viewCluster() {
        return "viewAllClusters";
    }

    @RequestMapping(value = "/view/{clusterId}", method = RequestMethod.GET)
    public String viewCluster(@PathVariable("clusterId") int clusterId) {
        return "viewCluster";
    }

    @RequestMapping(value = "/edit/{clusterId}", method = RequestMethod.GET)
    public String editCluster(@PathVariable("clusterId") int clusterId) {
        return "editCluster";
    }

    @RequestMapping(value = "/overview/{clusterId}", method = RequestMethod.GET)
    public String overViewCluster(@PathVariable("clusterId") int clusterId) {
        return "overViewCluster";
    }

    /**
     * 查看监控页面
     * @return
     */
    @RequestMapping(value = "/metrics", method = RequestMethod.GET)
    public String clusterMetrics() {
        return "clusterMetrics";
    }
}
