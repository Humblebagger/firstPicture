package com.pw.pojo.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("图片分页")
public class PicturePage {
    @ApiModelProperty("第几页")
    private int page;
    private int start;
    @ApiModelProperty("一页的大小")
    private int end;
    @ApiModelProperty("名字")
    private String name;
    @ApiModelProperty("大类别")
    private String bigSort;
    @ApiModelProperty("小类别")
    private String smallSort;
}
