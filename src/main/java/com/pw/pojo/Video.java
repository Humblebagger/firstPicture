package com.pw.pojo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 三季人
 * @create 2020-08-23 21:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("视频实体")

public class Video {
    private Integer id;
    private String url;
}
