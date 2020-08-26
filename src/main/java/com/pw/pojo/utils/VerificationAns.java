package com.pw.pojo.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 武祥市
 */
@Data
public class VerificationAns {
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("用户答案")
    private String problemAnswer;
}
