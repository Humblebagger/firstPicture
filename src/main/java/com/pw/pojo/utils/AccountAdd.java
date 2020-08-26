package com.pw.pojo.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 武祥市
 */
@Data
public class AccountAdd {
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("用户密码")
    private String password;
    @ApiModelProperty("用户密保")
    private String problemPassword;
    @ApiModelProperty("用户答案")
    private String problemAnswer;
    @ApiModelProperty("用户是否为Vip")
    private Integer isVip;

}
