package com.heqingbao.microweather.vo;

import java.io.Serializable;

/**
 * 天气响应结构
 */
public class WeatherResponse implements Serializable {

    private Weather data;
    private int status;
    private String desc;

    public Weather getData() {
        return data;
    }

    public void setData(Weather data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
