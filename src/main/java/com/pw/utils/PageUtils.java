package com.pw.utils;

public class PageUtils {
    public static String pageUtil(String page,int max){
        if (Integer.parseInt(page) > max) {
           page = max+"";
        }
        if (Integer.parseInt(page) < 1) {
            page = 1+"";
        }
        return page;
    }
}
