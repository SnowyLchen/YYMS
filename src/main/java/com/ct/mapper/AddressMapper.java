package com.ct.mapper;

import com.ct.pojo.Address;

public interface AddressMapper {
    int insert(Address record);

    int insertSelective(Address record);
}