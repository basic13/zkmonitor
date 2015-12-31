/*
 * Author: wuya
 * Create Date: 2015年11月26日 下午3:06:54
 */

package com.github.stuxuhai.zkmonitor.command;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

public class ZKStatCommand implements ZKCommand {

    @Override
    public String getCommand() {
        return "stat";
    }

    @Override
    public Map<String, Object> parseMetrics(List<String> lines) {
        Map<String, Object> metrics = Maps.newTreeMap();
        boolean skip = true;
        for (String line : lines) {
            if (skip) {
                if (line.trim().isEmpty()) {
                    skip = false;
                }
                continue;
            }

            String[] tokens = line.split(":", 2);
            metrics.put(tokens[0], tokens[1].trim());
        }

        return metrics;
    }

}
