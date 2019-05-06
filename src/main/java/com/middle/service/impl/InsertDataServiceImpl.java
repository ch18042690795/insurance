package com.middle.service.impl;

import com.middle.dao.IsSdmlMapper;
import com.middle.dao.IslljgMapper;
import com.middle.entity.IsSdml;
import com.middle.entity.Islljg;
import com.middle.service.InsertDataService;
import com.middle.service.UploadDataService;
import com.middle.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @program: insurance
 * @description:
 * @author: Mr.Wang
 * @create: 2019-04-27 14:08
 **/
@Service
public class InsertDataServiceImpl implements InsertDataService {
    @Autowired
    IsSdmlMapper isSdmlMapper;
    @Autowired
    IslljgMapper islljgMapper;
    @Autowired
    UploadDataService uploadDataService;

    @Override
    public String insertData(IsSdml isSdml) {
       /* try {*/
            isSdmlMapper.insert(isSdml);
            uploadDataService.getData(isSdml);
            return isSdml.getPkid00();
     /*   } catch (Exception e) {
            return null;
        }*/
    }

    @Override
    public String insertData(Islljg islljg) {
       /* try {*/
            islljgMapper.insert(islljg);
            uploadDataService.getData(islljg);
            return islljg.getFwwdbh();
      /*  } catch (Exception e) {
            return null;
        }*/
    }
}
