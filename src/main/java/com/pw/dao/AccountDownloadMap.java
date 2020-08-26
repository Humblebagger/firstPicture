package com.pw.dao;

import com.pw.pojo.AccountDownload;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface AccountDownloadMap {
    //用户下载图片
    int addAccountDownload(AccountDownload accountDownload);
    //用户删除图片
    int deleteAccountDownload(AccountDownload accountDownload);
    //查找用户的图片
    List<AccountDownload> findAccountDownload(@Param("userName") String userName);
    //查找数量
    Integer findCount(@Param("userName") String userName);

}
