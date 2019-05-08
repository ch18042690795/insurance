package com.middle.service;

import com.middle.entity.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2019/4/27 0027.
 */
@Service
public interface UploadDataService {
    public String getData(IsSdml isSdml);

    public String getData(Islljg islljg);

    public String getData(IsCbrxx isCbrxx);

    public String getData(IsDbsp isDbsp);

    public String getData(IsZybc isZybc);

    public String getData(IsDbbcywzt isDbbcywzt);

    public String getData(IsCbxxhq isCbxxhq);

    public String getData(Islpzt islpzt);

    public String getData(IsDbbcywztcx isDbbcywztcx);
}
