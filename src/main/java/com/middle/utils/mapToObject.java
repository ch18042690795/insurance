package com.middle.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.middle.entity.IsSdml;
import com.middle.entity.Islljg;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: insurance
 * @description:
 * @author: Mr.Wang
 * @create: 2019-05-06 10:19
 **/
public class mapToObject {

    //三大目录赋值对象
    public static IsSdml setObjectsdml(HashMap<String, Object> maps){
        Map map= mapToObject.getMap(maps);
     /*   List<HashMap<String, Object>> lists=Array2List.handleJSONArray(o);*/
        IsSdml isSdml=new IsSdml();
        //如果传过来的主键为空自动生成
        String  map1= (String) map.get("jx0000");
        String pid=mapToObject.randomString((String) map.get("pkid00"));
        isSdml.setJx0000((String)map.get("jx0000"));
        isSdml.setFpxmbh((String)map.get("fpxmbh"));
        isSdml.setPkid00(pid);
        isSdml.setXmbh00((String)map.get("xmbh00"));
        isSdml.setXmdw00((String)map.get("xmdw00"));
        isSdml.setXmgg00((String)map.get("xmgg00"));
        isSdml.setYplb00((String)map.get("yplb00"));
        isSdml.setYbfyfw(Long.valueOf((String)map.get("ybfyfw")));
        isSdml.setXmmc00((String)map.get("xmmc00"));
        return isSdml;
    }
    //医疗机构赋予对象
    public  static Islljg setObjectyljg(HashMap<String, Object> maps){
       Map map= mapToObject.getMap(maps);
        Islljg islljg=new Islljg();
        //如果传过来的主键为空自动生成
        String pid=mapToObject.randomString((String)map.get("pkid00"));
        islljg.setFwwdbh((String)map.get("fwwdbh"));
        islljg.setFwwdmc((String)map.get("fwwdmc"));
        islljg.setJzrq00((String)map.get("jzrq00"));
        islljg.setLxdhua((String)map.get("lxdhua"));
        islljg.setLxren0((String)map.get("lxren0"));
        islljg.setLxsji0((String)map.get("lxdhua"));
        islljg.setQsrq00((String)map.get("qsrq00"));
        islljg.setSfddyljg((String)map.get("sfddyljg"));
        islljg.setWddz00((String)map.get("wddz00"));
        islljg.setWdjbbh((String)map.get("wdjbbh"));
        islljg.setYljgxz((String)map.get("yljgxz"));
        islljg.setYljgxzgsd((String)map.get("yljgxzgsd"));
        islljg.setYljgxzjb((String)map.get("yljgxzjb"));
        islljg.setYljgylxz((String)map.get("yljgylxz"));
        return islljg;
    }
    public static String randomString(String str){
        if(str==null){
            return RandomStringUtils.randomAlphanumeric(32);
        }
        return str;
    }
    public  static Map getMap(HashMap<String, Object> maps){
        JSONObject ob= (JSONObject) maps.get("body");
       JSONArray jsonArray= (JSONArray) ob.get("datas");
        JSONObject jsonValue= (JSONObject) jsonArray.get(0);
        Map map= (Map) jsonValue.get("value");
        return map;
    }
}
