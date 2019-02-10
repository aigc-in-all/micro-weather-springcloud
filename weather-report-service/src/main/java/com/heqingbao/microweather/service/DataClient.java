package com.heqingbao.microweather.service;

import com.heqingbao.microweather.vo.City;
import com.heqingbao.microweather.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("weather-gateway-zuul")
public interface DataClient {

    /**
     * 获取城市列表
     *
     * @return
     */
    @GetMapping("/city/city/list")
    List<City> listCity();

    /**
     * 根据城市ID查询天气信息
     *
     * @param cityId
     * @return
     */
    @GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
