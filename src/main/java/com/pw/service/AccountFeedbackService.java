package com.pw.service;

import com.pw.pojo.AccountFeedback;

import java.util.List;
import java.util.Map;

public interface AccountFeedbackService {
    //用户反馈信息
    int addAccountFeedback(AccountFeedback accountFeedback);
    //删除用户反馈
    int deleteAccountFeedback(int id);
    //查找用户反馈
    List<AccountFeedback> findAccountFeedback(Map<String, Object> map);
    //查找总数量
    Integer findAccountFeedbackCount();
    //查找反馈信息的第一个页面
    List<AccountFeedback> findFeedFistPage();
    //查找页数
    Integer findFeedMaxPage();
    //查找具体的某一页
    List<AccountFeedback> findFeedPage(int start);

}
