package com.ct.mapper;

import com.ct.pojo.Staff_Info;

public interface Staff_InfoMapper {
    int insert(Staff_Info record);

    int insertSelective(Staff_Info record);
}