package com.pw.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户实体类")
public class Account {
    @ApiModelProperty("用户序号")
    private Integer id;
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("用户密码")
    private String password;
    @ApiModelProperty("用户性别")
    private String sex ;
    @ApiModelProperty("用户密保")
    private String problemPassword;
    @ApiModelProperty("用户答案")
    private String problemAnswer;
    @ApiModelProperty("用户是否为Vip")
    private Integer isVip;
    @ApiModelProperty("用户上传图片次数")
    private Integer uploadTimes;
    @ApiModelProperty("用户头像")
    private String headPortrait;
    @ApiModelProperty("用户个性签名")
    private String personalSignature;
    @ApiModelProperty("用户序号")
    private Integer ranking;
    @ApiModelProperty("用户出生年")
    private String birthday;
    @ApiModelProperty("用户居住大地点")
    private String bigPosition;
    @ApiModelProperty("用户居住小地点")
    private String smallPosition;
    @ApiModelProperty("用户背景图")
    private String background;
    @ApiModelProperty("积分")
    private Integer integral;
    @ApiModelProperty("签到日期")
    private Date date;
}
