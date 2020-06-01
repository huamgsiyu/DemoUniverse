package com.syh.demo.webservice;

import com.syh.demo.webservice.asmx.Axis2WebServiceUtil;
import com.syh.demo.webservice.enums.DateFormatEnum;
import com.syh.demo.webservice.util.SimpleDateFormatUtil;
import org.apache.axis2.AxisFault;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Axis2WebServiceUtilTest
 *
 * @author HSY
 * @since 2020/06/01 13:06
 */
public class Axis2WebServiceUtilTest {
    public static void main(String[] args) throws AxisFault, ParseException {
        Axis2WebServiceUtil.axis2("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx",
                "http://WebXml.com.cn/getRegionProvince",
                "http://WebXml.com.cn/",
                "getSupportCityDataset",
                new HashMap<>());

        Map<String, String> params = new HashMap<>();
        params.put("theCityName", "广州");
        Axis2WebServiceUtil.axis2("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx",
                "http://WebXml.com.cn/getWeatherbyCityName",
                "http://WebXml.com.cn/",
                "getWeatherbyCityName",
                params);
    }
}
