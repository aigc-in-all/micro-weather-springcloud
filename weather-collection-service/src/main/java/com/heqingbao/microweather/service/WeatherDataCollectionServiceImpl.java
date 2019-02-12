package com.heqingbao.microweather.service;

import com.heqingbao.microweather.vo.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

    private static final Logger logger = LoggerFactory.getLogger(WeatherDataCollectionServiceImpl.class);

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private CityClient cityClient;

    private volatile boolean syncing;

    @Override
    public void syncData() {
        List<City> cityList = cityClient.listCity();

        for (City city : cityList) {
            String cityId = city.getId();
            logger.info("Weather data sync job, cityId = " + cityId);
            syncDataByCityId(cityId);
        }
    }

    @Override
    public void syncDataByManual() {
        if (syncing) {
            return;
        }
        syncing = true;
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                syncData();
                syncing = false;
            }
        });
    }

    private void syncDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        saveWeatherData(uri);
    }

    private void saveWeatherData(String uri) {
        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
        if (respString.getStatusCode().value() != 200) {
            return;
        }

        String strBody = respString.getBody();

        // 数据写入缓存
        stringRedisTemplate.opsForValue().set(uri, strBody, 3, TimeUnit.HOURS);
    }
}
