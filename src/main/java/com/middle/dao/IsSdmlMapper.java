package com.middle.dao;

import com.middle.entity.IsSdml;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IsSdmlMapper {
    int insert(IsSdml record);
    IsSdml getId(String id);
    int insertSelective(IsSdml record);
}