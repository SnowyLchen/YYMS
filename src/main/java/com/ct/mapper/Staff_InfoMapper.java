package com.ct.mapper;

import com.ct.pojo.Staff_Info;

import java.util.List;

public interface Staff_InfoMapper {
//    int insert(Staff_Info record);
//
//    int insertSelective(Staff_Info record);



    /**
     * 更新职位
     * @param siId
     * @return
     */
//    boolean updatePosition(Staff_Info siId);


    /**
     * 查询所有职位
     */
    List<Staff_Info> queryPosi();
}