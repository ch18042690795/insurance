package com.middle.dao;

import com.middle.entity.IsZd;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IsZdMapper {
    int insert(IsZd record);
    IsZd getId(String id);
    int insertSelective(IsZd record);
}