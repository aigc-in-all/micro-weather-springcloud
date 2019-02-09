package com.heqingbao.microweather.service;

import com.heqingbao.microweather.util.XmlBuilder;
import com.heqingbao.microweather.vo.City;
import com.heqingbao.microweather.vo.CityList;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CityDataServiceImpl implements CityDataService {

    @Override
    public List<City> listCity() {
        // 读取 XML 文件
        String xmlContent = readXmlContent();
        if (xmlContent == null || xmlContent.isEmpty()) {
            return null;
        }

        try {
            // XML 转为 Java 对象
            CityList cityList = XmlBuilder.xmlStrToObj(xmlContent, CityList.class);
            return cityList.getCityList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private String readXmlContent() {
        Resource resource = new ClassPathResource("citylist.xml");
        BufferedReader reader = null;
        String xmlContent = null;
        try {
            reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            xmlContent = stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(reader);
        }
        return xmlContent;
    }
}