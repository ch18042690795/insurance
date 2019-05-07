package com.middle.controller.webService;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.springframework.stereotype.Component;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

/**
 * @program: insurance
 * @description:
 * @author: Mr.Wang
 * @create: 2019-04-29 14:15
 **/
@Component
public class printClient {

/*
    public static void main(String[] args) throws Exception {
       */
/* String webServiceURL="http://192.168.1.111:8080/eapdomain/services/PiccWSInterface";//webService服务地址*//*

        String XMLStr ="chen";// XML报文串
        String result = (new printClient()).print(XMLStr);
        System.out.println(result);
    }
*/

    public static String print(String names) {
        String result = null;
        try {
            String endpoint = "http://localhost:9001/service/PrintName?wsdl";
            //直接引用远程的wsdl文件
            //以下都是套路
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            /**
             *注意这里，要设置Namespace
             */
            call.setOperationName(new QName("http://webService.middle.com/", "findUserInfoByName"));//WSDL里面描述的接口名称
            call.addParameter("arg0", XMLType.XSD_STRING,
                    ParameterMode.IN);//接口的参数
            call.setReturnType(XMLType.XSD_STRING);//设置返回类型
            result = (String) call.invoke(new Object[]{names});
            //给方法传递参数，并且调用方法
            System.out.println("result is :" + result);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return result;
    }
}