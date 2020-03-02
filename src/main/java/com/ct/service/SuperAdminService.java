package com.ct.service;

import com.ct.pojo.SuperAdmin;

import javax.servlet.http.HttpSession;

/**
 *
 * 超级管理员
 */
public interface SuperAdminService {

    //查询记录数
    int querySuperAdminCount();

    //添加superAdmin
    boolean addSuperAdmin(SuperAdmin superAdmin);

    //超级管理员登陆
    SuperAdmin login(SuperAdmin superAdmin, HttpSession session);


    //通过id查询
    SuperAdmin queryAdminById(String id);
}
