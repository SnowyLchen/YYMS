package com.ct.mapper;

import com.ct.pojo.UserPic;

public interface UserPicMapper {
    /**
     * 插入头像
     * @param userPic
     * @return
     */
    int insert(UserPic userPic);



    /**
     * 头像修改
     * @param userPic
     * @return
     */
    boolean alterHeadPic(UserPic userPic);
}