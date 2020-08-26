package com.pw.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("反馈")
public class AccountFeedback {
    @ApiModelProperty("用户id")
    private Integer id;
    @ApiModelProperty("用户名字")
    private String userName;
    @ApiModelProperty("反馈信息")
    private String accountFeedback;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("排序")
    private Integer ranking;

}
