package com.ct.mapper;

import com.ct.pojo.MedicineStock;

public interface MedicineStockMapper {
    int insert(MedicineStock record);

    int insertSelective(MedicineStock record);
}