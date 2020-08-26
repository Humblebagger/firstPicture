package com.pw.service;

import com.pw.pojo.Account;
import com.pw.pojo.utils.AccountAdd;
import com.pw.pojo.utils.AccountUpdate;
import com.pw.pojo.utils.PersonUpdate;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AccountService {
    int addAccount(Account account);
    int addAccount(AccountAdd account);
    int deleteAccount(Integer id);
    int updateAccount(Account account);
    int updateAccount(AccountUpdate account);
    int updateAccount(PersonUpdate account,int id);
    Account login(String userName, String password);
    List<Account> findAccountNoVip(Map<String, Object> map);
    List<Account> findAccountVip(Map<String, Object> map);
    List<Account> findAllAccount(Map<String, Object> map);
    List<Account> findFistPage();
    List<Account> findFistPage(String name);
    List<Account> findPage(int start);
    List<Account> findPage(int start, String name);
    Integer findMaxPage();
    Integer findMaxPage(String name);
    List<Account> findVipFistPage();
    List<Account> findVipFistPage(String name);
    List<Account> findVipPage(int start);
    List<Account> findVipPage(int start, String name);
    Integer findVipMaxPage();
    Integer findVipMaxPage(String name);
    String queryProblemAnswer(String name);
    String verificationName(String name);
    String makePage(String page, int max);
    Account findAccount(@Param("id") int id);
    //查找账号数量
    Integer findAccountCount();
    Integer findAccountCount(String name);
    //查找账号数量
    Integer findVipAccountCount();
    Integer findVipAccountCount(String name);
}
