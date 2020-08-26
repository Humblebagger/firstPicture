package com.pw.controller;

import com.pw.pojo.Account;
import com.pw.pojo.utils.VerificationAns;
import com.pw.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Api(value = "忘记密码接口层次", tags = "忘记密码接口")
@Controller
@Slf4j
@RequestMapping(value = "/account", produces = "text/html;charset=utf-8")
public class ForgetPasswordController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/queryProblemPassword")
    @ApiOperation("查询密保")
    @ResponseBody
    public String queryProblemPassword(String userName, HttpSession session) {
        if (accountService.login(userName, null) != null) {
            session.setAttribute("PN", accountService.login(userName, null).getId());
        }
        return accountService.queryProblemAnswer(userName);
    }

    @PostMapping("/forgetPassword")
    @ApiOperation("忘记密码")
    public String forgetPassword(VerificationAns verificationAns, Model model) {
        if (accountService.login(verificationAns.getUserName(), null).getProblemAnswer().equals(verificationAns.getProblemAnswer())) {
            return "forget2";
        } else {
            model.addAttribute("answerPrompt", "答案错误!!!");
            return "forget1";
        }
    }

    @PostMapping("/queryProblem")
    @ApiOperation("查询问题")
    @ResponseBody
    public String queryProblem(String userName, HttpSession session) {
        Account account1 = accountService.login(userName, null);
        if (account1 == null) {
            return "未查询到密保问题！(可能该用户不存在)";
        }
        session.setAttribute("PN", account1.getId());
        return account1.getProblemPassword();
    }

    @PostMapping("/setPassword")
    @ApiOperation("/设置新密码")
    public String setPassword(String newPassword, String confirmPassword, HttpSession session, Model model) {
        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("error", "两次输入的密码不一致！");
            return "forget2";
        }
        Account account = new Account();
        account.setId((Integer) session.getAttribute("PN"));
        account.setPassword(newPassword);
        accountService.updateAccount(account);
        return "forget3";
    }
}
