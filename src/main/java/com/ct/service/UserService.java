package com.ct.service;

import com.ct.pojo.SuperAdmin;
import com.ct.pojo.User;
import com.ct.pojo.UserPic;

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

    /**
     * 用户修改
     * @param user
     * @return
     */
    boolean UserUpdate(User user);

    /**
     * 查询全部信息
     * @param uId
     * @return
     */
    User seeInfo(String uId);

    /**
     * 获取个性登录号码
     * @param getuId
     * @return
     */
    String  Check_IDENTIFY(Integer getuId);

    /**
     * 头像的修改
     */
    boolean alterHeadPic(UserPic userPic);
}
