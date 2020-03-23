package com.ct.controller.back;

import com.ct.pojo.User;
import com.ct.service.UserService;
import com.ct.utils.Validators.CheckForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/User")
public class UserBackController {

    @Autowired
    private UserService userService;


    /**
     * 用户的注册
     * @param user
     * @param result
     * @param session
     * @return
     */

    @RequestMapping("/register")
    @ResponseBody
    public String register(@Valid User user, BindingResult result, HttpSession session){
        System.out.println("注册时："+user+"address:"+user.getAddId()+"si:"+user.getSiId());
        if (CheckForm.checkErrors(result,session)){
            boolean Register=userService.UserRegister(user);
            if (Register){
                return "注册成功";
            }else return "注册失败";
        }else {
            return "注册失败";
        }
    }

    /**
     * 用户登录
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public String login(String username,String password,String identify,HttpSession session){
        if (password!=null&&!"".equals(password)){
            if (username!=null&&!username.equals("")){
                boolean checkLogin=userService.UserLogin(username,password,null);
                if (checkLogin){
                    return "登录成功";
                }else return "用户名或密码不正确";

            }else if(identify!=null&&!identify.equals("")){
                boolean checkLogin=userService.UserLogin(username,password,identify);
                if (checkLogin){
                    return "登录成功";
                }else return "用户名或密码不正确";
            }else {
                return "用户名为空";
            }
        }else {
            return "密码为空";
        }
    }
}
