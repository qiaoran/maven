package com.system.hrSystem.util;

public class StringUtil {

    public static String notNull(String s){
        if(s==null||s.length()<1)
            return "";
        return s;
    }
}
