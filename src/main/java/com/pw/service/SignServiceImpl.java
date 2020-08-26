package com.pw.service;

import com.pw.dao.SignMapper;
import com.pw.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

/**
 * @author 三季人
 * @create 2020-08-21 9:42
 */
@Service
public class SignServiceImpl implements SignService {
    @Autowired

    private SignMapper signMapper;

    public void setSignMapper(SignMapper signMapper) {

        this.signMapper = signMapper;
    }


    public Date sige( String userName) {
        return signMapper.sige( userName);
    }

    public Account addIntegral( String userName) {
        return signMapper.addIntegral(userName);
    }

    public Account AllIntegral(String userName) {
        return signMapper.AllIntegral(userName);
    }

    public Account convertVip(String userName) {
        return signMapper.convertVip(userName);
    }
}
