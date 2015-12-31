/*
 * Author: wuya
 * Create Date: 2015年11月26日 下午3:06:54
 */

package com.github.stuxuhai.zkmonitor.command;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class ZKWchcCommand implements ZKCommand {

    @Override
    public String getCommand() {
        return "wchc";
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> parseMetrics(List<String> lines) {
        Map<String, Object> metrics = Maps.newTreeMap();
        String lastSessionId = null;
        for (String line : lines) {
            String path = line.trim();
            if (path.startsWith("/")) {
                List<String> list = null;
                if (metrics.containsKey(lastSessionId)) {
                    list = (List<String>) metrics.get(lastSessionId);
                } else {
                    list = Lists.newArrayList();
                    metrics.put(lastSessionId, list);
                }

                list.add(path);
            } else {
                lastSessionId = line;
            }
        }
        return metrics;
    }

}
