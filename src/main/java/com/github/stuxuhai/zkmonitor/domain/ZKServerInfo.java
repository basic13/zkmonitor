/*
 * Author: wuya
 * Create Date: 2015年11月27日 下午4:05:26
 */

package com.github.stuxuhai.zkmonitor.domain;

import java.util.Objects;

public class ZKServerInfo {

    private final String ip;
    private final int port;

    public ZKServerInfo(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, port);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null && !(obj instanceof ZKServerInfo)) {
            return false;
        }

        ZKServerInfo other = (ZKServerInfo) obj;
        return Objects.equals(ip, other.ip) && Objects.equals(port, other.port);
    }

}
