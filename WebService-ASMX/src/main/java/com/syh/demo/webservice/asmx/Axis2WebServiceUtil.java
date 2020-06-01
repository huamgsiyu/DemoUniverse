package com.syh.demo.webservice.asmx;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.commons.text.StringEscapeUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Axis2WebServiceUtil
 *  Axis形式调用WebService接口
 *
 * @author HSY
 * @since 2020/06/01 10:55
 */
public class Axis2WebServiceUtil {

    /**
     * axis2访问WebService接口
     * @param url           WebService的URL，不是WSDL的URL
     * @param action        调用方法（wsdl命名空间地址(wsdl文档中的targetNamespace)和方法名称的组合）
     * @param namespace     命名空间地址
     * @param methodName    调用的方法名
     * @param params        key为参数名，value为参数值
     * @throws AxisFault    {@link AxisFault}异常
     */
    public static void axis2(String url,
                             String action,
                             String namespace,
                             String methodName,
                             Map<String, String> params) throws AxisFault {
        ServiceClient serviceClient = new ServiceClient();
        EndpointReference endpointReference = new EndpointReference(url);
        Options options = serviceClient.getOptions();
        options.setTo(endpointReference);
        options.setAction(action);
        OMFactory factory = OMAbstractFactory.getOMFactory();
        /*
         * 指定命名空间，参数：
         * uri--即为wsdl文档的targetNamespace，命名空间
         * prefix--可不填
         */
        OMNamespace omNamespace = factory.createOMNamespace(namespace, "");
        // 指定方法
        OMElement method = factory.createOMElement(methodName, omNamespace);
        // 指定方法的参数
        if (params != null && params.size() > 0) {
            for(String key : params.keySet()) {
                OMElement element = factory.createOMElement(key, omNamespace);
                element.setText(params.get(key));
                method.addChild(element);
            }
        }
        method.build();
        //远程调用web服务
        OMElement result = serviceClient.sendReceive(method);

        // 转义字符转为正常字符
        String msg = StringEscapeUtils.unescapeXml(result.toString());
        msg = msg.replaceAll("\t*\r*\n*", "");
        System.out.println(msg);
    }
}
