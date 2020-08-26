package com.pw.controller;

import com.pw.pojo.Account;
import com.pw.pojo.utils.AccountAdd;
import com.pw.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Api(value = "登录接口层次", tags = "登录接口")
@Controller
@Slf4j
@RequestMapping(value = "/account", produces = "text/html;charset=utf-8")
public class LoginController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/goLogin")
    @ApiOperation("跳转到登录页面")
    public String goLogin() {
        return "login";
    }

    @GetMapping("/goRegister")
    @ApiOperation("跳转到注册")
    public String goRegister() {
        return "register";
    }

    @GetMapping("/goUpdatePassword")
    @ApiOperation("跳转到修改密码的页面")
    public String updatePassword() {
        return "forget1";
    }
    @PostMapping("/login")
    @ApiOperation(value = "登录",
            httpMethod = "POST", response = Account.class)
    public String login(String userName,String password, Model model, HttpSession session) {
        if (userName.equals("admin") && password.equals("admin")) {
            session.setAttribute("Admin","1");
            model.addAttribute("accountNoVip", accountService.findFistPage());
            model.addAttribute("max", accountService.findMaxPage());
            model.addAttribute("num", 1);
            session.setAttribute("num", 1);
            return "common";
        }
        Account account2 = accountService.login(userName, password);
        if (account2 != null) {
            session.setAttribute("Account", account2);
            model.addAttribute("account", account2);
            return "forward:/main/rotation";
        } else {
            model.addAttribute("isLogin", "账号或密码错误！！！");
            return "login";
        }
    }

    @PostMapping("/verification")
    @ResponseBody
    @ApiOperation("验证用户名是否已经存在")
    public String verification(String userName) {
        return accountService.verificationName(userName);
    }

    @PostMapping("/register")
    @ApiOperation("注册方法")
    public String register(AccountAdd account, HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("HAccount") == "true") {
            return "register";
        }
        account.setIsVip(0);
        accountService.addAccount(account);
        return "login";
    }
}
