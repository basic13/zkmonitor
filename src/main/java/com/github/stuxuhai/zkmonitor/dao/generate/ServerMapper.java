package com.github.stuxuhai.zkmonitor.dao.generate;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.github.stuxuhai.zkmonitor.dto.generate.Server;
import com.github.stuxuhai.zkmonitor.dto.generate.ServerExample;

public interface ServerMapper {
    int countByExample(ServerExample example);

    int deleteByExample(ServerExample example);

    int deleteByPrimaryKey(Integer serverId);

    int insert(Server record);

    int insertSelective(Server record);

    List<Server> selectByExample(ServerExample example);

    Server selectByPrimaryKey(Integer serverId);

    int updateByExampleSelective(@Param("record") Server record, @Param("example") ServerExample example);

    int updateByExample(@Param("record") Server record, @Param("example") ServerExample example);

    int updateByPrimaryKeySelective(Server record);

    int updateByPrimaryKey(Server record);
}