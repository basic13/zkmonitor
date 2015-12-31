package com.github.stuxuhai.zkmonitor.dto.generate;

import java.io.Serializable;

public class Cluster implements Serializable {
    private Integer clusterId;

    private String clusterName;

    private String description;

    private static final long serialVersionUID = 1L;

    public Integer getClusterId() {
        return clusterId;
    }

    public void setClusterId(Integer clusterId) {
        this.clusterId = clusterId;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}