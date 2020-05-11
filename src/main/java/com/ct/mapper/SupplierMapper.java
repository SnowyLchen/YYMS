package com.ct.mapper;

import com.ct.pojo.Supplier;

public interface SupplierMapper {
    int insert(Supplier record);

    int insertSelective(Supplier record);
}