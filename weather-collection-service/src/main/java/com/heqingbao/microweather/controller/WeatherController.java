package com.heqingbao.microweather.controller;

import com.heqingbao.microweather.service.WeatherDataService;
import com.heqingbao.microweather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;

    @RequestMapping("/cityId/{cityID}")
    public WeatherResponse getWeatherByCityId(@PathVariable("cityID") String cityID) {
        return weatherDataService.getDataByCityId(cityID);
    }

    @RequestMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName) {
        return weatherDataService.getDataByCityName(cityName);
    }
}