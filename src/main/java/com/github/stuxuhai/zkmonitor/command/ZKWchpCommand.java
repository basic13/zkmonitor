/*
 * Author: wuya
 * Create Date: 2015年11月26日 下午3:06:54
 */

package com.github.stuxuhai.zkmonitor.command;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class ZKWchpCommand implements ZKCommand {

    @Override
    public String getCommand() {
        return "wchp";
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> parseMetrics(List<String> lines) {
        Map<String, Object> metrics = Maps.newTreeMap();
        String lastPath = null;
        for (String line : lines) {
            String sessionId = line.trim();
            if (!sessionId.startsWith("/")) {
                List<String> list = null;
                if (metrics.containsKey(lastPath)) {
                    list = (List<String>) metrics.get(lastPath);
                } else {
                    list = Lists.newArrayList();
                    metrics.put(lastPath, list);
                }

                list.add(sessionId);
            } else {
                lastPath = line;
            }
        }
        return metrics;
    }

}
