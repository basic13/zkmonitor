/*
 * Author: wuya
 * Create Date: 2015年11月25日 下午6:52:07
 */

package com.github.stuxuhai.zkmonitor.conf;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

import com.google.common.base.Throwables;

public class ZKMonitorConfig {

    private static Configuration config = null;

    static {
        try {
            config = new PropertiesConfiguration("config.properties");
            ((PropertiesConfiguration) config).setReloadingStrategy(new FileChangedReloadingStrategy());
        } catch (ConfigurationException e) {
            Throwables.propagate(e);
        }
    }

    public static Configuration getConfig() {
        return config;
    }

}
