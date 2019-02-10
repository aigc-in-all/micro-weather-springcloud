package com.heqingbao.microweather.service;

import com.heqingbao.microweather.vo.City;
import com.heqingbao.microweather.vo.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataClientFallback implements DataClient {

    // 如果城市数据API微服务不能正常提供服务，会触发断路器，默认返回两个城市数据
    @Override
    public List<City> listCity() {
        List<City> cityList = new ArrayList<>();
        City city1 = new City();
        city1.setId("101280601");
        city1.setName("深圳");

        City city2 = new City();
        city2.setId("101280101");
        city2.setName("广州");

        cityList.add(city1);
        cityList.add(city2);

        return cityList;
    }

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        return null;
    }
}
