package com.middle.controller.webService;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
@Component
@Service
public class PrintService {
    public static void main(String[] args) {
        String address = "http://localhost:9001/service/PrintName?wsdl";
        Endpoint.publish(address, new PrintService());
        System.out.println("--发布成功--");
    }
    //随便定义的方法
    @WebMethod
    public String findUserInfoByName(String arg0){

        System.out.println("---------conn----------");
        System.out.println(arg0+"111111111111111111111111111------------------------------------------------------------------------------");
        return "li";
    }

}
