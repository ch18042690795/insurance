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
        /*IsZj isZj=isZybc.getIsZj();*/
        isZybcMapper.insert(isZybc);
        isFyMapper.insert(fy);
        return fy.getPkid00();
    }

    @Override
    public String insertData(IsCbrxx isCbrxx) {
        isCbrxxMapper.insert(isCbrxx);
        return isCbrxx.getPkid00();
    }

    @Override
    public String insertData(IsDbbcywzt isDbbcywzt) {
        isDbbcywztMapper.insert(isDbbcywzt);
        return isDbbcywzt.getDbspid();
    }

    @Override
    public String insertData(IsCbxxhq isCbxxhq) {
        isCbxxhqMapper.insert(isCbxxhq);
        return isCbxxhq.getPkid00();
    }

    @Override
    public String insertData(Islpzt islpzt) {
        islpztMapper.insert(islpzt);
        return islpzt.getDbspid();
    }

    @Override
    public String insertData(IsDbbcywztcx isDbbcywztcx) {
        isDbbcywztcxMapper.insert(isDbbcywztcx);
        return isDbbcywztcx.getDbspid();
    }
}
