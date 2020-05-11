package com.ct.utils.Convert;

import com.ct.pojo.Medicine;
import com.ct.pojo.User;

import java.util.List;

public class convertJSON {

    public static String PREFIX="{\"data\":{";

    /**
     * 用户json
     * @param count
     * @param list
     * @return
     */
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
        }else {
            str = jsonStrAll+ "{}]";
            return str;
        }
    }

    /**
     * 药品json
     * @param count
     * @param list
     * @return
     */
    public static String ConvertDrugs(int count, List<Medicine> list) {
        System.out.println("========"+list);
        //定义一个StringBuilder
        StringBuilder jsonStrAll = new StringBuilder();
        String str=null;
        jsonStrAll.append(PREFIX+"\""+"totalpage"+"\""+":"+count+","+"\""+
                "me"+"\""+":[");
        if (list!=null&&list.size()>0) {
            for (int i = 0; i < list.size(); i++) {
                //把你要拼接的字段放进去
                jsonStrAll.append("{"+list.get(i).ToJson() + "},");
            }
            //把最后的，（逗号）截取掉
            str = jsonStrAll.substring(0, jsonStrAll.length() - 1) + "]";
//            System.out.println(str);
            return str;
        }else {
            str = jsonStrAll+ "{}]";
            return str;
        }
    }
}
