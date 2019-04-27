package com.middle.controller;

import com.google.common.collect.Lists;
import com.middle.entity.Programmer;
import com.middle.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: insurance
 * @description:
 * @author: Mr.Wang
 * @create: 2019-04-27 14:06
 **/
@RestController
public class UploadDataController {
    @Value("${file.location}")
    private String location;
    @RequestMapping("/excel")
    public String downExcel(){
        String result =null;
        List<Programmer> lists=new ArrayList<>();
        Programmer p1=new Programmer();
        Programmer p2=new Programmer();
        p1.setAge((byte) 11);
        p1.setBirthday(new Date());
        p1.setName("aaa");
        p2.setAge((byte) 10);
        p2.setBirthday(new Date());
        p2.setName("bbb");
        lists.add(p1);
        lists.add(p2);
        result= ExcelUtils.getDownLoad(lists,p1,location);
        return result;
    }
}
