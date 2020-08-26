package com.pw.dao;

import com.pw.pojo.AccountCollection;
import com.pw.pojo.AccountDownload;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface AccountCollectionMap {
    //用户收藏图片
    int addAccountCollection(AccountCollection accountCollection);
    //用户删除收藏图片
    int deleteAccountCollection(AccountDownload accountDownload);
    //查找用户收藏的图片
    List<AccountCollection> findAccountCollection(@Param("userName") String userName);
    //查找数量
    Integer findCount(@Param("userName") String userName);
}
