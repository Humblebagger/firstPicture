package com.pw.service;

import com.pw.dao.AccountDownloadMap;
import com.pw.pojo.Account;
import com.pw.pojo.AccountDownload;
import com.pw.utils.DownloadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@Service
public class AccountDownloadServiceImpl implements AccountDownloadService {
    @Autowired
    AccountDownloadMap accountDownloadMap;


    @Override
    public int addAccountDownload(String name, HttpServletResponse response, Account account) throws IOException {
        DownloadUtils.download(response,name);
        AccountDownload accountDownload = new AccountDownload();
        accountDownload.setUserName(account.getUserName());
        accountDownload.setPicturePosition(name);
        return accountDownloadMap.addAccountDownload(accountDownload);
    }

    @Override
    public int deleteAccountDownload(AccountDownload accountDownload) {
        return accountDownloadMap.deleteAccountDownload(accountDownload);
    }

    @Override
    public List<AccountDownload> findAccountDownload(String name) {
        return accountDownloadMap.findAccountDownload(name);
    }

//    public List<AccountDownload> findFistPage(String name) {
////        Map<String,Object> map = new HashMap<String, Object>();
////        map.put("userName",name);
////        map.put("start",0);
////        map.put("pageSize",6);
////        List<AccountDownload> accountDownload = accountDownloadMap.findAccountDownload(map);
////        return accountDownload;
////    }
//    public Integer findMaxPage(String name) {
//        Integer count = accountDownloadMap.findCount(name)/ 6 + 1;
//        if(accountDownloadMap.findCount(name)%6==0) count--;
//        return count;
//    }
//
//    public List<AccountDownload> findAccountDownloadPage(String name,Integer start) {
//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("userName",name);
//        map.put("start",start);
//        map.put("pageSize",6);
//        List<AccountDownload> accountDownload = accountDownloadMap.findAccountDownload(map);
//        return accountDownload;
//    }
//    public List<Integer> findPageList(String name) {
//        //查询总条数
//        PicturePage picturePage = new PicturePage();
//        picturePage.setName(name);
//        Integer pictureCount = accountDownloadMap.findCount(name);
//
//        //生成分页的数组page，并存入model
//        List<Integer> page = new ArrayList<Integer>();
//        int count=pictureCount/6+1;
//        if(count == 0 ) page.add(1);
//        for (int i = 0; i < count; i++) {
//            page.add(i+1);
//        }
//        return page;
//    }
}
