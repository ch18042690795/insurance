package com.middle.dao;

import com.middle.entity.IsCbxxhq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IsCbxxhqMapper {
    int insert(IsCbxxhq record);
    IsCbxxhq getId(String id);
    int insertSelective(IsCbxxhq record);
}