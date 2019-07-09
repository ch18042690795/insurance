package com.middle.controller.webService;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.springframework.stereotype.Component;

/**
 * @program: insurance
 * @description:
 * @author: Mr.Wang
 * @create: 2019-04-29 14:15
 **/
@Component
public class printClient {

/*    public static void main(String[] args) throws Exception {
        String XMLStr ="chen";// XML报文串
        String result = (new printClient()).print(XMLStr);
        System.out.println(result);
    }*/

    public static String print(String names,String endpoint) {

            /** step1: 创建一个Service实例，注意是必须的！*/
            Service service = new Service();

            /**step2:创建Call实例，也是必须的！*/
        Call call = null;
        try {
            call = (Call) service.createCall();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        /**step3: 为Call设置服务的位置 操作方法名 */
        try {
            call.setTargetEndpointAddress(new java.net.URL(endpoint));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
//			方法一
//			http://192.168.129.102:8780/eapdomain/services/PiccWSInterface?wsdl
            call.setOperationName("transBusinessForPICC");//操作的方法 注意 方法名与PiccWebServiceInterfaceImpl中一样
//			方法二
//			http://192.168.129.102:8780/eapdomain/xfire/services/SiWebService?wsdl
//			call.setOperationName("siWebServiceExecute");//操作的方法 注意 方法名与SiWebServiceImpl中一样


            /**step4映射要传递自定义类型 设置返回类型等(可选) 如果返回的是自定义类型也要映射*/
            call.setReturnType(XMLType.XSD_STRING);

            /**step5: 为方法增加参数,传几个参数写几个*/
            call.addParameter( new QName("http://www.openuri.org/","XMLString"),XMLType.XSD_STRING,ParameterMode.IN );

            /**step6: 用参数数组调用Web Service*/

        String result = null;
        try {
            result = (String) call.invoke(new Object[]{names});
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        if(result==null){
                result = "";
            }
            return result;


    }
}