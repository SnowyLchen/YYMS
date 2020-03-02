package com.ct.mapper;

import com.ct.pojo.Authority;

public interface AuthorityMapper {
    int insert(Authority record);

    int insertSelective(Authority record);
}