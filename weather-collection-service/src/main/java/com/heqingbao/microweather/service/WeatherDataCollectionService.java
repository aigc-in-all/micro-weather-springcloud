package com.heqingbao.microweather.service;

public interface WeatherDataCollectionService {

    /**
     * 同步天气数据
     */
    void syncData();

    /**
     * 手动触发天气数据同步
     */
    @Deprecated
    void syncDataByManual();
}
