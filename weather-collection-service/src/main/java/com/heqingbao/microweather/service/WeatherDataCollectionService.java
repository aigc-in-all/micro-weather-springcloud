package com.heqingbao.microweather.service;

public interface WeatherDataCollectionService {

    /**
     * 根据城市ID同步天气数据
     *
     * @param cityId
     */
    void syncDataByCityId(String cityId);
}
