package com.ct.service;

import com.ct.pojo.SuperAdmin;
import com.ct.pojo.User;

import javax.servlet.http.HttpSession;

/**
 * 其他用户
 */
public interface UserService {

    /**
     * 用户的注册
     */
    boolean UserRegister(User user);

    /**
     * 用户登录
     * @param Username
     * @param Password
     */
    boolean UserLogin(String Username, String Password,String identify);
}
