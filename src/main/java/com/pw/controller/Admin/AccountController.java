package com.pw.controller.Admin;

import com.pw.pojo.utils.AccountAdd;
import com.pw.pojo.utils.AccountUpdate;
import com.pw.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Api(value = "查询用户接口层次", tags = "查询普通用户接口")
@Controller
@Slf4j
@RequestMapping(value = "/account", produces = "text/html;charset=utf-8")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/updateAccount")
    @ApiOperation("修改用户的方法")
    public String updateAccount(AccountUpdate account, Model model, HttpSession session) {
        String name=(String) session.getAttribute("name");
        model.addAttribute("isUpdate", accountService.updateAccount(account) > 0);
        model.addAttribute("num", session.getAttribute("num"));
        if(name!=null){
            model.addAttribute("max", accountService.findMaxPage(name));
            model.addAttribute("accountNoVip", accountService.findPage((Integer) session.getAttribute("num") * 6 - 6,name));
            return "common";
        }
        model.addAttribute("max", accountService.findMaxPage());
        model.addAttribute("accountNoVip", accountService.findPage((Integer) session.getAttribute("num") * 6 - 6));
        return "common";
    }

    @GetMapping("/deleteAccount")
    @ApiOperation("删除账号的方法")
    public String deleteAccount(int id, Model model, HttpSession session) {
        String name=(String) session.getAttribute("name");
        model.addAttribute("isDelete", accountService.deleteAccount(id) > 0);
        if(name!=null){
            if (accountService.findAccountCount(name) % 6 == 0)
                session.setAttribute("num", (Integer) session.getAttribute("num") - 1);
            model.addAttribute("num", session.getAttribute("num"));
            model.addAttribute("max", accountService.findMaxPage(name));
            model.addAttribute("accountNoVip", accountService.findPage((Integer) session.getAttribute("num") * 6 - 6,name));
            return "common";
        }
        if (accountService.findAccountCount() % 6 == 0)
        session.setAttribute("num", (Integer) session.getAttribute("num") - 1);
        model.addAttribute("num", session.getAttribute("num"));
        model.addAttribute("max", accountService.findMaxPage());
        model.addAttribute("accountNoVip", accountService.findPage((Integer) session.getAttribute("num") * 6 - 6));
        return "common";
    }

    @PostMapping("/addAccount")
    @ApiOperation("增加账号的方法")
    public String addAccount(AccountAdd account, Model model, HttpSession session) {
        account.setIsVip(0);
        model.addAttribute("isAdd", accountService.addAccount(account) > 0);
        model.addAttribute("num", session.getAttribute("num"));
        String name=(String) session.getAttribute("name");
        if(name!=null){
            model.addAttribute("max", accountService.findMaxPage(name));
            model.addAttribute("accountNoVip", accountService.findPage((Integer) session.getAttribute("num") * 6 - 6,name));
            return "common";
        }
        model.addAttribute("max", accountService.findMaxPage());
        model.addAttribute("accountNoVip", accountService.findPage((Integer) session.getAttribute("num") * 6 - 6));
        return "common";
    }

    @GetMapping("/goNoVip")
    @ApiOperation("到普通用户管理页面")
    public String goNoVip(Model model, HttpSession session) {
        model.addAttribute("accountNoVip", accountService.findFistPage());
        model.addAttribute("max", accountService.findMaxPage());
        model.addAttribute("num", 1);
        session.setAttribute("num", 1);
        return "common";
    }

    @GetMapping("/pageSearch")
    @ApiOperation("分页搜索的方法")
    public String search(String page, Model model, HttpSession httpSession, String upDown) {
        //对page做数据处理
        page = accountService.makePage(page, accountService.findMaxPage());

        if (page != null) {
            int a = Integer.parseInt(page);
            if (a != 0) httpSession.setAttribute("num", a);
        }
        if (upDown != null) {
            if (upDown.equals("up"))
                httpSession.setAttribute("num", (Integer) httpSession.getAttribute("num") + 1);
            if (upDown.equals("down"))
                httpSession.setAttribute("num", (Integer) httpSession.getAttribute("num") - 1);
        }
        if(httpSession.getAttribute("name")!=null){
            model.addAttribute("accountNoVip", accountService.findPage((Integer) httpSession.getAttribute("num") * 6 - 6,(String) httpSession.getAttribute("name")));
            model.addAttribute("num", (Integer) httpSession.getAttribute("num"));
            model.addAttribute("max", accountService.findMaxPage((String) httpSession.getAttribute("name")));
            return "common";
        }

        model.addAttribute("accountNoVip", accountService.findPage((Integer) httpSession.getAttribute("num") * 6 - 6));
        model.addAttribute("num", (Integer) httpSession.getAttribute("num"));
        model.addAttribute("max", accountService.findMaxPage());
        return "common";
    }
    @GetMapping("/nameSearch")
    @ApiOperation("分页搜索")
    public String nameSearch(String name, Model model, HttpSession session) {
        session.setAttribute("name",name);
        model.addAttribute("accountNoVip", accountService.findFistPage(name));
        if(accountService.findMaxPage(name)==0)
        model.addAttribute("max", accountService.findMaxPage(name)+1);
        model.addAttribute("max", accountService.findMaxPage(name));
        model.addAttribute("num", 1);
        session.setAttribute("num", 1);
        if(name.equals("")) {
            session.removeAttribute("name");
        }
        return "common";
    }
}
