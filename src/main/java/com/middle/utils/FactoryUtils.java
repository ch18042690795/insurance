package com.middle.utils;

import com.middle.controller.Kafka.KafkaSimpleConsumer;
import com.middle.entity.*;
import com.middle.service.impl.InsertDataServiceImpl;
import com.middle.service.impl.UploadDataServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @program: insurance
 * @description:
 * @author: Mr.Wang
 * @create: 2019-05-06 16:52
 **/
public class FactoryUtils {
    private static MedResult medResult = null;
        //同步代码快的demo加锁，安全高效
        public static MedResult getMedResult(){
            if( medResult==null)
                synchronized ( MedResult.class) {
                    if( medResult==null)
                        medResult = new  MedResult();
                }
            return  medResult;
        }
    private static PayeeInformation payeeInformation = null;
    //同步代码快的demo加锁，安全高效
    public static PayeeInformation getPayeeInformation(){
        if( payeeInformation==null)
            synchronized (PayeeInformation.class) {
                if( payeeInformation==null)
                    payeeInformation = new  PayeeInformation();
            }
        return  payeeInformation;
    }

    private static StaffInformation staffInformation = null;
    //同步代码快的demo加锁，安全高效
    public static StaffInformation getStaffInformation(){
        if( staffInformation==null)
            synchronized (StaffInformation.class) {
                if(staffInformation==null)
                    staffInformation = new  StaffInformation();
            }
        return staffInformation;
    }
    private static List list = null;
    //同步代码快的demo加锁，安全高效
    public static List getList(){
        if(  list==null)
            synchronized ( List.class) {
                if(list==null)
                    list = new ArrayList();
            }
        return list;
    }
    private static Set classList = null;
    //同步代码快的demo加锁，安全高效
    public static Set getClassList(){
        if(classList==null)
            synchronized (HashSet.class) {
                if(classList==null)
                    classList = new HashSet();
            }
        return classList;
    }


    private static KafkaSimpleConsumer kafkaSimpleConsumer = null;
    //同步代码快的demo加锁，安全高效
    public static KafkaSimpleConsumer getKafkaSimpleConsumer(){
        if(kafkaSimpleConsumer==null)
            synchronized (IsSdml.class) {
                if(kafkaSimpleConsumer==null) {
                    kafkaSimpleConsumer = new KafkaSimpleConsumer();
                }
            }
        return kafkaSimpleConsumer;
    }
    private static InsertDataServiceImpl insertDataServiceImpl = null;
    //同步代码快的demo加锁，安全高效
    public static InsertDataServiceImpl getInsertDataServiceImpl(){
        if(insertDataServiceImpl==null)
            synchronized (InsertDataServiceImpl.class) {
                if(insertDataServiceImpl==null) {
                    insertDataServiceImpl = new InsertDataServiceImpl();
                }
            }
        return insertDataServiceImpl;
    }
    private static UploadDataServiceImpl uploadDataServiceImpl = null;
    //同步代码快的demo加锁，安全高效
    public static UploadDataServiceImpl getUploadDataServiceImpl(){
        if(uploadDataServiceImpl==null)
            synchronized (UploadDataServiceImpl.class) {
                if(uploadDataServiceImpl==null) {
                    uploadDataServiceImpl = new UploadDataServiceImpl();
                }
            }
        return uploadDataServiceImpl;
    }


   ;
    private static  IsFy isFy = null;
    //同步代码快的demo加锁，安全高效
    public static  IsFy getIsFy(){
        if(isFy==null)
            synchronized (IsFy.class) {
                if(isFy==null) {
                    isFy = new IsFy();
                }
            }
        return isFy;
    }
    private static IsCbrxx isCbrxx =null;
    public static   IsCbrxx getIsCbrxx(){
        if(isCbrxx==null)
            synchronized (IsFy.class) {
                if(isCbrxx==null) {
                    isCbrxx = new IsCbrxx();
                }
            }
        return isCbrxx;
    }
    //获取个人信息
    private static IsGrxx isGrxx=null;
    public static IsGrxx getIsGrxx(){
        if(isGrxx==null)
            synchronized (IsGrxx.class) {
                if(isGrxx==null) {
                    isGrxx = new IsGrxx();
                }
            }
        return isGrxx;
    }
    //获取证件
    private static IsZj isZj=null;
    public static   IsZj getIsZj(){
        if(isZj==null)
            synchronized (IsZj.class) {
                if(isZj==null) {
                    isZj = new IsZj();
                }
            }
        return isZj;
    }
    //获取住院信息
    private static  IsZyxx isZyxx=null;
    public static   IsZyxx getIsZyxx(){
        if(isZyxx==null)
            synchronized (IsZyxx.class) {
                if(isZyxx==null) {
                    isZyxx = new IsZyxx();
                }
            }
        return isZyxx;
    }
    //获取诊断
    private static   IsZd isZd=null;
    public static    IsZd getIsZd(){
        if(isZd==null)
            synchronized (IsZd.class) {
                if(isZd==null) {
                    isZd = new IsZd();
                }
            }
        return isZd;
    }
    //获取出院信息
    private static   IsCyxx iscyxx=null;
    public static    IsCyxx getIscyxx(){
        if(iscyxx==null)
            synchronized (IsCyxx.class) {
                if(iscyxx==null) {
                    iscyxx = new IsCyxx();
                }
            }
        return iscyxx;
    }

    //获取住院补偿信
    private static   IsZybc isZybc=null;
    public static    IsZybc getIsZybc(){
        if(isZybc==null)
            synchronized (IsZybc.class) {
                if(isZybc==null) {
                    isZybc = new IsZybc();
                }
            }
        return isZybc;
    }
}
