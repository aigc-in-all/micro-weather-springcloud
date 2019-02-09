package com.heqingbao.microweather.job;

import com.heqingbao.microweather.service.CityDataService;
import com.heqingbao.microweather.service.WeatherDataService;
import com.heqingbao.microweather.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

public class WeatherDataSyncJob extends QuartzJobBean {

    private static final Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("Weather data sync job. Start!");
        // 获取城市ID 列表
        List<City> cityList = cityDataService.listCity();

        for (City city : cityList) {
            String cityId = city.getId();
            logger.info("Weather data sync job, cityId = " + cityId);
            weatherDataService.syncDataByCityId(cityId);
        }

        logger.info("Weather data sync job. End!");
    }
}