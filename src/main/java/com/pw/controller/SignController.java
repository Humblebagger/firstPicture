package com.pw.controller;

import com.pw.pojo.Account;
import com.pw.service.SignService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * @author 三季人
 * @create 2020-08-21 9:55
 */
@Controller
public class SignController {
    @Qualifier("signServiceImpl")
    @Autowired
    private SignService signService;

    @RequestMapping(value = "/sign")
    @ApiOperation("签到接口")
    public String sige( Model model, HttpSession session) {
        String userName= (String) session.getAttribute("userName");
        if (signService.sige(userName)!=null) {
            signService.addIntegral(userName);
            model.addAttribute("su","签到成功");
            return "redirect:/sign";
        }
        model.addAttribute("msg", "今日已经签到请明天继续");
        return "main";
    }
    @ApiOperation("查看积分接口 ")
    @RequestMapping(value = "/AllIntegral")
    public String AllIntegral(Model model,HttpSession session){
        String userName= (String) session.getAttribute("userName");
        Account integral=signService.AllIntegral(userName);
        model.addAttribute("integral",integral);
        return "Allintegral";
    }

    @ApiOperation("兑换会员接口")
    @RequestMapping(value = "/convertVip")
    public String convertVip( Model model,HttpSession session) {
        String userName= (String) session.getAttribute("userName");

        Account account=signService.convertVip(userName);
        if (account!=null){
            model.addAttribute("isVip", "兑换成功");
        }
        model.addAttribute("noVip", "积分不足或者您已经是vip");

        return "Allintegral";
    }


}
