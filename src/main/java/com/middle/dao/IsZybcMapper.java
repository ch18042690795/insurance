package com.middle.dao;

import com.middle.entity.IsZybc;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IsZybcMapper {
    int insert(IsZybc record);

    int insertSelective(IsZybc record);
}