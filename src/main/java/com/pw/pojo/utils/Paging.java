package com.pw.pojo.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("分页类")
public class Paging {
   @ApiModelProperty("第几页")
   private String page;
   @ApiModelProperty("一页的大小")
   private int pageSize;
   @ApiModelProperty("名字")
   private String name;
}
