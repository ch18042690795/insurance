package com.middle.dao;

import com.middle.entity.IsCyxx;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IsCyxxMapper {
    int insert(IsCyxx record);

    int insertSelective(IsCyxx record);
}