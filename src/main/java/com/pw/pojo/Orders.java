package com.pw.pojo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 武祥市
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户订单")
public class Orders {
    @ApiModelProperty("订单id")
    private Integer id;
    @ApiModelProperty("用户名字")
    private String uid;
    @ApiModelProperty("商户订单号")
    private String merchantOrderNumber;
    @ApiModelProperty("支付宝交易号")
    private String alipayTransactionNumber;
    @ApiModelProperty("付款金额")
    private Integer paymentAmount;
}
