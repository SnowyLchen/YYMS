package com.ct.utils.Convert;

import com.ct.pojo.User;

import java.util.List;

public class convertJSON {

    public static String PREFIX="{\"data\":{";
    public static String Convert(int count, List<User> list) {
        System.out.println("========"+list);
        //定义一个StringBuilder
        StringBuilder jsonStrAll = new StringBuilder();
        String str=null;
        jsonStrAll.append(PREFIX+"\""+"totalpage"+"\""+":"+count+","+"\""+
                "users"+"\""+":[");
        if (list!=null&&list.size()>0) {
            for (int i = 0; i < list.size(); i++) {
                //把你要拼接的字段放进去
                jsonStrAll.append("{"+list.get(i).ToJson() + "},");
            }
            //把最后的，（逗号）截取掉
            str = jsonStrAll.substring(0, jsonStrAll.length() - 1) + "]";
//            System.out.println(str);
            return str;
        }else return jsonStrAll+"}]";
    }
}
