package com.middle.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: insurance
 * @description:
 * @author: Mr.Wang
 * @create: 2019-04-27 14:06
 **/
public  class ExcelUtils {
    //文件位置

   //生成单例对象
    private static ExcelUtils excelUtils = new ExcelUtils();
    //调用下载方法
   public static synchronized String getDownLoad(List lists,Object o,String location){
       return excelUtils.downLoad(lists,o,location);

   }
   //下载excel
    public String downLoad(List lists,Object o,String location ){
        Workbook workbook = exportSheets(lists,o) ;
        // 判断数据
        if(workbook == null) {
            return "fail";
        }
        // 设置excel的文件名称
        String excelName = "测试excel" ;
        // 写出数据输出流到页面
        try {
            File saveFile=new File(location);
            if(!saveFile.exists()){
                saveFile.mkdirs();
            }
            String filename = new SimpleDateFormat("yyyyMMddHHmmss'.xls'").format(new Date());
            location+="/"+filename;
            FileOutputStream outputStream = new FileOutputStream(location);
            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(outputStream);
            workbook.write(bufferedOutPut);
            bufferedOutPut.flush();
            bufferedOutPut.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
    //生成excel
    public static Workbook exportSheets(List lists,Object o){
        // 创建参数对象（用来设定excel得sheet得内容等信息）
        ExportParams params1 = new ExportParams() ;
        // 设置sheet得名称
        params1.setSheetName("用户信息"); ;

        // 创建sheet1使用得map
        Map<String,Object> dataMap1 = new HashMap<>();
        // title的参数为ExportParams类型，目前仅仅在ExportParams中设置了sheetName
        dataMap1.put("title",params1) ;
        // 模版导出对应得实体类型
        dataMap1.put("entity",o.getClass()) ;
        // sheet中要填充得数据
        dataMap1.put("data",lists) ;
        // 将sheet1和sheet2使用得map进行包装
        List<Map<String, Object>> sheetsList = new ArrayList<>() ;
        sheetsList.add(dataMap1);
        // 执行方法
        return ExcelExportUtil.exportExcel(sheetsList, ExcelType.HSSF) ;
    }

}