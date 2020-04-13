package com.ct.mapper;

import com.ct.pojo.Address;

public interface AddressMapper {
    /**
     * 插入地址
     * @param address
     * @return
     */
    int INSAddress(Address address);


    boolean UpdateAddress(Address address);
}