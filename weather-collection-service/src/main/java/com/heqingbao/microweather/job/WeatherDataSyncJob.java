package com.heqingbao.microweather.job;

import com.heqingbao.microweather.service.WeatherDataCollectionServiceImpl;
import com.heqingbao.microweather.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataSyncJob extends QuartzJobBean {

    private static final Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private WeatherDataCollectionServiceImpl weatherDataCollectionService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("Weather data sync job. Start!");
        // 获取城市ID 列表
        // TODO: 2019-02-10 从城市数据API微服务获取城市列表信息
        // List<City> cityList = cityDataService.listCity();

        List<City> cityList = new ArrayList<>();
        City c = new City();
        c.setId("101280601");
        c.setName("深圳");
        cityList.add(c);

        for (City city : cityList) {
            String cityId = city.getId();
            logger.info("Weather data sync job, cityId = " + cityId);
            weatherDataCollectionService.syncDataByCityId(cityId);
        }

        logger.info("Weather data sync job. End!");
    }
}