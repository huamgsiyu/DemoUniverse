package com.syh.demo.webservice.asmx;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.XMLType;
import java.rmi.RemoteException;
import java.util.Map;

/**
 * SyncWebServiceAsmx
 *  Axis形式调用WebService接口
 *
 * @author HSY
 * @since 2020/05/30 20:45
 */
public class AxisWebServiceUtil<T> {

    /**
     *  Java对接WebService接口，asmx形式
     * @param url           接口地址
     * @param soapAction    命名空间
     * @param method        调用接口
     * @param params        请求参数
     * @param t             返回类型
     * @param <T>           返回类型
     * @return              {@link T}
     * @throws ServiceException     异常
     * @throws RemoteException      异常
     */
    public static <T> T sync (String url,
                        String soapAction,
                        String method,
                        Map<String, String> params,
                        T t) throws ServiceException, RemoteException {
        Service service = new Service();
        Call call = (Call)service.createCall();
        call.setTargetEndpointAddress(url);
        /* 设置要调用哪个方法 */
        call.setOperationName(new QName(soapAction,method));

        Object[] inParams = new Object[params.size()];
        if (params.size() > 0) {
            int i = 0;
            for(Map.Entry<String, String> inParam : params.entrySet()) {
                /* 设置要传递的参数 */
                call.addParameter(new QName(soapAction,inParam.getKey()),
                        XMLType.XSD_STRING,
                        ParameterMode.IN);
                inParams[i] = inParam.getValue();
                i++;
            }
        }
        /* 要返回的数据类型（自定义类型） */
        call.setReturnType(new QName(soapAction, method), t.getClass());
        /* （标准的类型） */
//        call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
        call.setUseSOAPAction(true);
        call.setSOAPActionURI(soapAction + method);
        /* 调用方法并传递参数 */
        return  (T) call.invoke(inParams);
    }
}
