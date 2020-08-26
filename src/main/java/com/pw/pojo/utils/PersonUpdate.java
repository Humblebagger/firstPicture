package com.pw.pojo.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 武祥市
 */
@Data
public class PersonUpdate {
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("用户性别")
    private String sex ;
    @ApiModelProperty("用户个性签名")
    private String personalSignature;
    @ApiModelProperty("用户出生年")
    private String birthday;
    @ApiModelProperty("用户居住大地点")
    private String bigPosition;
    @ApiModelProperty("用户居住小地点")
    private String smallPosition;
}
