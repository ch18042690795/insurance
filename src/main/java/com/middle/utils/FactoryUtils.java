package com.middle.utils;

import com.middle.entity.MedResult;
import com.middle.entity.PayeeInformation;
import com.middle.entity.StaffInformation;

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
}
