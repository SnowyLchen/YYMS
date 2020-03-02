package com.ct.service;

import com.ct.pojo.SuperAdmin;
import org.apache.ibatis.annotations.Param;

/**
 *  角色表
 */
public interface AuthorityService {

    //查询角色对应id
    int queryIdByRole( String role);



    //查询id对应角色
    String queryRoleById(Integer getaId);
}
