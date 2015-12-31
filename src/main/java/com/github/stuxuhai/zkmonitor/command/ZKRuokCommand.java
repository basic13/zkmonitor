/*
 * Author: wuya
 * Create Date: 2015年11月26日 下午3:06:54
 */

package com.github.stuxuhai.zkmonitor.command;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

public class ZKRuokCommand implements ZKCommand {

    @Override
    public String getCommand() {
        return "ruok";
    }

    @Override
    public Map<String, Object> parseMetrics(List<String> lines) {
        Map<String, Object> metrics = Maps.newTreeMap();
        metrics.put("ruok", lines.get(0));
        return metrics;
    }

}
