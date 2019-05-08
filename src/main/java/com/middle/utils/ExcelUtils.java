package com.middle.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.middle.entity.MedResult;
import com.middle.entity.PayeeInformation;
import com.middle.entity.StaffInformation;
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
public class ExcelUtils {
    //文件位置

    //生成单例对象
    private static ExcelUtils excelUtils = new ExcelUtils();

    //调用下载方法
    public static synchronized String getDownLoad(List lists ,String location) {
        return excelUtils.downLoad(lists, location);

    }

    //下载excel
    public String downLoad(List lists,String location) {
        Workbook workbook = exportSheets(lists);
        // 判断数据
        if (workbook == null) {
            return "fail";
        }
        // 设置excel的文件名称
        String excelName = "测试excel";
        // 写出数据输出流到页面
        try {
            File saveFile = new File(location);
            if (!saveFile.exists()) {
                saveFile.mkdirs();
            }
            String filename = new SimpleDateFormat("yyyyMMddHHmmss'.xls'").format(new Date());
            location += "/" + filename;
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
    public static Workbook exportSheets(List lists) {
        List<Map<String, Object>> sheetsList = new ArrayList<>();
        List<StaffInformation> newLists = new ArrayList<>();
        List<PayeeInformation> newListp = new ArrayList<>();
        List<MedResult> newListm = new ArrayList<>();
        // 创建参数对象（用来设定excel得sheet得内容等信息）
        ExportParams params1 = new ExportParams();
        // 设置sheet得名称
        params1.setSheetName("参合人员基本信息");
        ;
        // 创建sheet1使用得map
        Map<String, Object> dataMap = new HashMap<>();
        // title的参数为ExportParams类型，目前仅仅在ExportParams中设置了sheetName
        dataMap.put("title", params1);
        // 模版导出对应得实体类型
        dataMap.put("entity", StaffInformation.class);
        newLists.add((StaffInformation) lists.get(0));
        // sheet中要填充得数据
        dataMap.put("data", newLists);
     /*   Map<String, Object> dataMap2 = getStringObjectMap(lists, p,1,"领款人信息");*/
        /*Map<String, Object> dataMap3 = getStringObjectMap(lists, m,2,"就诊结算信息");*/
        // 将sheet1和sheet2使用得map进行包装
        ExportParams params2 = new ExportParams();
        sheetsList.add(dataMap);
        // 设置sheet得名称
        params2.setSheetName("领款人信息");
        ;
        // 创建sheet1使用得map
        Map<String, Object> dataMap1 = new HashMap<>();
        // title的参数为ExportParams类型，目前仅仅在ExportParams中设置了sheetName
        dataMap1.put("title", params2);
        // 模版导出对应得实体类型
        dataMap1.put("entity", PayeeInformation.class);
        newListp.add((PayeeInformation) lists.get(1));
        // sheet中要填充得数据
        dataMap1.put("data", newListp);
        sheetsList.add(dataMap1);
       /* sheetsList.add(dataMap2);*/
        ExportParams params3 = new ExportParams();
        // 设置sheet得名称
        params3.setSheetName("就诊结算信息");
        ;
        // 创建sheet1使用得map
        Map<String, Object> dataMap2 = new HashMap<>();
        // title的参数为ExportParams类型，目前仅仅在ExportParams中设置了sheetName
        dataMap2.put("title", params3);
        // 模版导出对应得实体类型
        dataMap2.put("entity", MedResult.class);
        newListm.add((MedResult) lists.get(2));
        // sheet中要填充得数据
        dataMap2.put("data", newListm);
        sheetsList.add(dataMap2);
        /*sheetsList.add(dataMap3);*/
        // 执行方法

        return ExcelExportUtil.exportExcel(sheetsList, ExcelType.HSSF);
    }

}