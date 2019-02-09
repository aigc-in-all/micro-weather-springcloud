package com.heqingbao.microweather.controller;

import com.heqingbao.microweather.service.WeatherReportService;
import com.heqingbao.microweather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private WeatherReportService weatherReportService;

    @RequestMapping("/cityId/{cityId}")
    public ModelAndView getWeatherByCityId(@PathVariable("cityId") String cityId, Model model) {
        model.addAttribute("title", "天气预报");
        model.addAttribute("cityId", cityId);
        // TODO: 2019-02-10 改为由城市数据API微服务提供数据
        // model.addAttribute("cityList", cityDataService.listCity());

        List<City> cityList = new ArrayList<>();
        City c = new City();
        c.setId("101280601");
        c.setName("深圳");
        cityList.add(c);
        model.addAttribute("cityList", cityList);

        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }
}