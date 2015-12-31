/*
 * Author: wuya
 * Create Date: 2015年11月26日 下午3:06:54
 */

package com.github.stuxuhai.zkmonitor.command;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

public class ZKConfCommand implements ZKCommand {

    @Override
    public String getCommand() {
        return "conf";
    }

    @Override
    public Map<String, Object> parseMetrics(List<String> lines) {
        Map<String, Object> metrics = Maps.newTreeMap();
        for (String line : lines) {
            String[] tokens = line.trim().split("=", 2);
            metrics.put(tokens[0], tokens[1]);
        }
        return metrics;
    }

}
