package com.pw.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户实体类")
public class AccountDownload {
    @ApiModelProperty("用户序号")
    private Integer id;
    @ApiModelProperty("用户名字")
    private String userName;
    @ApiModelProperty("下载的图片")
    private String picturePosition;
    @ApiModelProperty("图片详细信息")
    private Picture picture;
}
