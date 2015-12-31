package com.github.stuxuhai.zkmonitor.dao.generate;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.github.stuxuhai.zkmonitor.dto.generate.ServerMetrics;
import com.github.stuxuhai.zkmonitor.dto.generate.ServerMetricsExample;

public interface ServerMetricsMapper {
    int countByExample(ServerMetricsExample example);

    int deleteByExample(ServerMetricsExample example);

    int deleteByPrimaryKey(Long metricsId);

    int insert(ServerMetrics record);

    int insertSelective(ServerMetrics record);

    List<ServerMetrics> selectByExample(ServerMetricsExample example);

    ServerMetrics selectByPrimaryKey(Long metricsId);

    int updateByExampleSelective(@Param("record") ServerMetrics record, @Param("example") ServerMetricsExample example);

    int updateByExample(@Param("record") ServerMetrics record, @Param("example") ServerMetricsExample example);

    int updateByPrimaryKeySelective(ServerMetrics record);

    int updateByPrimaryKey(ServerMetrics record);
}