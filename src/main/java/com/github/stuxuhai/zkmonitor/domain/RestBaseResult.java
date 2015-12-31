/*
 * Author: wuya
 * Create Date: 2015年12月1日 上午10:07:22
 */

package com.github.stuxuhai.zkmonitor.domain;

public class RestBaseResult {

    private boolean success;
    private String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
