package com.heqingbao.microweather.service;

import com.heqingbao.microweather.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("weather-city-service")
public interface CityClient {

    @GetMapping("/city/list")
    List<City> listCity();
}