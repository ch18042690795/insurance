package com.middle.dao;

import com.middle.entity.Islpzt;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IslpztMapper {
    int insert(Islpzt record);

    int insertSelective(Islpzt record);
}