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
 *
 * @author HSY
 * @since 2020/05/30 20:45
 */
public class SyncWebServiceAsmxUtil<T> {

    public Object sync (String url,
                               String soapAction,
                               String method,
                               Map<String, String> params,
                               T t) throws ServiceException, RemoteException {
        Service service=new Service();
        Call call=(Call)service.createCall();
        call.setTargetEndpointAddress(url);
        call.setOperationName(new QName(soapAction,method)); //设置要调用哪个方法

        Object[] inParams = new Object[params.size()];
        if (params.size() > 0) {
            int i = 0;
            for(Map.Entry<String, String> inParam : params.entrySet()) {
                call.addParameter(new QName(soapAction,inParam.getKey()), //设置要传递的参数
                        XMLType.XSD_STRING,
                        ParameterMode.IN);
                inParams[i] = inParam.getValue();
                i++;
            }
        }
        call.setReturnType(new QName(soapAction, method), t.getClass()); //要返回的数据类型（自定义类型）
//        call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//（标准的类型）
        call.setUseSOAPAction(true);
        call.setSOAPActionURI(soapAction + method);
        return  (T) call.invoke(inParams);//调用方法并传递参数
    }
}
