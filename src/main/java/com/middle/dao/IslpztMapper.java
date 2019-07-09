package com.middle.dao;

import com.middle.entity.IsCbxxhq;
import com.middle.entity.Islpzt;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IslpztMapper {
    int insert(Islpzt record);
    Islpzt getId(String id);
    int insertSelective(Islpzt record);
}