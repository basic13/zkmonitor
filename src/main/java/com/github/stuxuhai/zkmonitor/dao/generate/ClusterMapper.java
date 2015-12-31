package com.github.stuxuhai.zkmonitor.dao.generate;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.github.stuxuhai.zkmonitor.dto.generate.Cluster;
import com.github.stuxuhai.zkmonitor.dto.generate.ClusterExample;

public interface ClusterMapper {
    int countByExample(ClusterExample example);

    int deleteByExample(ClusterExample example);

    int deleteByPrimaryKey(Integer clusterId);

    int insert(Cluster record);

    int insertSelective(Cluster record);

    List<Cluster> selectByExample(ClusterExample example);

    Cluster selectByPrimaryKey(Integer clusterId);

    int updateByExampleSelective(@Param("record") Cluster record, @Param("example") ClusterExample example);

    int updateByExample(@Param("record") Cluster record, @Param("example") ClusterExample example);

    int updateByPrimaryKeySelective(Cluster record);

    int updateByPrimaryKey(Cluster record);
}