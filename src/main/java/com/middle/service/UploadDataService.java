package com.middle.service;

import com.middle.entity.*;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/4/27 0027.
 */
@Service
public interface UploadDataService {
    public void getData(IsSdml isSdml);

    public void getData(Islljg islljg);

    public String getData(IsCbrxx isCbrxx);

    public void getData(IsDbsp isDbsp);

    public void getData(IsZybc isZybc);

}
