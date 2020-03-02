package com.ct.utils.login_out;

import com.ct.pojo.Authority;
import com.ct.pojo.SuperAdmin;

import javax.servlet.http.HttpSession;

public class Loginfo {

    /**
     * 未登录/登录失败
     */
    public static void LOGINERROR_MSG(HttpSession session,String loginfo){
        Object log=session.getAttribute("LOGINERROR_MSG");
        if (log!=null&&!log.equals("")) {
            session.removeAttribute("LOGINERROR_MSG");
        }
        session.setAttribute("LOGINERROR_MSG", loginfo);
    }


    /**
     * 已登陆，记录登录信息
     */
    public static void USER_INFO(HttpSession session, SuperAdmin superAdmin) {
        Object log= session.getAttribute("USER_INFO");
        if (log!=null&&!log.equals("")) {
            session.removeAttribute("USER_INFO");
        }
        session.setAttribute("USER_INFO",superAdmin);
    }


    /**
     * 登录成功
     */


    /**
     * 注册
     */
    public static void REGISTER_INFO(HttpSession session,String registinfo) {
        Object log=session.getAttribute("REGISTER_ERROR");
        if (log!=null&&!log.equals("")) {
            session.removeAttribute("REGISTER_ERROR");
        }
        session.setAttribute("REGISTER_ERROR",registinfo);
    }
}
