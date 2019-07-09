package com.middle.dao;

import com.middle.entity.IsDbbcywzt;
import com.middle.entity.Islljg;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IsDbbcywztMapper {
    int insert(IsDbbcywzt record);
    IsDbbcywzt getId(String id);
    int insertSelective(IsDbbcywzt record);
}