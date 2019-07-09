package com.middle.dao;

import com.middle.entity.IsZybc;
import com.middle.entity.IsZysfmx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IsZybcMapper {
    int insert(IsZybc record);
    IsZybc getId(String id);
    int insertSelective(IsZybc record);
    List<IsZybc> getZYBCXX(String id);
}