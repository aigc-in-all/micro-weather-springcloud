package com.heqingbao.microweather.service;

import com.heqingbao.microweather.vo.Weather;

public interface WeatherReportService {

    /**
     * 根据城市 ID 查询天气信息
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);
}