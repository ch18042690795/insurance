package com.middle.service;

import com.middle.entity.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by Administrator on 2019/4/27 0027.
 */
@Service
public interface InsertDataService {
    public String insertData(IsSdml isSdml);

    public String insertData(Islljg islljg);

    public String insertData(IsDbsp isDbsp);

    public String insertData(IsZybc isZybc);

    public String insertData(IsCbrxx isCbrxx);

    public String insertData(IsDbbcywzt isDbbcywzt);

    public String insertData(IsCbxxhq isCbxxhq);

    public String insertData(Islpzt islpzt);

    public String insertData(IsDbbcywztcx isDbbcywztcx);


}
