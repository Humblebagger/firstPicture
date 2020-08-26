package com.pw.service;

import com.pw.dao.AccountFeedbackMap;
import com.pw.pojo.AccountFeedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class AccountFeedbackServiceImpl implements AccountFeedbackService {
    @Autowired
    AccountFeedbackMap accountFeedbackMap;


    @Override
    public int addAccountFeedback(AccountFeedback accountFeedback) {
        return accountFeedbackMap.addAccountFeedback(accountFeedback);
    }

    @Override
    public int deleteAccountFeedback(int id) {
        return accountFeedbackMap.deleteAccountFeedback(id);
    }

    @Override
    public List<AccountFeedback> findAccountFeedback(Map<String, Object> map) {
        return accountFeedbackMap.findAccountFeedback(map);
    }

    @Override
    public Integer findAccountFeedbackCount() {
        return accountFeedbackMap.findAccountFeedbackCount();
    }
    @Override
    public List<AccountFeedback> findFeedFistPage() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", 0);
        map.put("pageSize", 6);
        List<AccountFeedback> accountFeedback = accountFeedbackMap.findAccountFeedback(map);
        int j = 1;
        for (AccountFeedback feedback : accountFeedback) {
            feedback.setRanking(j++);
        }
        return accountFeedback;
    }

    @Override
    public Integer findFeedMaxPage() {
        Integer accountFeedbackCount = accountFeedbackMap.findAccountFeedbackCount() / 6 + 1;
        if (accountFeedbackMap.findAccountFeedbackCount() % 6 == 0) {
            accountFeedbackCount--;
        }
        System.out.println(accountFeedbackCount);
        return accountFeedbackCount;
    }

    @Override
    public List<AccountFeedback> findFeedPage(int start) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", start);
        map.put("pageSize", 6);
        List<AccountFeedback> accountFeedback = accountFeedbackMap.findAccountFeedback(map);
        for (int i = 0; i < accountFeedback.size(); i++) {
            accountFeedback.get(i).setRanking(start * 6 + 1 + i);
        }
        return accountFeedback;
    }
}
