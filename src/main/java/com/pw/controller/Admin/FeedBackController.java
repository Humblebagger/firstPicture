package com.pw.controller.Admin;

import com.pw.pojo.AccountFeedback;
import com.pw.service.AccountFeedbackService;
import com.pw.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Api(value = "查询反馈接口层次", tags = "查询反馈接口")
@Controller
@Slf4j
@RequestMapping(value = "/account", produces = "text/html;charset=utf-8")
public class FeedBackController {

    @Autowired
    private AccountFeedbackService accountFeedbackService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/goAccountFeedback")
    @ApiOperation("跳转到反馈页面")
    public String goAccountFeedback(Model model, HttpSession session) {
        model.addAttribute("accountFeedback", accountFeedbackService.findFeedFistPage());
        model.addAttribute("maxFeed", accountFeedbackService.findFeedMaxPage());
        model.addAttribute("numFeed", 1);
        session.setAttribute("maxFeed", accountFeedbackService.findFeedMaxPage());
        session.setAttribute("numFeed", 1);
        return "feedback";
    }

    @GetMapping("/searchFeed")
    @ApiOperation("查找反馈信息")
    public String searchFeed(String page, Model model, HttpSession httpSession, String upDown) {
        page = accountService.makePage(page, (Integer) httpSession.getAttribute("max"));

        if (page != null) {
            int a = Integer.parseInt(page);
            if (a != 0) {
                httpSession.setAttribute("numFeed", a - 1);
            }
        }
        if (upDown != null) {
            if (upDown.equals("up")) {
                httpSession.setAttribute("numFeed", (Integer) httpSession.getAttribute("numFeed") + 1);
            }
            if (upDown.equals("down")) {
                httpSession.setAttribute("numFeed", (Integer) httpSession.getAttribute("numFeed") - 1);
            }
        }
        model.addAttribute("maxFeed", accountFeedbackService.findFeedMaxPage());
        model.addAttribute("accountFeedback", accountFeedbackService.findFeedPage((Integer) httpSession.getAttribute("numFeed") * 6-6));
        model.addAttribute("numFeed", (Integer) httpSession.getAttribute("numFeed"));
        return "feedback";
    }

    @GetMapping("/deleteAccountFeed")
    @ApiOperation("删除反馈")
    public String deleteAccount(int id, Model model, HttpSession session) {
        if (accountFeedbackService.findAccountFeedbackCount() % 6 == 1) {
            session.setAttribute("numFeed", (Integer) session.getAttribute("numFeed") - 1);
        }
        model.addAttribute("isDelete", accountFeedbackService.deleteAccountFeedback(id) > 0);
        model.addAttribute("maxFeed", accountFeedbackService.findFeedMaxPage());
        model.addAttribute("numFeed", accountFeedbackService.findFeedMaxPage());
        model.addAttribute("accountFeedback", accountFeedbackService.findFeedPage((Integer) session.getAttribute("numFeed") * 6 - 6));
        return "feedback";
    }
}
