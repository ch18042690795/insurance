package com.middle.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.middle.entity.*;
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
    public static IsSdml setObjectsdml(HashMap<String, Object> maps) {
        Map map = mapToObject.getMap(maps);
            IsSdml isSdml = null;
            if(map.size()>0){
             isSdml = new IsSdml();
            /*   List<HashMap<String, Object>> lists=Array2List.handleJSONArray(o);*/
            //如果传过来的主键为空自动生成
            String pid = mapToObject.randomString((String) map.get("pkid00"));
            isSdml.setPkid00(pid);
            isSdml.setJx0000((String) map.get("jx0000")==null?"":(String) map.get("jx0000"));
            isSdml.setFpxmbh((String) map.get("fpxmbh")==null?"":(String) map.get("fpxmbh"));
            isSdml.setXmbh00((String) map.get("xmbh00")==null?"":(String) map.get("xmbh00"));
            isSdml.setXmdw00((String) map.get("xmdw00")==null?"":(String) map.get("xmdw00"));
            isSdml.setXmgg00((String) map.get("xmgg00")==null?"":(String) map.get("xmgg00"));
            isSdml.setYplb00((String) map.get("yplb00")==null?"":(String) map.get("yplb00"));
            if((String) map.get("ybfyfw")==null){
                isSdml.setYbfyfw(0L);
            }else{
                isSdml.setYbfyfw(Long.valueOf((String) map.get("ybfyfw")));
            }
            isSdml.setXmmc00((String) map.get("xmmc00")==null?"":(String) map.get("xmmc00"));
        }

        return isSdml;
    }

    //医疗机构赋予对象
    public static Islljg setObjectyljg(HashMap<String, Object> maps) {
        Map map = mapToObject.getMap(maps);
        Islljg islljg = null;
        if(map.size()>0){
            islljg = new Islljg();
            //如果传过来的主键为空自动生成
            String pid = mapToObject.randomString((String) map.get("pkid00"));
            islljg.setFwwdbh((String) map.get("fwwdbh")==null?"":(String) map.get("fwwdbh"));
            islljg.setFwwdmc((String) map.get("fwwdmc")==null?"":(String) map.get("fwwdmc"));
            islljg.setJzrq00((String) map.get("jzrq00")==null?"":(String) map.get("jzrq00"));
            islljg.setLxdhua((String) map.get("lxdhua")==null?"":(String) map.get("lxdhua"));
            islljg.setLxren0((String) map.get("lxren0")==null?"":(String) map.get("lxren0"));
            islljg.setLxsji0((String) map.get("lxdhua")==null?"":(String) map.get("lxdhua"));
            islljg.setQsrq00((String) map.get("qsrq00")==null?"":(String) map.get("qsrq00"));
            islljg.setSfddyljg((String) map.get("sfddyljg")==null?"":(String) map.get("sfddyljg"));
            islljg.setWddz00((String) map.get("wddz00")==null?"":(String) map.get("wddz00"));
            islljg.setWdjbbh((String) map.get("wdjbbh")==null?"":(String) map.get("wdjbbh"));
            islljg.setYljgxz((String) map.get("yljgxz")==null?"":(String) map.get("yljgxz"));
            islljg.setYljgxzgsd((String) map.get("yljgxzgsd")==null?"":(String) map.get("yljgxzgsd"));
            islljg.setYljgxzjb((String) map.get("yljgxzjb")==null?"":(String) map.get("yljgxzjb"));
            islljg.setYljgylxz((String) map.get("yljgylxz")==null?"":(String) map.get("yljgylxz"));
        }

        return islljg;
    }

    ///大病索赔赋予对象
    public static IsDbsp setObjectDbsp(HashMap<String, Object> maps) {

        Map map = mapToObject.getMap(maps);
        IsDbsp isDbsp = null;
        IsGrxx isGrxx = null;
        IsZj isZj =null;
        IsZyxx isZyxx = null;
        IsZd isZd = null;
        IsCyxx isCyxx = null;
        if(map.size()>0){
          isDbsp = new IsDbsp();
            //如果传过来的主键为空自动生成
            String pid = mapToObject.randomString((String) map.get("pkid00"));
            isDbsp.setPkid(pid);
            isDbsp.setSbcwpc((String) map.get("sbcwpc")==null?"":(String) map.get("sbcwpc"));
            isDbsp.setJzlx00((String) map.get("jzlx00")==null?"":(String) map.get("jzlx00"));
            isDbsp.setFwwdbh((String) map.get("fwwdbh")==null?"":(String) map.get("fwwdbh"));
            isDbsp.setFzxbh0((String) map.get("fzxbh0")==null?"":(String) map.get("fzxbh0"));
            //解析grxx对象
            isDbsp = setGrxx(map, isDbsp, isGrxx, isZj, pid);
            //解析Zyxx对象
            isDbsp = setZyxx(map, isDbsp, isZyxx, isZd, pid);
            //解析cyxx对象
            isDbsp = setCyxx(map, isDbsp, isCyxx, pid);
            isDbsp = setZysfmx(map, isDbsp);
        }
        return isDbsp;
    }

    //住院补偿赋予对象
    public static IsZybc setObjectZybc(HashMap<String, Object> maps) {

        Map map = mapToObject.getMap(maps);

        IsZybc isZybc = null;
        IsFy isfy = null;
        IsZj isZj = null;
        if(map.size()>0){
            isZybc = new IsZybc();
            //如果传过来的主键为空自动生成
            String pid = mapToObject.randomString((String) map.get("pkid00"));
            isZybc.setOpid00(pid);
            isZybc.setBzf000((String) map.get("bzf000")==null?"":(String) map.get("bzf000"));
            isZybc.setDbspid((String) map.get("dbspid")==null?"":(String) map.get("dbspid"));
            isZybc.setDjlsh0((String) map.get("djlsh0")==null?"":(String) map.get("djlsh0"));
            isZybc.setLyzd00((String) map.get("lyzd00")==null?"":(String) map.get("lyzd00"));
            isZybc.setLyzt00((String) map.get("lyzt00")==null?"":(String) map.get("lyzt00"));
            isZybc.setRylx00((String) map.get("rylx00")==null?"":(String) map.get("rylx00"));
            isZybc.setSwsj00((String) map.get("swsj00")==null?"":(String) map.get("swsj00"));
            isZybc.setXbie00((String) map.get("xbie00")==null?"":(String) map.get("xbie00"));
            isZybc.setXming0((String) map.get("xming0")==null?"":(String) map.get("xming0"));
            isZybc.setYbhao((String) map.get("ybhao0")==null?"":(String) map.get("ybhao0"));
            isZybc.setBzf000((String) map.get("bzf000")==null?"":(String) map.get("bzf000"));
            isZybc.setZylsh0((String) map.get("zylsh0")==null?"":(String) map.get("zylsh0"));
            isZybc.setSsybnd((String) map.get("ssybnd")==null?"":(String) map.get("ssybnd"));
       /*     //赋予zj表对象
            isZybc = setIsZj(map, isZybc, isZj, pid);*/
            //赋予fy表对象
            isZybc = getIsFy(map, isZybc, isfy, pid);
        }

        return isZybc;
    }

    //参保人信息赋予对象
    public static IsCbrxx setObjectCbrxx(HashMap<String, Object> maps) {
        Map map = mapToObject.getMap(maps);
        IsCbrxx isCbrxx = null;
        if(map.size()>0){
            isCbrxx = new IsCbrxx(); /*       String pid = mapToObject.randomString((String) map.get("pkid00"));
        isCbrxx.setPkid00(pid);*/
            isCbrxx.setCbzt00((String) map.get("cbzt00")==null?"":(String) map.get("cbzt00"));
            isCbrxx.setXming0((String) map.get("xming0")==null?"":(String) map.get("xming0"));
            isCbrxx.setCsrq00((String) map.get("csrq00")==null?"":(String) map.get("csrq00"));
            isCbrxx.setDhua00((String) map.get("dhua00")==null?"":(String) map.get("dhua00"));
            isCbrxx.setId0000((String) map.get("id0000")==null?"":(String) map.get("id0000"));
            isCbrxx.setJzrq00((String) map.get("jzrq00")==null?"":(String) map.get("jzrq00"));
            isCbrxx.setQhdm00((String) map.get("qhdm00")==null?"":(String) map.get("qhdm00"));
            isCbrxx.setQsrq00((String) map.get("qsrq00")==null?"":(String) map.get("qsrq00"));
            isCbrxx.setRysx00((String) map.get("rysx00")==null?"":(String) map.get("rysx00"));
            isCbrxx.setTxdzhi((String) map.get("txdzhi")==null?"":(String) map.get("txdzhi"));
            isCbrxx.setXbie00((String) map.get("xbie00")==null?"":(String) map.get("xbie00"));
            isCbrxx.setYwlx00((String) map.get("ywlx00")==null?"":(String) map.get("ywlx00"));
            isCbrxx.setZjhm00((String) map.get("zjhm00")==null?"":(String) map.get("zjhm00"));
            isCbrxx.setZjlx00((String) map.get("zjlx00")==null?"":(String) map.get("zjlx00"));

        }


        return isCbrxx;
    }

    //大病补偿业务状态对象赋予
    public static IsDbbcywzt setObjectDbbcywzt(HashMap<String, Object> maps) {
        Map map = mapToObject.getMap(maps);
        IsDbbcywzt isDbbcywzt = null;
        if(map.size()>0){
            isDbbcywzt = new IsDbbcywzt();
            String pid = mapToObject.randomString((String) map.get("pkid00"));
            isDbbcywzt.setDbspid((String) map.get("dbspid")==null?"":(String) map.get("dbspid"));
            isDbbcywzt.setLpzt00((String) map.get("lpzt00")==null?"":(String) map.get("lpzt00"));
        }

        return isDbbcywzt;
    }

    //参保信息获取对象
    public static IsCbxxhq setObjectCbxxhq(HashMap<String, Object> maps) {
        Map map = mapToObject.getMap(maps);
        IsCbxxhq isCbxxhq = null;
        if(map.size()>0){
            isCbxxhq = new IsCbxxhq();
            isCbxxhq.setPkid00(RandomStringUtils.randomAlphanumeric(32));
            isCbxxhq.setCbnyyue((String) map.get("cbnyue")==null?"":(String) map.get("cbnyue"));
            isCbxxhq.setYwlx00((String) map.get("ywlx00")==null?"":(String) map.get("ywlx00"));
        }


        return isCbxxhq;

    }

    //理赔状态接口主题
    public static Islpzt setObjectIslpzt(HashMap<String, Object> maps) {
        Map map = mapToObject.getMap(maps);
        Islpzt islpzt = null;
        if(map.size()>0){
            islpzt = new Islpzt();
            String pid = mapToObject.randomString((String) map.get("dbspid"));
            islpzt.setDbspid((String) map.get("dbspid")==null?"":(String) map.get("dbspid"));
            islpzt.setDjlsh0((String) map.get("djlsh0")==null?"":(String) map.get("djlsh0"));
            islpzt.setId0000((String) map.get("id0000")==null?"":(String) map.get("id0000"));
            islpzt.setLprq00((String) map.get("lprq00")==null?"":(String) map.get("lprq00"));
            islpzt.setLpsbyy((String) map.get("lpsbyy")==null?"":(String) map.get("lpsbyy"));
            islpzt.setLpzt00((String) map.get("lpzt00")==null?"":(String) map.get("lpzt00"));
            islpzt.setZylsh0((String) map.get("zylsh0")==null?"":(String) map.get("zylsh0"));
        }
        return islpzt;

    }
//大病补偿业务状态查询
   public static IsDbbcywztcx setObjectIsDbbcywztcx(HashMap<String, Object> maps){
       Map map = mapToObject.getMap(maps);
       IsDbbcywztcx isDbbcywztcx=null;
       if(map.size()>0){
           isDbbcywztcx=new IsDbbcywztcx();
           isDbbcywztcx.setDbspid((String) map.get("dbspid")==null?"":(String) map.get("dbspid"));
       }
       return isDbbcywztcx;
   }
    private static IsZybc getIsFy(Map map, IsZybc isZybc, IsFy isfy, String pid) {

        JSONObject fyObject = (JSONObject) map.get("fy");
        if(fyObject!=null){
            isfy=new IsFy();
            isfy.setNddbbcfy((String) fyObject.get("nddbbcfy")==null?"":(String) fyObject.get("nddbbcfy"));
            isfy.setNrbybtc((String) fyObject.get("nrbybtc")==null?"":(String)  fyObject.get("nrbybtc"));
            isfy.setDbbcfy((String) fyObject.get("dbbcfy")==null?"":(String) fyObject.get("dbbcfy"));
            isfy.setSfcetk((String) fyObject.get("sfcetk")==null?"":(String)fyObject.get("sfcetk"));
            isfy.setXyfy00((String) fyObject.get("xyfy00")==null?"":(String)fyObject.get("xyfy00"));
            isfy.setYlzfy0((String) fyObject.get("ylzfy0")==null?"":(String)fyObject.get("ylzfy0"));
            isfy.setBlyb00((String) fyObject.get("blyb00")==null?"":(String)fyObject.get("blyb00"));
            isfy.setBlzf00((String) fyObject.get("blzf00")==null?"":(String) fyObject.get("blzf00"));
            isfy.setJbylqfx((String) fyObject.get("jbylqfx")==null?"":(String) fyObject.get("jbylqfx"));
            isfy.setJlfy00((String) fyObject.get("jlfy00")==null?"":(String) fyObject.get("jlfy00"));
            isfy.setYlfy00((String) fyObject.get("ylfy00")==null?"":(String) fyObject.get("ylfy00"));
            isfy.setYlzf00((String) fyObject.get("ylzf00")==null?"":(String)fyObject.get("ylzf00"));
            isfy.setZyfy00((String) fyObject.get("zyfy00")==null?"":(String)  fyObject.get("zyfy00"));
            isfy.setSjdbbcfy((String) fyObject.get("sjdbbcfy")==null?"":(String) fyObject.get("sjdbbcfy"));
            isfy.setZylsh0Old((String) fyObject.get("zylsh0_old")==null?"":(String)fyObject.get("zylsh0_old"));
            isfy.setCwzfpc((String) fyObject.get("cwzfpc")==null?"":(String) fyObject.get("cwzfpc"));
            isfy.setJsnd00((String) fyObject.get("jsnd00")==null?"":(String) fyObject.get("jsnd00"));
            isfy.setSfxsesm((String) fyObject.get("sfxsesm")==null?"":(String) fyObject.get("sfxsesm"));
            isfy.setPkid00(pid);
            isZybc.setFy(isfy);
            /**
             *     private String cwzfpc;
             private String jsnd00;
             private String sfxsesm;
             */
        }


        return isZybc;
    }

    private static IsZybc setIsZj(Map map, IsZybc isZybc, IsZj isZj, String pid) {
        JSONObject zjObject = (JSONObject) map.get("zj");
        if(zjObject!=null){
            isZj=new IsZj();
            isZj.setZjhm00((String) zjObject.get("zjhm00")==null?"":(String)zjObject.get("zjhm00"));
            isZj.setZjhm00((String) zjObject.get("zjlx00")==null?"":(String)zjObject.get("zjlx00"));
            isZj.setPkid00(pid);
            isZybc.setIsZj(isZj);
        }
        return isZybc;
    }

    private static IsDbsp setZysfmx(Map map, IsDbsp isDbsp) {

        JSONArray zysfmx = (JSONArray) map.get("zysfmx");
        List<IsZysfmx> isZysfmxList = null;
        if(zysfmx.size()>0){
            List<HashMap<String, Object>> lists = Array2List.handleJSONArray(zysfmx);
            isZysfmxList = new ArrayList<>();
            for (HashMap<String, Object> entry : lists) {
                IsZysfmx isZysfmx = new IsZysfmx();
                isZysfmx.setPkid00(RandomStringUtils.randomAlphanumeric(32));
                isZysfmx.setFpxmbh((String) entry.get("fpxmbh")==null?"":(String) entry.get("fpxmbh"));
                isZysfmx.setXmbh00((String) entry.get("xmbh00")==null?"":(String) entry.get("xmbh00"));
                isZysfmx.setXmmc00((String) entry.get("xmmc00")==null?"":(String) entry.get("xmmc00"));
                isZysfmx.setYplb00((String) entry.get("yplb00")==null?"":(String) entry.get("yplb00"));
                isZysfmx.setYysdmlbh((String) entry.get("yysdmlbh")==null?"":(String) entry.get("yysdmlbh"));
                isZysfmx.setYysdmlmc((String) entry.get("yysdmlmc")==null?"":(String) entry.get("yysdmlmc"));
                isZysfmx.setZfbl00((String) entry.get("zfbl00")==null?"":(String) entry.get("zfbl00"));
                isZysfmxList.add(isZysfmx);
            }
            isDbsp.setIsZysfmx(isZysfmxList);
        }
        return isDbsp;
    }

    private static IsDbsp setCyxx(Map map, IsDbsp isDbsp, IsCyxx isCyxx, String pid) {

        JSONObject cyxx = (JSONObject) map.get("cyxx");
        if(cyxx!=null){
            isCyxx=new IsCyxx();
            isCyxx.setPkid00(pid);
            isCyxx.setCyrq00((String) cyxx.get("cyrq00")==null?"":(String)cyxx.get("cyrq00"));
            isCyxx.setCyzd00((String) cyxx.get("cyzd00")==null?"":(String)cyxx.get("cyzd00"));
            isDbsp.setIsCyxx(isCyxx);
        }
        return isDbsp;
    }

    private static IsDbsp setZyxx(Map map, IsDbsp isDbsp, IsZyxx isZyxx, IsZd isZd, String pid) {
        JSONObject zyxx = (JSONObject) map.get("zyxx");
        JSONObject zd = (JSONObject) zyxx.get("zd");
        isZyxx=new IsZyxx();
        if(zd!=null){
            isZd=new IsZd();
            isZd.setPkid00(pid);
            isZd.setCszd00((String) zd.get("cszd00")==null?"":(String) zd.get("cszd00"));
            isZd.setBfz000((String) zd.get("bfz000")==null?"":(String)  zd.get("bfz000"));
            isZd.setZzdjb0((String) zd.get("zzdjb0")==null?"":(String) zd.get("zzdjb0"));
            isZd.setQtzdjb((String) zd.get("qtzdjb")==null?"":(String) zd.get("qtzdjb"));

            isZyxx.setIsZd(isZd);
        }
        if(zyxx!=null){
            isZyxx.setPkid00(pid);
            isZyxx.setZylsh0((String) zyxx.get("zylsh0")==null?"":(String) zyxx.get("zylsh0"));
            isZyxx.setZyrq00((String) zyxx.get("zyrq00")==null?"":(String) zyxx.get("zyrq00"));
            isZyxx.setJbyblx((String) zyxx.get("jbyblx")==null?"":(String)zyxx.get("jbyblx"));
            isZyxx.setJzks00((String) zyxx.get("jzks00")==null?"":(String)zyxx.get("jzks00"));
            isZyxx.setCwhao0((String) zyxx.get("cwhao0")==null?"":(String) zyxx.get("cwhao0"));
            isZyxx.setSfcetk((String) zyxx.get("sfcetk")==null?"":(String) zyxx.get("sfcetk"));
            isZyxx.setSfcetk((String) zyxx.get("sfcetk")==null?"":(String) zyxx.get("sfcetk"));
            isZyxx.setZylsh0Old((String) zyxx.get("zylsh0Old")==null?"":(String) zyxx.get("zylsh0Old"));
            isZyxx.setZylsh0Old((String) zyxx.get("zylsh0Old")==null?"":(String) zyxx.get("zylsh0Old"));
            isDbsp.setIsZyxx(isZyxx);
        }
        return isDbsp;
    }

    private static IsDbsp setGrxx(Map map, IsDbsp isDbsp, IsGrxx isGrxx, IsZj isZj, String pid) {
        JSONObject grxx = (JSONObject) map.get("grxx");
        JSONObject zj = (JSONObject) grxx.get("zj");
        if(grxx!=null){
            isGrxx=new IsGrxx();
            isGrxx.setPkid(pid);
            isGrxx.setYwlx00((String) grxx.get("ywlx00")==null?"":(String)  grxx.get("ywlx00"));
            isGrxx.setXming0((String) grxx.get("xming0")==null?"":(String)grxx.get("xming0"));
            isGrxx.setXbie00((String) grxx.get("xbie00")==null?"":(String) grxx.get("xbie00"));
            isGrxx.setCbzt00((String) grxx.get("cbzt00")==null?"":(String)grxx.get("cbzt00"));
            isGrxx.setId0000((String) grxx.get("id0000")==null?"":(String) grxx.get("id0000"));
            isGrxx.setXsetx0((String) grxx.get("xsetx0")==null?"":(String)grxx.get("xsetx0"));
            isDbsp.setIsGrxx(isGrxx);

        }
        if(zj!=null){
            isZj=new IsZj();
            isZj.setPkid00(pid);
            isZj.setZjhm00((String) zj.get("zjhm00")==null?"":(String)zj.get("zjhm00"));
            isZj.setZjlx00((String) zj.get("zjlx00")==null?"":(String) zj.get("zjlx00"));
            isGrxx.setIszj(isZj);
        }


        return isDbsp;
    }

    public static String randomString(String str) {
        if (str == null || str.equals("")) {
            return RandomStringUtils.randomAlphanumeric(32);
        }
        return str;
    }

    public static Map getMap(HashMap<String, Object> maps) {
        JSONObject ob = (JSONObject) maps.get("body");
        JSONArray jsonArray = (JSONArray) ob.get("datas");
        JSONObject jsonValue = (JSONObject) jsonArray.get(0);
        Map map = (Map) jsonValue.get("value");
        return map;
    }
}
