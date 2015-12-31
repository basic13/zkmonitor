/*
 * Author: wuya
 * Create Date: 2015年11月26日 下午3:50:45
 */

package com.github.stuxuhai.zkmonitor.command;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.stuxuhai.zkmonitor.domain.ZKClientConnectionInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class ZKConsCommand implements ZKCommand {

    private static final Pattern CLIENT_INFO_PATTERN = Pattern.compile(
            "/([^:]+):(\\d+)\\[(\\d+)\\]\\(queued=(\\d+),recved=(\\d+),sent=(\\d+),sid=([^,]+),lop=([^,]+),est=(\\d+),to=(\\d+),lcxid=([^,]+),lzxid=([^,]+),lresp=(\\d+),llat=(\\d+),minlat=(\\d+),avglat=(\\d+),maxlat=(\\d+)\\)");

    @Override
    public String getCommand() {
        return "cons";
    }

    @Override
    public Map<String, Object> parseMetrics(List<String> lines) {
        Map<String, Object> metrics = Maps.newTreeMap();
        Matcher m = CLIENT_INFO_PATTERN.matcher("");
        List<ZKClientConnectionInfo> list = Lists.newArrayList();
        for (String line : lines) {
            m.reset(line.trim());
            if (m.matches()) {
                ZKClientConnectionInfo info = new ZKClientConnectionInfo();
                info.setIp(m.group(1));
                info.setPort(Integer.parseInt(m.group(2)));
                info.setInterestOps(Integer.parseInt(m.group(3)));
                info.setOutstandingRequests(Integer.parseInt(m.group(4)));
                info.setPacketsReceived(Long.parseLong(m.group(5)));
                info.setPacketsSent(Long.parseLong(m.group(6)));
                info.setSessionId(m.group(7));
                info.setLastOperation(m.group(8));
                info.setEstablishTime(Long.parseLong(m.group(9)));
                info.setSessionTimeout(Integer.parseInt(m.group(10)));
                info.setLastCxid(m.group(11));
                info.setLastZxid(m.group(12));
                info.setLastResponseTime(Long.parseLong(m.group(13)));
                info.setLastLatency(Integer.parseInt(m.group(14)));
                info.setLastMinLatency(Integer.parseInt(m.group(15)));
                info.setLastAvgLatency(Integer.parseInt(m.group(16)));
                info.setLastMaxLatency(Integer.parseInt(m.group(17)));
                list.add(info);
            }
        }

        metrics.put("clients.connection.info", list);
        return metrics;
    }

}
