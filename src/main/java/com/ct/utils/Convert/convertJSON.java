package com.ct.utils.Convert;

import com.ct.pojo.Medicine;
import com.ct.pojo.MedicineType;
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

    public static String ConvertDrugsType(List<MedicineType> list) {
        //定义一个StringBuilder
        StringBuilder jsonStrAll = new StringBuilder();
        String str=null;
        int v=0;
        jsonStrAll.append(PREFIX+"\""+ "Mtype"+"\""+":[");
        if (list!=null&&list.size()>0) {
            for (int i = 0; i < list.size(); i++) {
//                System.out.println("第一次循环"+jsonStrAll);
                //把你要拼接的字段放进去
                for (int j = i+1; j < list.size(); j++) {
                    if (list.get(i).getMtId().equals(list.get(j).getMtId())) {
                        jsonStrAll.append("{"+list.get(i).getFirToJSON() + ",\"M2Type\":[");
                        jsonStrAll.append("{" + list.get(i).getSecToJSON() + "},"+"{" + list.get(j).getSecToJSON() + "}]},");
                        break;}
//                    }if (!list.get(i).getMtId().equals(list.get(j).getMtId())){
//                        System.out.println("不相等的循环");
//                        jsonStrAll.append("{"+list.get(j).getFirToJSON() + ",\"M2Type\":[");
//                        for (int k=j;k<list.size();k++){
//                            jsonStrAll.append("{" + list.get(k).getSecToJSON() + "},");
//                        }
//                        break;
//                    }
                    break;
                }
//                str=jsonStrAll.substring(0, jsonStrAll.length() - 1) + "]";
//                System.out.println("===="+str);
            }
            //把最后的，（逗号）截取掉
            str = jsonStrAll.substring(0, jsonStrAll.length() - 1) + "]";
            System.out.println("---"+str);
            return str;
        }else {
            str = jsonStrAll+ "{}]";
            return str;
        }
    }
}
