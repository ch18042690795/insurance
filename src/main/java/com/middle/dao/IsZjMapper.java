package com.middle.dao;

import com.middle.entity.IsZj;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IsZjMapper {
    int insert(IsZj record);
    IsZj getId(String id);
    int insertSelective(IsZj record);
}