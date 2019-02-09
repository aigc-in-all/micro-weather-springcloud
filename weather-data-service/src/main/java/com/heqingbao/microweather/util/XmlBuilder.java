package com.heqingbao.microweather.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

public class XmlBuilder {

    /**
     * 将 XML 转为指定的 POJO
     *
     * @param xmlStr
     * @param clazz
     * @return
     * @throws Exception
     */
    public static <T> T xmlStrToObj(String xmlStr, Class<T> clazz) throws Exception {
        T xmlObject = null;
        Reader reader = null;
        JAXBContext context = JAXBContext.newInstance(clazz);

        // XML 转为对象接口
        Unmarshaller unmarshaller = context.createUnmarshaller();

        try {
            reader = new StringReader(xmlStr);
            xmlObject = (T) unmarshaller.unmarshal(reader);
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        return xmlObject;
    }
}