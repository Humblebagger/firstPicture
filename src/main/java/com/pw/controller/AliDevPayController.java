package com.pw.controller;

import java.io.IOException;

import com.alipay.api.AlipayApiException;
import com.pw.service.AliPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class AliDevPayController {

    @Autowired
    AliPayService aliPayService;
    @RequestMapping("/toPay")
    public void toPay(HttpServletRequest request, HttpServletResponse response) throws Exception {
        aliPayService.aliPay(response);
    }

    //回调验证.验证成功后可以返回自己想要跳转的页面
    @RequestMapping("/alipay/return_url")
    public String returnUrl(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, AlipayApiException, ServletException {
      return aliPayService.returnUrl(request,session);
    }

    @RequestMapping("/alipay/notify_url")
    public void notify_url(HttpServletRequest request, HttpServletResponse response) throws IOException, AlipayApiException, ServletException {
        System.out.println("-------------------------------------------------------");
    }
}
