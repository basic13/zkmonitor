package com.github.stuxuhai.zkmonitor.dao.generate;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.github.stuxuhai.zkmonitor.dto.generate.LatestServerMetrics;
import com.github.stuxuhai.zkmonitor.dto.generate.LatestServerMetricsExample;

public interface LatestServerMetricsMapper {
    int countByExample(LatestServerMetricsExample example);

    int deleteByExample(LatestServerMetricsExample example);

    int deleteByPrimaryKey(Long metricsId);

    int insert(LatestServerMetrics record);

    int insertSelective(LatestServerMetrics record);

    List<LatestServerMetrics> selectByExample(LatestServerMetricsExample example);

    LatestServerMetrics selectByPrimaryKey(Long metricsId);

    int updateByExampleSelective(@Param("record") LatestServerMetrics record, @Param("example") LatestServerMetricsExample example);

    int updateByExample(@Param("record") LatestServerMetrics record, @Param("example") LatestServerMetricsExample example);

    int updateByPrimaryKeySelective(LatestServerMetrics record);

    int updateByPrimaryKey(LatestServerMetrics record);
}