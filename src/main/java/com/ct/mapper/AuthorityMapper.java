package com.ct.mapper;

import com.ct.pojo.Authority;
import org.apache.ibatis.annotations.Param;

public interface AuthorityMapper {
    //通过角色名查询id
    int queryIdByRole(@Param("role") String role);

    String queryRoleById(@Param("a_id") Integer aId);
}