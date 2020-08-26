package com.pw.dao;

import com.pw.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Mapper
@Repository
public interface AccountMap {
    //增加账号
    int addAccount(Account account);
    //删除账号
    int deleteAccount(Integer id);
    //修改账号
    int updateAccount(Account account);
    //登录功能
    Account login(@Param("userName") String userName, @Param("password") String password);
    //查找账号数量
    Integer findAccountCount(Map<String, Object> map);
    //查找账号信息
    List<Account> findAllAccount(Map<String, Object> map);
    //根据id查找
    Account findAccount(@Param("id") int id);

}
