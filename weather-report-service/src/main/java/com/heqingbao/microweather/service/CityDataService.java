package com.heqingbao.microweather.service;

import com.heqingbao.microweather.vo.City;

import java.util.List;

public interface CityDataService {

    /**
     * 获取城市列表
     *
     * @return
     */
    List<City> listCity();
}