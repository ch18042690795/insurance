package com.middle.dao;

import com.middle.entity.IsZyxx;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IsZyxxMapper {
    int insert(IsZyxx record);

    IsZyxx getId(String id);

    int insertSelective(IsZyxx record);
}