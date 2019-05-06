package com.middle.service;

import com.middle.entity.IsSdml;
import com.middle.entity.Islljg;
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
}
