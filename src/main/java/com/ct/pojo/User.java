package com.ct.pojo;

import javax.validation.constraints.*;
import java.io.Serializable;

public class User implements Serializable {
    private Integer uId;

    //姓名
    @NotBlank(message="用户名不能为空")
//    @Pattern(regexp = "^[\\u4e00-\\u9fa5]$",message = "只能包含中文")
    @Size(max = 10)
    private String uUsername;

    //密码
    @NotBlank(message="密码不能为空")
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$" ,message = "密码至少包含 数字和英文，长度6-20")
    @Size(min = 6,max = 20)
    private String uPassword;

    //个性登录号码
    @Pattern(regexp = "/^[a-zA-Z][a-zA-Z0-9_]{4,15}$/ ",message = "字母开头，允许5-16字节，允许字母数字下划线")
    private String uIdentify;

    //Email
    @Email(message="邮箱格式错误")
    private String uEmail;

    //联系电话
//    @NotNull(message="联系电话不能为空")
//    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号码格式有误")
    private String uPhoneNum;

    //性别
    @NotNull(message="性别不能为空")
    @Pattern(regexp = "^[0,1]$",message = "非法操作!")
    private String uSex;

    //身份证
    @NotBlank(message="身份证不能为空")
    @Pattern(regexp = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$",message = "身份证有误")
    private String uIdcard;

    //地址
    private Address addId;

    //入职时间
    @NotBlank(message="入职时间不能为空")
//    @PastOrPresent
    private String uJointime;

    //职位
    private  Staff_Info siId;

    //用户角色
    private Authority aId;

    private static final long serialVersionUID = 1L;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuUsername() {
        return uUsername;
    }

    public void setuUsername(String uUsername) {
        this.uUsername = uUsername;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuIdentify() {
        return uIdentify;
    }

    public void setuIdentify(String uIdentify) {
        this.uIdentify = uIdentify;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuPhoneNum() {
        return uPhoneNum;
    }

    public void setuPhoneNum(String uPhoneNum) {
        this.uPhoneNum = uPhoneNum;
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }

    public String getuIdcard() {
        return uIdcard;
    }

    public void setuIdcard(String uIdcard) {
        this.uIdcard = uIdcard;
    }

    public Address getAddId() {
        return addId;
    }

    public void setAddId(Address addId) {
        this.addId = addId;
    }

    public String getuJointime() {
        return uJointime;
    }

    public void setuJointime(String uJointime) {
        this.uJointime = uJointime;
    }

    public Staff_Info getSiId() {
        return siId;
    }

    public void setSiId(Staff_Info siId) {
        this.siId = siId;
    }

    public Authority getaId() {
        return aId;
    }

    public void setaId(Authority aId) {
        this.aId = aId;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uUsername='" + uUsername + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uIdentify='" + uIdentify + '\'' +
                ", uEmail='" + uEmail + '\'' +
                ", uPhoneNum=" + uPhoneNum +
                ", uSex性别=" + uSex +
                ", uIdcard='" + uIdcard + '\'' +
                ", addId=" + addId +
                ", uJointime='" + uJointime + '\'' +
                ", siId=" + siId +
                ", aId=" + aId +
                '}';
    }

    public String ToJson() {
        return  "\""+"uId"+"\":"+"\""+ uId +"\","+
                "\""+"uUsername"+"\":"+"\""+uUsername +"\","+
                "\""+"uIdentify"+"\":"+"\""+uIdentify +"\","+
                "\""+"uEmail"+"\":"+"\""+uEmail +"\","+
                "\""+"uPhoneNum"+"\":"+"\""+uPhoneNum +"\","+
                "\""+"uSex"+"\":"+"\""+uSex +"\","+
                "\""+"uIdcard"+"\":"+"\""+uIdcard +"\","+
                "\""+"addProvince"+"\":"+"\""+addId.getAddProvince() +"\","+
                "\""+"addCity"+"\":"+"\""+addId.getAddCity() +"\","+
                "\""+"addInfo"+"\":"+"\""+addId.getAddInfo() +"\","+
                "\""+"uJointime"+"\":"+"\""+uJointime +"\","+
                "\""+"siPosition"+"\":"+"\""+siId.getSiPosition() +"\","+
                "\""+"aRole"+"\":"+"\""+aId.getaRole() +"\"";
    }
}