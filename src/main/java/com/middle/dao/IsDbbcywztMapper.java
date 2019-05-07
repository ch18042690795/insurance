package com.middle.dao;

import com.middle.entity.IsDbbcywzt;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IsDbbcywztMapper {
    int insert(IsDbbcywzt record);

    int insertSelective(IsDbbcywzt record);
}