package com.pw.service;

import com.pw.pojo.Picture;
import org.apache.ibatis.annotations.Param;

/**
 * @author 三季人
 * @create 2020-08-21 9:44
 */
public interface PageViewsService {
    Picture getPageViewById(@Param("id") Integer id);
    Integer updatePageView(@Param("id") Integer id);
}
