package com.heqingbao.microweather.vo;

import java.io.Serializable;

/**
 * 未来天气
 */
public class Forecast implements Serializable {

    /*"forecast": [
    {
        "date": "9日星期六",
            "high": "高温 24℃",
            "fengli": "<![CDATA[<3级]]>",
            "low": "低温 18℃",
            "fengxiang": "无持续风向",
            "type": "多云"
    },]*/

    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getFengli() {
        return fengli;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getFengxiang() {
        return fengxiang;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
