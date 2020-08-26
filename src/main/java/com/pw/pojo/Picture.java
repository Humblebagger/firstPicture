package com.pw.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("图片类")
public class Picture {
    @ApiModelProperty("图片id")
    private Integer id;
    @ApiModelProperty("图片名字")
    private String name;
    @ApiModelProperty("图片位置")
    private String position;
    @ApiModelProperty("图片大分类")
    private String bigSort;
    @ApiModelProperty("图片小分类")
    private String smallSort;
    @ApiModelProperty("图片内存大小")
    private Integer memory;
    @ApiModelProperty("图片描述")
    private String description;
    @ApiModelProperty("浏览量")
    private Integer pageviews;

}
