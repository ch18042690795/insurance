package com.middle.dao;

import com.middle.entity.IsFy;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IsFyMapper {
    int insert(IsFy record);
    IsFy getId(String id);
    int insertSelective(IsFy record);
}