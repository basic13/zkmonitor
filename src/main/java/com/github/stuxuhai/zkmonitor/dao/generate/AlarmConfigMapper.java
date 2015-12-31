package com.github.stuxuhai.zkmonitor.dao.generate;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.github.stuxuhai.zkmonitor.dto.generate.AlarmConfig;
import com.github.stuxuhai.zkmonitor.dto.generate.AlarmConfigExample;

public interface AlarmConfigMapper {
    int countByExample(AlarmConfigExample example);

    int deleteByExample(AlarmConfigExample example);

    int deleteByPrimaryKey(Integer alarmId);

    int insert(AlarmConfig record);

    int insertSelective(AlarmConfig record);

    List<AlarmConfig> selectByExample(AlarmConfigExample example);

    AlarmConfig selectByPrimaryKey(Integer alarmId);

    int updateByExampleSelective(@Param("record") AlarmConfig record, @Param("example") AlarmConfigExample example);

    int updateByExample(@Param("record") AlarmConfig record, @Param("example") AlarmConfigExample example);

    int updateByPrimaryKeySelective(AlarmConfig record);

    int updateByPrimaryKey(AlarmConfig record);
}