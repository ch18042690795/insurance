package com.middle.dao;

import com.middle.entity.IsCbrxx;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IsCbrxxMapper {
    int insert(IsCbrxx record);
    IsCbrxx getId(String id);
    int insertSelective(IsCbrxx record);
    IsCbrxx getCBRXX(String id);
}