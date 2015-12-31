/*
 * Author: wuya
 * Create Date: 2015年11月26日 下午3:06:54
 */

package com.github.stuxuhai.zkmonitor.command;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.Maps;

public class ZKWchsCommand implements ZKCommand {

    private static Pattern FIRST_LINE_PATTRN = Pattern.compile("(\\d+) connections watching (\\d+) paths");
    private static Pattern SECOND_LINE_PATTRN = Pattern.compile("Total watches:(\\d+)");

    @Override
    public String getCommand() {
        return "wchs";
    }

    @Override
    public Map<String, Object> parseMetrics(List<String> lines) {
        Map<String, Object> metrics = Maps.newTreeMap();
        Matcher m1 = FIRST_LINE_PATTRN.matcher(lines.get(0));
        if (m1.matches()) {
            metrics.put("connections", m1.group(1));
            metrics.put("watching.paths", m1.group(2));
        }

        Matcher m2 = SECOND_LINE_PATTRN.matcher(lines.get(1));
        if (m2.matches()) {
            metrics.put("total.watches", m2.group(1));
        }

        return metrics;
    }

}
