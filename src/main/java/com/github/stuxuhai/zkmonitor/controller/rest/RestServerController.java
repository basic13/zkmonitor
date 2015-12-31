/*
 * Author: wuya
 * Create Date: 2015年12月2日 下午8:19:47
 */

package com.github.stuxuhai.zkmonitor.controller.rest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.stuxuhai.zkmonitor.command.ZKCommand;
import com.github.stuxuhai.zkmonitor.command.ZKConfCommand;
import com.github.stuxuhai.zkmonitor.command.ZKConsCommand;
import com.github.stuxuhai.zkmonitor.command.ZKEnviCommand;
import com.github.stuxuhai.zkmonitor.command.ZKWchcCommand;
import com.github.stuxuhai.zkmonitor.command.ZKWchpCommand;
import com.github.stuxuhai.zkmonitor.domain.ZKClientConnectionInfo;
import com.github.stuxuhai.zkmonitor.util.SocketUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Controller
@RequestMapping("/rest/servers")
public class RestServerController {

    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * 获取Server配置信息(ZK命令:conf, envi)
     * 
     * @param ip
     * @param port
     * @return
     */
    @RequestMapping(value = "/config", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getServerConfig(@RequestParam("ip") String ip, @RequestParam("port") int port) {
        List<ZKCommand> zkCommands = Lists.newArrayList(new ZKConfCommand(), new ZKEnviCommand());
        Map<String, Object> result = Maps.newHashMap();
        try {
            for (ZKCommand zkCommand : zkCommands) {
                List<String> lines = SocketUtils.sendCommand(ip, port, zkCommand.getCommand());
                result.putAll(zkCommand.parseMetrics(lines));
            }
        } catch (IOException e) {
            LOGGER.error("", e);
        }

        return result;
    }

    /**
     * 获取客户端连接信息
     * 
     * @param ip
     * @param port
     * @return
     */
    @RequestMapping(value = "/connection", method = RequestMethod.GET)
    @ResponseBody
    public List<ZKClientConnectionInfo> getClientsConnectionInfo(@RequestParam("ip") String ip, @RequestParam("port") int port) {
        ZKCommand cmd = new ZKConsCommand();
        try {
            List<String> lines = SocketUtils.sendCommand(ip, port, cmd.getCommand());
            @SuppressWarnings("unchecked")
            List<ZKClientConnectionInfo> list = (List<ZKClientConnectionInfo>) cmd.parseMetrics(lines).get("clients.connection.info");
            return list;
        } catch (IOException e) {
            LOGGER.error("", e);
        }

        return null;
    }

    /**
     * 获取Session信息
     * 
     * @param ip
     * @param port
     * @return
     */
    @RequestMapping(value = "/session", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getSessions(@RequestParam("ip") String ip, @RequestParam("port") int port) {
        ZKCommand cmd = new ZKWchcCommand();
        try {
            List<String> lines = SocketUtils.sendCommand(ip, port, cmd.getCommand());
            return cmd.parseMetrics(lines);
        } catch (IOException e) {
            LOGGER.error("", e);
        }

        return null;
    }

    /**
     * 获取Path信息
     * 
     * @param ip
     * @param port
     * @return
     */
    @RequestMapping(value = "/path", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getPaths(@RequestParam("ip") String ip, @RequestParam("port") int port) {
        ZKCommand cmd = new ZKWchpCommand();
        try {
            List<String> lines = SocketUtils.sendCommand(ip, port, cmd.getCommand());
            return cmd.parseMetrics(lines);
        } catch (IOException e) {
            LOGGER.error("", e);
        }

        return null;
    }
}
