package com.middle.dao;

import com.middle.entity.IsCyxx;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IsCyxxMapper {
    int insert(IsCyxx record);
    IsCyxx getId(String id);
    int insertSelective(IsCyxx record);
}