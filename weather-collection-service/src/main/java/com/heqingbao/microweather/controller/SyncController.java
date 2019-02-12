package com.heqingbao.microweather.controller;

import com.heqingbao.microweather.service.WeatherDataCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SyncController {

    @Autowired
    WeatherDataCollectionService collectionService;

    @RequestMapping("/sync")
    public String sync() {
        collectionService.syncDataByManual();
        return "ok";
    }
}
