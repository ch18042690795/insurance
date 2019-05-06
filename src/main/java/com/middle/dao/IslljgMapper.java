package com.middle.dao;

import com.middle.entity.Islljg;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IslljgMapper {
    int insert(Islljg record);

    int insertSelective(Islljg record);
}