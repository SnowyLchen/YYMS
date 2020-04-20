package com.ct.controller.back;

import com.ct.pojo.Address;
import com.ct.pojo.User;
import com.ct.pojo.UserPic;
import com.ct.service.AddressService;
import com.ct.service.UserService;
import com.ct.utils.Load.UpLoad;
import com.ct.utils.Validators.CheckForm;
import net.sf.jsqlparser.schema.MultiPartName;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;

@Controller
@RequestMapping("/User")
public class UserBackController {

    private static String TRUE_STR="{\"result\":true}";
    private static String FALSE_STR="{\"result\":false}";

    private static String PREFIX="{\"data\":{";
    private static String TRUE_SUFFIX="},\"mata\":{\"msg\":\"获取成功\",\"status\":200}}";
    private static String ERR_SUFFIX="},\"mata\":{\"msg\":\"获取失败\",\"status\":500}}";
    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

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
//        System.out.println("注册时："+user+"address:"+user.getAddId()+"si:"+user.getSiId());
        if (CheckForm.checkErrors(result,session)){
            Address address=new Address("","","");
            boolean insAddress=addressService.insAddress(address);
            user.setAddId(address);
            boolean Register=userService.UserRegister(user);
            if (Register&&insAddress){
//                return "注册成功";
                return TRUE_STR;
            }else
//                return "注册失败";
                return FALSE_STR;
        }else {
//            return "注册失败";
            return FALSE_STR;
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
                boolean checkLogin=userService.UserLogin(username,password,null,session);
                if (checkLogin){
//                    return "登录成功";
                    return TRUE_STR;
                }else
//                    return "用户名或密码不正确";
                    return FALSE_STR;

            }else if(identify!=null&&!identify.equals("")){
                boolean checkLogin=userService.UserLogin(null,password,identify,session);
                if (checkLogin){
//                    return "登录成功";
                    return TRUE_STR;
//                }else return "用户名或密码不正确";
                }else    return FALSE_STR;
            }else {
                return FALSE_STR;
            }
        }else {
            return FALSE_STR;
        }
    }


    /**
     * 用户修改信息
     */
    @ResponseBody
    @RequestMapping("/update")
    public String update(User user, Address address, HttpSession session, HttpServletRequest request){
        MultipartFile head_pic=null;
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart){
            MultipartHttpServletRequest multipartRequest = WebUtils.getNativeRequest(request, MultipartHttpServletRequest.class);
            head_pic = multipartRequest.getFile("head_pic");
        }
//        System.out.println("修改时:"+user+address+head_pic);
        boolean checkUpdate=false;
        if (user!=null){
            if (user.getuId()!=null&&!user.getuId().equals("")){
                //修改地址
//                System.out.println(address!=null?"address=true":"address=false");
                if (address.getAddId()!=null){
                    //获取该用户对应的地址表id
                    int addId=userService.seeInfo(String.valueOf(user.getuId())).getAddId().getAddId();
                    address.setAddId(addId);
                    //进行更新
                    boolean checkUp=addressService.UpdateAddress(address);
                    if (checkUp){
                        session.setAttribute("UPDATE_INFO","地址更新成功");
                        user.setAddId(address);
                    }else {
                        session.setAttribute("UPDATE_INFO","地址更新失败");
                    }
                }
                //先判断一下传入的User信息中是否包含identify
                if (user.getuIdentify()!=null&&!user.getuIdentify().equals("")){
                    //判断一下个性登录号码是否已存在
                    String identify=userService.Check_IDENTIFY(user.getuId());
                    //若不存在，则可进行插入
                    if (identify==null||identify.equals("")||!identify.equals(user.getuIdentify())){
//                        checkUpdate=true;
                        System.out.println( "个性登录号码修改成功");
                    }else {
//                        return "个性登录号码已存在";
                        return FALSE_STR;
                    }
                }
                System.out.println("------------"+user.getuIdentify());
                boolean addHeadPic = false;
                if (head_pic!=null) {
                    String path = request.getServletContext().getRealPath("/static/upload/images/UserPic") + File.separator;
                    //将头像上传到/static/upload/images/UserPic
                    String userPic = UpLoad.upLoad(head_pic, session, path);
                    String userPicPath = "";
                    String newUserPicPath = "";
                    //获取图片的相对地址
                    userPicPath = "static/upload/images/UserPic" + File.separator + userPic;
                    //将所有的‘\’替换成‘/’
                    newUserPicPath = userPicPath.replaceAll("\\\\", "/");
                    UserPic up = new UserPic();
                    //获取人员id
                    up.setuId(user.getuId());
                    //存入头像地址
                    up.setUserPic(newUserPicPath);
                    //存入数据库
                    addHeadPic = userService.alterHeadPic(up);
                }else {
                    //头像未作出修改
                    addHeadPic=true;
                }
                checkUpdate=userService.UserUpdate(user);
                if (checkUpdate&&addHeadPic){
//                    return "人员信息修改成功";
                    return TRUE_STR;
                }else {
                    return FALSE_STR;
//                    return "人员信息修改失败";
                }
            } else if (address!=null){
                checkUpdate=addressService.UpdateAddress(address);
                if (checkUpdate){
//                    return "地址修改成功";
                    return TRUE_STR;
                }else return FALSE_STR;
            }else {
                return FALSE_STR;
//                return "您未作出任何修改";
            }
        }
       else
           return FALSE_STR;
//           return "您未作出任何修改";

    }

    /**
     * 查询个人信息
     * @return
     */

    @ResponseBody
    @RequestMapping("/seeInfo")
    public String seeInfo(String uId){
        String jsonStr="";
        StringBuilder jsonStrAll = new StringBuilder(PREFIX);
        if (uId!=null&&!"".equals(uId)){
            User user = userService.seeInfo(uId);
            jsonStrAll.append(user.ToJson());
            jsonStr=jsonStrAll+TRUE_SUFFIX;
            System.out.println(jsonStr);
            return jsonStr;
        }else {
            jsonStr=jsonStrAll+ERR_SUFFIX ;
            System.out.println(jsonStr);
            return jsonStr;
        }
    }


}
