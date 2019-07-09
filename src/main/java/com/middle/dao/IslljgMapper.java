package com.middle.dao;

import com.middle.entity.IsSdml;
import com.middle.entity.Islljg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IslljgMapper {
    int insert(Islljg record);

    List<Islljg> getId(String id);

    int insertSelective(Islljg record);
}