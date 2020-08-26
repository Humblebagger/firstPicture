package com.pw.pojo.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 武祥市
 */
@Data
public class AccountUpdate {
    @ApiModelProperty("用户序号")
    private Integer id;
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("用户性别")
    private String sex ;
    @ApiModelProperty("用户上传图片次数")
    private Integer uploadTimes;
    @ApiModelProperty("用户个性签名")
    private String personalSignature;
}
