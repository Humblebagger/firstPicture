package com.pw.dao;

import com.pw.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;

/**
 * @author 三季人
 * @create 2020-08-21 9:29
 */
@Mapper
@Repository
public interface SignMapper {
    Date sige(String userName);
    Account addIntegral(String userName);
    Account  AllIntegral(String userName);
    Account convertVip(String userName);



}
