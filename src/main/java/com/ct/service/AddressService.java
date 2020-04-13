package com.ct.service;


import com.ct.pojo.Address;

public interface AddressService {
    
    /**
     * 添加地址
     */
    boolean insAddress(Address address);

    /**
     * 修改地址信息
     */
    boolean UpdateAddress(Address address);
}
