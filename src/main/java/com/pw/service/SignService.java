package com.pw.service;

import com.pw.pojo.Account;

import java.sql.Date;

/**
 * @author 三季人
 * @create 2020-08-21 9:42
 */
public interface SignService {

    Date sige(String userName);
    Account addIntegral(String userName);
    Account  AllIntegral(String userName);
    Account convertVip(String userName);



}