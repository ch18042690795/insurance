package com.middle.dao;

import com.middle.entity.IsDbsp;
import com.middle.entity.IsSdml;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IsDbspMapper {
    int insert(IsDbsp record);
    IsDbsp getId(String id);
    int insertSelective(IsDbsp record);
    List<IsDbsp>  getDBSP();
    int updateisFileup(String id);
}