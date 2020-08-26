package com.pw.controller.Admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pw.dao.OrderMap;
import com.pw.pojo.Orders;
import com.pw.service.AliPayService;
import com.pw.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 武祥市
 */
@Api(value = "查询订单接口层次", tags = "查询订单接口")
@Controller
@Slf4j
@RequestMapping("/account")
public class OrderController {
    @Autowired
    AliPayService aliPayService;
    @Autowired
    OrderMap orderMap;

    @PostMapping("/findOrder")
    @ApiOperation(value = "查询订单", httpMethod = "POST", response = Orders.class)
    public String findOrder(@RequestParam(value = "page", defaultValue = "1") String page, Model model) {
        PageHelper.startPage(Integer.parseInt(PageUtils.pageUtil(page, orderMap.findOrdersCount())), 6);
        PageInfo<Orders> pageInfo = new PageInfo<Orders>(orderMap.findOrders(null));
        model.addAttribute("OrderList",pageInfo);
        return "";
    }

    @PostMapping("/deleteOrder")
    @ApiOperation(value = "删除订单")
    public String deleteOrder(@RequestParam(value = "id") int id, @RequestParam(value = "page") String page, Model model) {
        PageHelper.startPage(Integer.parseInt(PageUtils.pageUtil(page, orderMap.findOrdersCount())), 6);
        PageInfo<Orders> pageInfo = new PageInfo<Orders>(orderMap.findOrders(null));
        model.addAttribute("OrderList",pageInfo);
        model.addAttribute("", orderMap.deleteOrders(id) > 0);
        return "";
    }

    @PostMapping("/addOrder")
    @ApiOperation(value = "增加订单")
    public String addOrder(Orders orders, @RequestParam(value = "page") String page, Model model) {
        PageHelper.startPage(Integer.parseInt(PageUtils.pageUtil(page, orderMap.findOrdersCount())), 6);
        PageInfo<Orders> pageInfo = new PageInfo<Orders>(orderMap.findOrders(null));
        model.addAttribute("OrderList",pageInfo);
        model.addAttribute("", orderMap.addOrders(orders) > 0);
        return "";
    }

    @PostMapping("/updateOrder")
    @ApiOperation(value = "修改订单")
    public String updateOrder(Orders orders, @RequestParam(value = "page") String page, Model model) {
        PageHelper.startPage(Integer.parseInt(PageUtils.pageUtil(page, orderMap.findOrdersCount())), 6);
        PageInfo<Orders> pageInfo = new PageInfo<Orders>(orderMap.findOrders(null));
        model.addAttribute("OrderList",pageInfo);
        model.addAttribute("", orderMap.updateOrders(orders) > 0);
        return "";
    }


    @PostMapping("/searchOrder")
    @ApiOperation(value = "搜索订单")
    public String searchOrder(@RequestParam(value = "name")String name, @RequestParam(value = "page") String page, Model model) {
        PageHelper.startPage(Integer.parseInt(PageUtils.pageUtil(page, orderMap.findOrdersCount())), 6);
        PageInfo<Orders> pageInfo = new PageInfo<Orders>(orderMap.findOrders(name));
        model.addAttribute("OrderList",pageInfo);
        return "";
    }
}
