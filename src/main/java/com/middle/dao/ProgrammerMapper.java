package com.middle.dao;

import com.middle.entity.Programmer;

public interface ProgrammerMapper {
    int insert(Programmer record);

    int insertSelective(Programmer record);
}