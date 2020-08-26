package com.pw.service;

import com.alipay.api.AlipayApiException;
import com.pw.pojo.Orders;
import org.apache.http.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author 武祥市
 */
public interface AliPayService {

    void aliPay(HttpServletResponse response) throws IOException;
    String returnUrl(HttpServletRequest request, HttpSession session) throws AlipayApiException, UnsupportedEncodingException;
    List<Orders> findPage(String pageNum,int pageSize);
    List<Orders> findPage(String pageNum,int pageSize,String name);
}
