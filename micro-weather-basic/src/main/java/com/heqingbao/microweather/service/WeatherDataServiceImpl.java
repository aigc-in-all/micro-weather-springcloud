package com.heqingbao.microweather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heqingbao.microweather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private RestTemplate restTemplate;

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
        ObjectMapper mapper = new ObjectMapper();
        try {
            // 先检查缓存
            if (stringRedisTemplate.hasKey(uri)) {
                String strBody = stringRedisTemplate.opsForValue().get(uri);
                response = mapper.readValue(strBody, WeatherResponse.class);
            } else {
                ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
                if (respString.getStatusCode().value() != 200) {
                    return null;
                }
                String strBody = respString.getBody();
                response = mapper.readValue(strBody, WeatherResponse.class);
                stringRedisTemplate.opsForValue().set(uri, strBody);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}