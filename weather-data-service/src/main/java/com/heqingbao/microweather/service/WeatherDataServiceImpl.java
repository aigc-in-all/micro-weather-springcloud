package com.heqingbao.microweather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heqingbao.microweather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return doGetWeather(uri);
    }

    private WeatherResponse doGetWeather(String uri) {
        WeatherResponse response = null;
        String strBody = null;

        // 先检查缓存
        if (stringRedisTemplate.hasKey(uri)) {
            strBody = stringRedisTemplate.opsForValue().get(uri);
        } else {
            // 没有缓存，抛出异常
            throw new RuntimeException("没有天气数据");
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            response = mapper.readValue(strBody, WeatherResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}