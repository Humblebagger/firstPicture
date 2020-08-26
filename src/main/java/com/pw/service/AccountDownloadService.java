package com.pw.service;

import com.pw.pojo.Account;
import com.pw.pojo.AccountDownload;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface AccountDownloadService {
    //用户下载图片
    int addAccountDownload(String name, HttpServletResponse response, Account account) throws IOException;
    //用户删除图片
    int deleteAccountDownload(AccountDownload accountDownload);
    //查找用户的图片
    List<AccountDownload> findAccountDownload(String userName);

}
