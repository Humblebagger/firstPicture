package com.pw.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author 武祥市
 */
@Configuration
public class AliDevPayConfig {
    /**
     * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
     */
    public static String app_id = "2021000118658599";
    /**
     * 商户私钥，您的PKCS8格式RSA2私钥    （自己生成的私钥，记得去除空格，换行符）
     */
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDN7DHgQ4fVWMh1v2veT5qGVJZZv76YRpxCoIBB10exNTKxzIPx3B+7bdU8CJG+lggNUpz//kREizKhTfv1FgJffTVT8o9TdlJ/65wKlKRchDcTWkggeFhJInOtR1DfQyvAGqWvqvgyEZESs7dQPImc0gyi1hbZ1urgfZwoIro+QgFvRsnlyBDD1J9/IfDWmQN0ey0bZcOQyhJXNHvWLmlG52XF+LbXjBGUZb7atZft+pKR9HxGe4KAVYGWlkPXd52VAMLbuSMO9SdTdEe0kHqHIQxT0opfYlKUBEkS3NiGew2jDprQGybeA4tL1JrIUxU97Vo5b0ycgEaiAP5hHVqZAgMBAAECggEAA7hgrkyKB7Cy7m2m5T1K7WJZ1QVBzD56VDnSF15sTSdI4y1utM/lQt2ZHJyLBYZwXs0/SOCvGw3ovEFMbAEZyd/ZNssLC9b3Zpg7GXXWAlXhKNhYtT13WtrkfBztuRrdj3rrw2CzWzQ2CsB0b16oncytrcNwZj8bvzKFv7Pg6X7/e7EJTlRc+bZao/ybb27wWB0kKvHheWJSz3I1kXynGLaBc/37FqDxKZycNIJAu3SZLiHV3KKs8EjIH3soeR5KRLH9aIVj82CNgjvJvWtUcGcc+lAOw36SswQMPxD2LfmmYU82AJmey+I926ER0Z8FAQ/MtY3I0vLytFC2tVjggQKBgQDoTM6kfrqnd/H4rdB/3NqdEbMRc/OJtQFR2i0t433raeme9AjhqlEUKmU3sG+u0k9poY56n9xvd7F1hiMs160PeY2oG87GTMr1NgA3IhNU5lgnIMm2kG8RNVSW20EH+Efy+TlMNtmZFx1m+PpAFMLcJQEv+iAi0CbE8jZULgEKzwKBgQDi7ncQyGvU9K3RjgV1SocYwLsS/J/5JxI5L9XJsHq+bs6bCWkc1CSMbfFutPwg9HZEBjuhHdtGSSI6tctQ4qc6b0ki2vxsKPmSYKHohwOqApx9G3WRT4asRQLh+fEquzWfNnZSGVZw6UTmg4RrarvDdUoNagNn6PCAHcFcx/T+FwKBgERV6+gJ+8CuETl1cENc5daU0VeOA5N78sJwax/3ryAkjPwcj8xKvQUwn4vtVD1aUtAhHXfHNSJ5VHPdHNXhMGDAAkL0wzQkfQP7eb6+QG+WP1JrW8tf27x1MsgaAZxllkzMseVQsVxOp3CWR4+4S8ZVAG9rpi53iyAenIrQ6a+TAoGBAJN6RDjM938jMF8yfAuYzqlgf3M8aD6EjMxLcRWtMmfWHUEWYZBRshrtTG0VA5HrLXzRzCjN/XX1C2C6SpKbafCI6C/VvxwPmPnvAOnb7J6tKcQId2RjGXOVOeVgCMIrfhKlU0nRm6Kvho6ERCeG6tWAwQpsrh/2e23XaJWCgY4rAoGBAJn9xRai+TdvGHsTo9N9tf6CN+QGEKz0U0DilKSxpx316bJnUYY8L+KKsbwgs+z6hAPRcIYYRB6rCAeqmQApc+SfGtmXGeaZ4/5y9/MBlEPBwbdsSx4GL67o/VhUZwoTfh6nhesBs4KM9M1Oq9+ohu7V4Sjspw7jm4pGinjkyCs0";
    /**
     * 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
     */
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq2KVyxoAfr+I75LhWDPvgJBhlLRG5q7c+uMkLCBEFlC4m7m3LfHt6vlsEUc1B7IZdk1vRyQ/FCs6qwA4RAnS3YRPQiWKRuCajkjj2BjvSvzaYx5qfNlfDcSQmHL94S+ocYm1G6e1W5Fx0fXMTRNWOmhLf4+pfW447tVfhhbmxWqYMQ+7Wje0vr3u7ABxkZhF+w/vnkdNs1ts1DTcxVZ1zuuAce7VBWjsWBTFodlORynPRSAVe547z2/fla1971syZHmIowYwiT98fubFdd9kFqujovOfQF/3dq350jrYzu8sZDhcXy+YoctJk7sehIPiYR4JlPPiXOVhTY3WxVV8eQIDAQAB";
    /**
     * 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    public static String notify_url = "http://39.98.122.247:8080/alipay/notify_url";
    /**
     * 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    public static String return_url = "http://39.98.122.247:8080/alipay/return_url";
    /**
     * 签名方式
     */
    public static String sign_type = "RSA2";
    /**
     * 字符编码格式
     */
    public static String charset = "UTF-8";
    /**
     * 支付宝网关
     */
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    /**
     * 日志输出
     */
    public static String log_path = "D:/";
}
