/*
 * Author: wuya
 * Create Date: 2015年11月25日 下午1:30:06
 */

package com.github.stuxuhai.zkmonitor.alarm;

import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.stuxuhai.zkmonitor.conf.ZKMonitorConfig;
import com.google.common.collect.Maps;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class DefaultAlarmer extends Alarmer {

    private Configuration config = ZKMonitorConfig.getConfig();
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public boolean alarm(AlarmLevel alarmLevel, List<AlarmType> alarmTypes, List<String> receiver, String message) {
        Map<String, Object> fields = Maps.newHashMap();
        fields.put("appName", config.getString("alarm.app.name"));
        fields.put("errorLevel", alarmLevel.name());
        fields.put("errorMsg", message);

        Map<String, Object> ext = Maps.newHashMap();
        ext.put("nickname", receiver);
        fields.put("ext", ext);

        try {
            HttpResponse<JsonNode> response = Unirest.post(config.getString("alarm.service.url")).fields(fields).asJson();
            return response.getBody().getObject().getBoolean("success");
        } catch (UnirestException e) {
            LOGGER.error("Alarm error", e);
        }

        return false;
    }

}
