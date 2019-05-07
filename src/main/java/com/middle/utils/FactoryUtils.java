package com.middle.utils;

import com.middle.entity.MedResult;

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


}
