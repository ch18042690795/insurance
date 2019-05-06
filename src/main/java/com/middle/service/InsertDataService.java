package com.middle.service;

import com.middle.entity.IsSdml;
import com.middle.entity.Islljg;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by Administrator on 2019/4/27 0027.
 */
@Service
public interface InsertDataService {
    public String insertData(IsSdml isSdml);
    public String insertData(Islljg islljg);
}
