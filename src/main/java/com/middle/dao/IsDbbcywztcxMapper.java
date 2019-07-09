package com.middle.dao;

import com.middle.entity.IsDbbcywztcx;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IsDbbcywztcxMapper {
    int insert(IsDbbcywztcx record);
   IsDbbcywztcx getId(String id);
    int insertSelective(IsDbbcywztcx record);
}