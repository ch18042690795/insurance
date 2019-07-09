package test.webService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * @program: insurance
 * @description:
 * @author: Mr.Wang
 * @create: 2019-04-29 11:33
 **/
@WebService
public class PrintService {
    public static void main(String[] args) {
  /*      String address = "http://192.168.17.1:9001/service/PrintName?wsdl";
        Endpoint.publish(address, new PrintService());
        System.out.println("--发布成功--");*/
        String bdate= "19850101";
        bdate=bdate.substring(0,4)+"-"+bdate.substring(4,6)+"-"+bdate.substring(6);
        System.out.println(bdate);
    }
    //随便定义的方法
    @WebMethod
    public String findUserInfoByName(String arg0){
        String bdate= "19850101";
        bdate=bdate.substring(0,3)+"-"+bdate.substring(4,6)+"-"+bdate.substring(7);
        return arg0;
    }

}
