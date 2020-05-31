package com.ct.mapper;

import com.ct.pojo.outRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface out_repositoryMapper {
//    int insert(outRepository record);

    int insertSelective(outRepository record);


    List<outRepository> queryAll(@Param("offset") Integer offset, @Param("pagesize") int pagesize);
}