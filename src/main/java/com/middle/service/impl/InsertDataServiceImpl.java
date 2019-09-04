package com.middle.service.impl;

import com.middle.dao.*;
import com.middle.entity.*;
import com.middle.service.InsertDataService;
import com.middle.service.UploadDataService;
import com.middle.utils.ExcelUtils;
import com.middle.utils.FactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
    public static Set classLists=new TreeSet();
    public static Set zybcClassList=new TreeSet();
    @Override
    public String insertData(IsSdml isSdml) {
        /*try {*/
        if (isSdml!=null&&isSdmlMapper.getId(isSdml.getPkid00()) == null) {
            int id = isSdmlMapper.insert(isSdml);
            return "true";
        }
        return null;
    }

    @Override
    public String insertData(Islljg islljg) {
        if (islljg!=null&&islljgMapper.getId(islljg.getFwwdbh()).size()==0) {
            int id =   islljgMapper.insert(islljg);
            return "true";
        }
        return null;
    }

    @Override
    public String insertData(IsDbsp isDbsp) {

        if(isDbsp!=null){
            IsGrxx isGrxx = isDbsp.getIsGrxx();
            IsCyxx isCyxx = isDbsp.getIsCyxx();
            List<IsZysfmx> isZysfmx = isDbsp.getIsZysfmx();
            IsZyxx isZyxx = isDbsp.getIsZyxx();
            IsZj isZj = isGrxx.getIszj();
            IsZd isZd = isZyxx.getIsZd();




       /* try {*/
            //插入大病索赔表
            if (isDbsp!=null&&isDbspMapper.getId(isDbsp.getPkid()) == null) {
                isDbspMapper.insert(isDbsp);
            }
            if (isGrxx!=null&&isGrxxMapper.getId(isGrxx.getPkid()) == null) {
                System.out.println(isGrxx.getPkid()+isGrxx.getCbzt00()+isGrxx.getYwlx00()+isGrxx.getIszj()+isGrxx.getXming0()+isGrxx.getXbie00());
                //插入grxx表
                isGrxxMapper.insert(isGrxx);
            }
            else if(isGrxx!=null&&isGrxxMapper.getId(isGrxx.getPkid()) != null){
                isGrxxMapper.update(isGrxx);
            }
            if (isCyxx!=null&&isCyxxMapper.getId(isCyxx.getPkid00())== null) {
                //插入cyxx表
                isCyxxMapper.insert(isCyxx);
            }
            if (isZyxx!=null&&isZyxxMapper.getId(isZyxx.getPkid00()) == null) {
                //插入zyxx表
                isZyxxMapper.insert(isZyxx);
            }
            if (isZj!=null&&isZjMapper.getId(isZj.getPkid00()) == null) {
                //插入zj表
                isZjMapper.insert(isZj);
            }
            if (isZd!=null&&isZdMapper.getId(isZd.getPkid00())== null) {
                //插入zd表
                isZdMapper.insert(isZd);
            }

            if(isZysfmx!=null&&isZysfmx.size()>0){
                isZysfmxMapper.insert(isZysfmx);
            }


                return "true";

        }

        return null;

    }

    @Override
    public String insertData(IsZybc isZybc) {
        IsFy fy = isZybc.getFy();
        if(isZybc!=null){
            if (isZybc!=null&&isZybcMapper.getId(isZybc.getOpid00()) == null) {
                int id = isZybcMapper.insert(isZybc);

            }
            if (fy!=null&&isFyMapper.getId(fy.getPkid00()) == null) {
                int id =  isFyMapper.insert(fy);

            }
                return "true";

        }


        return null;
    }

    @Override
    public String insertData(IsCbrxx isCbrxx) {
        /*try {*/
        if (isCbrxx!=null&&isCbrxxMapper.getId(isCbrxx.getId0000()) == null) {
            int id = isCbrxxMapper.insert(isCbrxx);
            return "true";
        }
            return null;
    }

    @Override
    public String insertData(IsDbbcywzt isDbbcywzt) {
       /* try {*/
       /* } catch (Exception e) {
        }*/
        if (isDbbcywzt!=null&&isDbbcywztMapper.getId(isDbbcywzt.getDbspid()) == null) {
            int id =   isDbbcywztMapper.insert(isDbbcywzt);
            return "true";
        }
        return null;
    }

    @Override
    public String insertData(IsCbxxhq isCbxxhq) {
      /*  try {*/
        if (isCbxxhq!=null&&isCbxxhqMapper.getId(isCbxxhq.getPkid00()) == null) {
            int id =  isCbxxhqMapper.insert(isCbxxhq);
            return "true";
        }
     /*   } catch (Exception e) {

        }*/
        return null;
    }

    @Override
    public String insertData(Islpzt islpzt) {
      /*  try {*/
        if (islpzt!=null&&islpztMapper.getId(islpzt.getDbspid()) == null) {
            islpztMapper.insert(islpzt);
            return "true";
        }

     /*   } catch (Exception e) {

        }*/
        return null;
    }

    @Override
    public String insertData(IsDbbcywztcx isDbbcywztcx) {
        if (isDbbcywztcx!=null&&isDbbcywztcxMapper.getId(isDbbcywztcx.getDbspid()) == null) {
            int id =   isDbbcywztcxMapper.insert(isDbbcywztcx);
            return "true";
        }

     /*   } catch (Exception e) {

        }*/
        return null;
       /* try {*/

    /*    } catch (Exception e) {

        }*/

    }
}
