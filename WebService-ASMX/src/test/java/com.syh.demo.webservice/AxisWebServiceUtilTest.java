package com.syh.demo.webservice;

import com.syh.demo.webservice.asmx.AxisWebServiceUtil;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.util.*;

/**
 * AxisWebServiceUtil
 *
 * @author HSY
 * @since 2020/06/01 13:04
 */
public class AxisWebServiceUtilTest {
    public static void main(String[] args) throws ServiceException, RemoteException {
        Map<String, String> inParams = new HashMap<>();
        inParams.put("theCityName", "广州");
        List<String> methods = new ArrayList<>();
        methods.add("getWeatherbyCityName");

        for(String method : methods) {
            Object yhlGetAdviceInfo = AxisWebServiceUtil.sync("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx",
                    "http://WebXml.com.cn/",
                    method,
                    inParams,
                    new Vector());
            System.out.println("调用" + method + "接口返回数据：" + yhlGetAdviceInfo);
        }
    }
}
