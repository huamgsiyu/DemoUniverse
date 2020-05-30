package com.syh.demo.webservice.asmx;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.util.*;

public class WebServiceASMX {

    public static void main(String[] args) throws ServiceException, RemoteException {
//        Date date = SimpleDateFormatUtil.stringToDate(DateFormatEnum.YYYY_MM_DD_HH_MM_SS_RAIL_COLON.format, "2020-05-30 19:29:59");
//        long time = date.getTime() / 1000 + 8 * 60 * 60;
//        System.out.println("time = " + time);
//        inParams.put("last_sync_mark", String.valueOf(time));

        Map<String, String> inParams = new HashMap<>();
        inParams.put("theCityName", "广州");
        List<String> methods = new ArrayList<>();
        methods.add("getWeatherbyCityName");

        for(String method : methods) {
            SyncWebServiceAsmxUtil<Vector> syncWebServiceAsmx = new SyncWebServiceAsmxUtil<>();
            Object yhlGetAdviceInfo = syncWebServiceAsmx.sync("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx",
                    "http://WebXml.com.cn/",
                    method,
                    inParams,
                    new Vector());
            System.out.println("调用" + method + "接口返回数据：" + yhlGetAdviceInfo);
        }
    }
}