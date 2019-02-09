package com.heqingbao.microweather.service;

import com.heqingbao.microweather.vo.WeatherResponse;

/**
 * Weather Data Service
 */
public interface WeatherDataService {

    /**
     * 根据城市 ID 查找天气数据
     *
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名字查找天气数据
     *
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);
}