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

@Api(value = "查询vip用户接口层次", tags = "查询vip用户接口")
@Controller
@Slf4j
@RequestMapping(value = "/account", produces = "text/html;charset=utf-8")
public class VipController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/updateVipAccount")
    @ApiOperation("修改VIP用户的方法")
    public String updateAccountVip(AccountUpdate account, Model model, HttpSession session) {
        model.addAttribute("isUpdate", accountService.updateAccount(account) > 0);
        String name = (String)session.getAttribute("nameVip");
        if(name!=null){
            model.addAttribute("maxVip", accountService.findVipMaxPage(name));
            model.addAttribute("accountVip", accountService.findVipPage((Integer) session.getAttribute("numVip") * 6 - 6,name));
            model.addAttribute("numVip", session.getAttribute("numVip"));
            return "special";
        }
        model.addAttribute("maxVip", accountService.findVipMaxPage());
        model.addAttribute("accountVip", accountService.findVipPage((Integer) session.getAttribute("numVip") * 6 - 6));
        model.addAttribute("numVip", session.getAttribute("numVip"));
        return "special";
    }

    @GetMapping("/deleteVipAccount")
    @ApiOperation("删除VIP账号的方法")
    public String deleteVipAccount(int id, Model model, HttpSession session) {
        model.addAttribute("isDelete", accountService.deleteAccount(id) > 0);
        String name = (String)session.getAttribute("nameVip");
        if(name!=null){
            if (accountService.findVipAccountCount(name) % 6 == 0)
                session.setAttribute("numVip", (Integer) session.getAttribute("numVip") - 1);
            model.addAttribute("maxVip", accountService.findVipMaxPage(name));
            model.addAttribute("numVip", session.getAttribute("numVip"));
            model.addAttribute("accountVip", accountService.findVipPage((Integer) session.getAttribute("numVip") * 6 - 6,name));
            return "special";
        }
        if (accountService.findVipAccountCount() % 6 == 0)
            session.setAttribute("numVip", (Integer) session.getAttribute("numVip") - 1);
        model.addAttribute("maxVip", accountService.findVipMaxPage());
        model.addAttribute("numVip", session.getAttribute("numVip"));
        model.addAttribute("accountVip", accountService.findVipPage((Integer) session.getAttribute("numVip") * 6 - 6));
        return "special";
    }

    @PostMapping("/addVipAccount")
    @ApiOperation("增加VIP账号的方法")
    public String addVipAccount(AccountAdd account, Model model, HttpSession session) {
        account.setIsVip(1);
        model.addAttribute("isAdd", accountService.addAccount(account) > 0);
        String name = (String)session.getAttribute("nameVip");
        if(name!=null){
            model.addAttribute("maxVip", accountService.findVipMaxPage(name));
            model.addAttribute("accountVip", accountService.findVipPage((Integer) session.getAttribute("numVip") * 6 - 6,name));
            model.addAttribute("numVip", session.getAttribute("numVip"));
            return "special";
        }
        model.addAttribute("maxVip", accountService.findVipMaxPage());
        model.addAttribute("accountVip", accountService.findVipPage((Integer) session.getAttribute("numVip") * 6 - 6));
        model.addAttribute("numVip", session.getAttribute("numVip"));
        return "special";
    }

    @GetMapping("/goVip")
    @ApiOperation("跳转到vip页面")
    public String goVip(Model model, HttpSession session) {
        model.addAttribute("accountVip", accountService.findVipFistPage());
        model.addAttribute("maxVip", accountService.findVipMaxPage());
        model.addAttribute("numVip", 1);
        session.setAttribute("maxVip", accountService.findVipMaxPage());
        session.setAttribute("numVip", 1);
        return "special";
    }

    @GetMapping("/pageSearchVip")
    @ApiOperation("分页跳转")
    public String searchVip(String page, Model model, HttpSession httpSession, String upDown) {
        //对page做数据处理
        page = accountService.makePage(page, accountService.findVipMaxPage());

        if (page != null) {
            int a = Integer.parseInt(page);
            if (a != 0) {
                httpSession.setAttribute("numVip", a);
            }
        }
        if (upDown != null) {
            if (upDown.equals("up")) {
                httpSession.setAttribute("numVip", (Integer) httpSession.getAttribute("numVip") + 1);
            }
            if (upDown.equals("down")) {
                httpSession.setAttribute("numVip", (Integer) httpSession.getAttribute("numVip") - 1);
            }
        }
        if(httpSession.getAttribute("nameVip")!=null){
            model.addAttribute("accountVip", accountService.findVipPage((Integer) httpSession.getAttribute("numVip") * 6 - 6,(String)httpSession.getAttribute("nameVip")));
            model.addAttribute("numVip", (Integer) httpSession.getAttribute("numVip"));
            model.addAttribute("maxVip", accountService.findVipMaxPage((String) httpSession.getAttribute("nameVip")));
            return "special";
        }
        model.addAttribute("accountVip", accountService.findVipPage((Integer) httpSession.getAttribute("numVip") * 6 - 6));
        model.addAttribute("numVip", (Integer) httpSession.getAttribute("numVip"));
        model.addAttribute("maxVip", accountService.findVipMaxPage());
        return "special";
    }
    @GetMapping("/nameVipSearch")
    @ApiOperation("查询方法")
    public String nameVipSearch(String name, Model model, HttpSession session) {
        session.setAttribute("nameVip",name);
        model.addAttribute("accountVip", accountService.findVipFistPage(name));
        if(accountService.findVipMaxPage(name)==0) {
            model.addAttribute("maxVip", accountService.findVipMaxPage(name)+1);
        }
        model.addAttribute("maxVip", accountService.findVipMaxPage(name));
        model.addAttribute("numVip", 1);
        session.setAttribute("numVip", 1);
        if(name.equals("")) {
            session.removeAttribute("nameVip");
        }
        return "special";
    }
}
