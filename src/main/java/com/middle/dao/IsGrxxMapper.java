package com.middle.dao;

import com.middle.entity.IsGrxx;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IsGrxxMapper {
    int insert(IsGrxx record);

    int insertSelective(IsGrxx record);
}