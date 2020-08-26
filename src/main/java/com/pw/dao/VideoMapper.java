package com.pw.dao;

import com.pw.pojo.Video;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 三季人
 * @create 2020-08-23 21:20
 */
@Mapper
@Repository
public interface VideoMapper {
    Video listAllVideo();

}
