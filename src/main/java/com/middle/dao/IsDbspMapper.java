package com.middle.dao;

import com.middle.entity.IsDbsp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IsDbspMapper {
    int insert(IsDbsp record);

    int insertSelective(IsDbsp record);
}