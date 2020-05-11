package com.ct.mapper;

import com.ct.pojo.MedicinePic;

public interface MedicinePicMapper {
    int insert(MedicinePic record);

    int insertSelective(MedicinePic record);
}