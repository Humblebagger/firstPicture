package com.pw.dao;

import com.pw.pojo.AccountFeedback;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Mapper
@Repository
public interface AccountFeedbackMap {
    //用户反馈信息
    int addAccountFeedback(AccountFeedback accountFeedback);
    //删除用户反馈
    int deleteAccountFeedback(@Param("id") int id);
    //查找用户反馈
    List<AccountFeedback> findAccountFeedback(Map<String, Object> map);
    //查找总数量
    Integer findAccountFeedbackCount();
}
