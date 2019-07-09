package com.middle.dao;

import com.middle.entity.IsGrxx;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IsGrxxMapper {
    int insert(IsGrxx record);
    int update(IsGrxx record);
    IsGrxx getId(String id);
    int insertSelective(IsGrxx record);

}