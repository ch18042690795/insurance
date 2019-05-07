package com.middle.dao;

import com.middle.entity.IsZysfmx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface IsZysfmxMapper {
    /*int insert(IsZysfmx record);
    int insertSelective(IsZysfmx record);*/
    int insert(List<IsZysfmx> list);
}