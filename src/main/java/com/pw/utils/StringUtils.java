package com.pw.utils;

/**
 * @author 武祥市
 */
public class StringUtils {
    public static boolean isNum(String s){
        char[] chars = s.toCharArray();
        boolean flag = true;
        for (char aChar : chars) {
            if (!Character.isDigit(aChar)) {
                flag = false;
            }
        }
        return flag;
    }
}
