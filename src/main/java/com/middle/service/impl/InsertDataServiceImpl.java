package com.middle.service.impl;

import com.middle.dao.*;
import com.middle.entity.*;
import com.middle.service.InsertDataService;
import com.middle.service.UploadDataService;
import com.middle.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

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
    IsDbspMapper isDbspMapper;
    @Autowired
    IsGrxxMapper isGrxxMapper;
    @Autowired
    IsZjMapper isZjMapper;
    @Autowired
    IsZyxxMapper isZyxxMapper;
    @Autowired
    IsZdMapper isZdMapper;
    @Autowired
    IsCyxxMapper isCyxxMapper;
    @Autowired
    IsZysfmxMapper isZysfmxMapper;
    @Autowired
    IsFyMapper isFyMapper;
    @Autowired
    IsZybcMapper isZybcMapper;
    @Autowired
    IsCbrxxMapper isCbrxxMapper;
    @Autowired
    IsDbbcywztMapper isDbbcywztMapper;
    @Autowired
    IsCbxxhqMapper isCbxxhqMapper;
    @Autowired
    IslpztMapper islpztMapper;
    @Autowired
    IsDbbcywztcxMapper isDbbcywztcxMapper;
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

    @Override
    public String insertData(IsDbsp isDbsp) {
        IsGrxx isGrxx=isDbsp.getIsGrxx();
        IsCyxx isCyxx=isDbsp.getIsCyxx();
        List<IsZysfmx> isZysfmx=isDbsp.getIsZysfmx();
        IsZyxx isZyxx=isDbsp.getIsZyxx();
        IsZj isZj=isGrxx.getIszj();
        IsZd isZd=isZyxx.getIsZd();
        //插入大病索赔表
        isDbspMapper.insert(isDbsp);
        //插入grxx表
        isGrxxMapper.insert(isGrxx);
        //插入cyxx表
        isCyxxMapper.insert(isCyxx);
        //插入zyxx表
        isZyxxMapper.insert(isZyxx);
        //插入zj表
        isZjMapper.insert(isZj);
        //插入zd表
        isZdMapper.insert(isZd);
        //批量插入zysfmx
        isZysfmxMapper.insert(isZysfmx);
        return isDbsp.getPkid();
    }

    @Override
    public String insertData(IsZybc isZybc) {
        IsFy fy=isZybc.getFy();
        try {
            isZybcMapper.insert(isZybc);
            isFyMapper.insert(fy);
        }catch (Exception e){

        }
        /*IsZj isZj=isZybc.getIsZj();*/

        return fy.getPkid00();
    }

    @Override
    public String insertData(IsCbrxx isCbrxx) {
        try {
            isCbrxxMapper.insert(isCbrxx);
        }catch(Exception e){

        }
        return isCbrxx.getPkid00();
    }

    @Override
    public String insertData(IsDbbcywzt isDbbcywzt) {
        try {
            isDbbcywztMapper.insert(isDbbcywzt);
        }catch(Exception e){

        }
        return isDbbcywzt.getDbspid();
    }

    @Override
    public String insertData(IsCbxxhq isCbxxhq) {
        try {
            isCbxxhqMapper.insert(isCbxxhq);
        }catch (Exception e){

        }
        return isCbxxhq.getPkid00();
    }

    @Override
    public String insertData(Islpzt islpzt) {
        try {
            islpztMapper.insert(islpzt);
        }catch (Exception e){

        }
        return islpzt.getDbspid();
    }

    @Override
    public String insertData(IsDbbcywztcx isDbbcywztcx) {
        try {
            isDbbcywztcxMapper.insert(isDbbcywztcx);
        }catch (Exception e){

        }
        return isDbbcywztcx.getDbspid();
    }
}
