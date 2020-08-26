package com.pw.service;

import com.pw.dao.AccountMap;
import com.pw.pojo.Account;
import com.pw.pojo.utils.AccountAdd;
import com.pw.pojo.utils.AccountUpdate;
import com.pw.pojo.utils.PersonUpdate;
import com.pw.utils.PageUtils;
import com.pw.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountMap accountMap;

    @Override
    public int addAccount(Account account) {
        account.setUploadTimes(0);
        account.setPersonalSignature("我不简单！！！");
        account.setSex("男");
        account.setUploadTimes(0);
        account.setBackground("sybg (16).jpg");
        account.setHeadPortrait("cygg (2).jpg");
        return accountMap.addAccount(account);
    }

    @Override
    public int addAccount(AccountAdd accountAdd) {
        Account account = new Account();
        account.setUploadTimes(0);
        account.setPersonalSignature("我不简单！！！");
        account.setSex("男");
        account.setUploadTimes(0);
        account.setBackground("sybg (16).jpg");
        account.setHeadPortrait("cygg (2).jpg");
        account.setUserName(accountAdd.getUserName());
        account.setIsVip(accountAdd.getIsVip());
        account.setPassword(accountAdd.getPassword());
        account.setProblemPassword(accountAdd.getProblemPassword());
        account.setProblemAnswer(accountAdd.getProblemAnswer());
        accountMap.addAccount(account);
        return 0;
    }

    @Override
    public int deleteAccount(Integer id) {
        return accountMap.deleteAccount(id);
    }

    @Override
    public int updateAccount(Account account) {
        return accountMap.updateAccount(account);
    }

    @Override
    public int updateAccount(AccountUpdate accountUpDate) {
        Account account = new Account();
        account.setId(accountUpDate.getId());
        account.setSex(accountUpDate.getSex());
        account.setPersonalSignature(accountUpDate.getPersonalSignature());
        account.setUploadTimes(accountUpDate.getUploadTimes());
        account.setUserName(accountUpDate.getUserName());
        return accountMap.updateAccount(account);
    }

    @Override
    public int updateAccount(PersonUpdate personUpdate,int id) {
        Account account = new Account();
        account.setId(id);
        account.setUserName(personUpdate.getUserName());
        account.setSex(personUpdate.getSex());
        account.setBirthday(personUpdate.getBirthday());
        account.setPersonalSignature(personUpdate.getPersonalSignature());
        account.setBigPosition(personUpdate.getBigPosition());
        account.setSmallPosition(personUpdate.getSmallPosition());
        return accountMap.updateAccount(account);
    }

    @Override
    public Account login(String userName, String password) {
        return accountMap.login(userName, password);
    }

    @Override
    public List<Account> findAccountNoVip(Map<String, Object> map) {
        return accountMap.findAllAccount(map);
    }

    @Override
    public List<Account> findAccountVip(Map<String, Object> map) {
        return accountMap.findAllAccount(map);
    }

    @Override
    public List<Account> findAllAccount(Map<String, Object> map) {
        return accountMap.findAllAccount(map);
    }



    @Override
    public List<Account> findFistPage() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("isVip",0);
        map.put("userName", "");
        map.put("start", 0);
        map.put("pageSize", 6);
        List<Account> accountVip = accountMap.findAllAccount(map);
        for (int i = 0; i < accountVip.size(); i++) {
            accountVip.get(i).setRanking(i+1);
        }
        return accountVip;
    }
    @Override
    public List<Account> findFistPage(String name) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("isVip",0);
        map.put("userName", name);
        map.put("start", 0);
        map.put("pageSize", 6);
        List<Account> accountVip = accountMap.findAllAccount(map);
        for (int i = 0; i < accountVip.size(); i++) {
            accountVip.get(i).setRanking(i+1);
        }
        return accountVip;
    }
    @Override
    public List<Account> findPage(int start) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("isVip",0);
        map.put("userName", "");
        map.put("start", start);
        map.put("pageSize", 6);
        List<Account> accountVip = accountMap.findAllAccount(map);
        int j = start;
        for (Account account : accountVip) {
            account.setRanking(1+j++);
        }
        return accountVip;
    }

    @Override
    public List<Account> findPage(int start, String name) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("isVip",0);
        map.put("userName", name);
        map.put("start", start);
        map.put("pageSize", 6);
        List<Account> accountVip = accountMap.findAllAccount(map);
        int j = start;
        for (Account account : accountVip) {
            account.setRanking(1+j++);
        }
        return accountVip;
    }

    @Override
    public Integer findMaxPage() {
        Map<String ,Object> map = new HashMap<String, Object>();
        map.put("isVip",0);
        Integer accountNoVipCount = accountMap.findAccountCount(map) / 6 + 1;
        if(accountMap.findAccountCount(map)%6==0) {
            accountNoVipCount--;
        }
        return accountNoVipCount;
    }
    @Override
    public Integer findMaxPage(String name) {
        Map<String ,Object> map = new HashMap<String, Object>();
        map.put("isVip",0);
        map.put("userName",name);
        Integer accountNoVipCount = accountMap.findAccountCount(map) / 6 + 1;
        if(accountMap.findAccountCount(map)%6==0) {
            accountNoVipCount--;
        }
        return accountNoVipCount;
    }
    @Override
    public List<Account> findVipFistPage() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("isVip",1);
        map.put("userName", "");
        map.put("start", 0);
        map.put("pageSize", 6);
        List<Account> accountVip = accountMap.findAllAccount(map);
        for (int i = 0; i < accountVip.size(); i++) {
            accountVip.get(i).setRanking(i+1);
        }
        return accountVip;
    }

    @Override
    public List<Account> findVipFistPage(String name) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("isVip",1);
        map.put("userName", name);
        map.put("start", 0);
        map.put("pageSize", 6);
        List<Account> accountVip = accountMap.findAllAccount(map);
        for (int i = 0; i < accountVip.size(); i++) {
            accountVip.get(i).setRanking(i+1);
        }
        return accountVip;
    }

    @Override
    public List<Account> findVipPage(int start) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("isVip",1);
        map.put("userName", "");
        map.put("start", start);
        map.put("pageSize", 6);
        List<Account> accountVip = accountMap.findAllAccount(map);
        int j = start;
        for (Account account1 : accountVip) {
            account1.setRanking(1+j++);
        }
        return accountVip;
    }

    @Override
    public List<Account> findVipPage(int start, String name) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("isVip",1);
        map.put("userName", name);
        map.put("start", start);
        map.put("pageSize", 6);
        List<Account> accountVip = accountMap.findAllAccount(map);
        int j = start;
        for (Account account1 : accountVip) {
            account1.setRanking(1+j++);
        }
        return accountVip;
    }

    @Override
    public Integer findVipMaxPage() {
        Map<String ,Object> map = new HashMap<String, Object>();
        map.put("isVip",1);
        Integer accountVipCount = accountMap.findAccountCount(map) / 6 + 1;
        if(accountMap.findAccountCount(map)%6==0) {
            accountVipCount--;
        }
        return accountVipCount;
    }

    @Override
    public Integer findVipMaxPage(String name) {
        Map<String ,Object> map = new HashMap<String, Object>();
        map.put("userName",name);
        map.put("isVip",1);
        Integer accountVipCount = accountMap.findAccountCount(map) / 6 + 1;
        if(accountMap.findAccountCount(map)%6==0) {
            accountVipCount--;
        }
        return accountVipCount;
    }


    @Override
    public String queryProblemAnswer(String name) {
        Account account1 = accountMap.login(name, null);
        if (account1 == null) {
            return "用户名不存在！！！";
        }
        return account1.getProblemAnswer();
    }

    @Override
    public String verificationName(String name) {
        if (accountMap.login(name, null)!= null) {
            return "该用户已存在!!!";
        } else {
            return "用户名可用";
        }
    }

    @Override
    public String makePage(String page, int max) {
        if (page != null) {
            if (!StringUtils.isNum(page)) {
                page = "1";
            }
            page= PageUtils.pageUtil(page,max);
        }
        return page;
    }

    @Override
    public Account findAccount(int id) {
        return accountMap.findAccount(id);
    }

    @Override
    public Integer findAccountCount() {
        Map<String ,Object> map = new HashMap<String, Object>();
        map.put("isVip",0);
        return accountMap.findAccountCount(map);
    }

    @Override
    public Integer findAccountCount(String name) {
        Map<String ,Object> map = new HashMap<String, Object>();
        map.put("isVip",0);
        map.put("userName",name);
        return accountMap.findAccountCount(map);
    }

    @Override
    public Integer findVipAccountCount() {
        Map<String ,Object> map = new HashMap<String, Object>();
        map.put("isVip",1);
        return accountMap.findAccountCount(map);
    }

    @Override
    public Integer findVipAccountCount(String name) {
        Map<String ,Object> map = new HashMap<String, Object>();
        map.put("isVip",1);
        map.put("userName",name);
        return accountMap.findAccountCount(map);
    }
}
