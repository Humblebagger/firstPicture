package com.pw.service;

import com.pw.dao.AccountCollectionMap;
import com.pw.pojo.AccountCollection;
import com.pw.pojo.AccountDownload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountCollectionServiceImpl implements AccountCollectionService {
    @Autowired
    private AccountCollectionMap accountCollectionMap;


    @Override
    public int addAccountCollection(AccountCollection accountCollection) {
        return accountCollectionMap.addAccountCollection(accountCollection);
    }

    @Override
    public int deleteAccountCollection(AccountDownload accountDownload) {
        return accountCollectionMap.deleteAccountCollection(accountDownload);
    }

    @Override
    public List<AccountCollection> findAccountCollection(String userName) {
        return accountCollectionMap.findAccountCollection(userName);
    }

    @Override
    public Integer findCount(String userName) {
        return accountCollectionMap.findCount(userName);
    }
}
