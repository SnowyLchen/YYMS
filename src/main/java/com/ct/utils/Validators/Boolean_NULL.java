package com.ct.utils.Validators;

public class Boolean_NULL {


    public static boolean CHECK_NULL(String temp){
        if (temp.equals("")||temp==null){
            return false;
        }else return true;
    }
}
