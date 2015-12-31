/*
 * Author: wuya
 * Create Date: 2015年11月26日 下午2:59:22
 */

package com.github.stuxuhai.zkmonitor.command;

import java.util.List;
import java.util.Map;

public interface ZKCommand {

    String getCommand();

    Map<String, Object> parseMetrics(List<String> lines);

}
