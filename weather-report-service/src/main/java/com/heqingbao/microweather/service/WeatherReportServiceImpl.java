package com.heqingbao.microweather.service;

import com.heqingbao.microweather.vo.Forecast;
import com.heqingbao.microweather.vo.Weather;
import com.heqingbao.microweather.vo.Yesterday;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Override
    public Weather getDataByCityId(String cityId) {
        // TODO: 2019-02-10 由天气数据API微服务提供数据
//        WeatherResponse resp = weatherDataService.getDataByCityId(cityId);

        Weather data = new Weather();
        data.setCity("深圳");
        data.setGanmao("相对今天出现了较大幅度降温，较易发生感冒，体质较弱的朋友请注意适当防护。");
        data.setWendu("22");

        Yesterday yesterday = new Yesterday();
        yesterday.setDate("8日星期五");
        yesterday.setHigh("高温 28℃");
        yesterday.setLow("低温 20℃");
        yesterday.setFx("无持续风向");
        yesterday.setFl("<3级");
        yesterday.setType("多云");
        data.setYesterday(yesterday);

        List<Forecast> forecast = new ArrayList<>();
        Forecast f1 = new Forecast();
        f1.setDate("9日星期六");
        f1.setHigh("高温 24℃");
        f1.setLow("低温 18℃");
        f1.setFengxiang("无持续风向");
        f1.setFengli("<3级");
        f1.setType("多云");
        forecast.add(f1);
        data.setForecast(forecast);

        return data;
    }
}