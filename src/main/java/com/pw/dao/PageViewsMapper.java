package com.pw.dao;

import com.pw.pojo.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 三季人
 * @create 2020-08-21 9:34
 */
@Mapper
@Repository
public interface PageViewsMapper {
    Picture getPageViewById(@Param("id") Integer id);
    Integer updatePageView(@Param("id") Integer id);
}
