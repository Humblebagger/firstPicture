package com.pw.service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pw.dao.AccountMap;
import com.pw.dao.OrderMap;
import com.pw.pojo.Account;
import com.pw.pojo.Orders;
import com.pw.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

import static com.pw.config.AliDevPayConfig.*;

/**
 * @author 武祥市
 */
@Service
public class AliPayServiceImpl implements AliPayService {
    @Autowired
    OrderMap orderMap;
    @Autowired
    AccountMap accountMap;
    @Override
    public void aliPay(HttpServletResponse response) throws IOException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl, app_id, merchant_private_key, "json", charset, alipay_public_key, sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(return_url);
        alipayRequest.setNotifyUrl(notify_url);
        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = UUID.randomUUID().toString();
        System.out.println("out_trade_no=" + out_trade_no);
        //付款金额，必填
        String total_amount = "158552";
        //订单名称，必填
        String subject = "订单名称";
        //商品描述，可空
        String body = "商品名称";

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        //		+ "\"total_amount\":\""+ total_amount +"\","
        //		+ "\"subject\":\""+ subject +"\","
        //		+ "\"body\":\""+ body +"\","
        //		+ "\"timeout_express\":\"10m\","
        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

        //请求
        String result = "";
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        //输出
        response.setContentType("text/html;charset=" + charset);
        response.getWriter().write(result);// 直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();
    }

    @Override
    public String returnUrl(HttpServletRequest request, HttpSession session) throws AlipayApiException, UnsupportedEncodingException {
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
//            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");
            params.put(name, valueStr);
        }
        System.out.println("params:" + params);
        //调用SDK验证签名
        boolean signVerified = AlipaySignature.rsaCheckV2(params, alipay_public_key, charset, sign_type);
        System.out.println("signVerified=>>" + signVerified);
        //——请在这里编写您的程序（以下代码仅作参考）——
        if (signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
            orderMap.addOrders(new Orders(null,((Account)session.getAttribute("Account")).getUserName(),out_trade_no,trade_no,Integer.parseInt(total_amount)));
            Account account = new Account();
            account.setIsVip(1);
            accountMap.updateAccount(account);
            return "main";
//            return "trade_no:"+trade_no+"<br/>out_trade_no:"+out_trade_no+"<br/>total_amount:"+total_amount;
        } else {
            return "main";
        }
    }

    @Override
    public List<Orders> findPage(String pageNum,int pageSize) {
        String s = PageUtils.pageUtil(pageNum, orderMap.findOrdersCount());
        PageHelper.startPage(Integer.parseInt(s), pageSize);
        PageInfo<Orders> pageInfo = new PageInfo<Orders>(orderMap.findOrders(null));
        System.out.println(pageInfo);
        return pageInfo.getList();
    }

    @Override
    public List<Orders> findPage(String pageNum, int pageSize, String name) {
        String s = PageUtils.pageUtil(pageNum, orderMap.findOrdersCount());
        PageHelper.startPage(Integer.parseInt(s), pageSize);
        PageInfo<Orders> pageInfo = new PageInfo<Orders>(orderMap.findOrders(name));
        System.out.println(pageInfo);
        return pageInfo.getList();
    }
}
