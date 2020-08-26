package com.pw.service;

import com.pw.dao.VideoMapper;
import com.pw.pojo.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 三季人
 * @create 2020-08-21 9:43
 */
@Service

public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;

    public Video listAllVideo() {
        return videoMapper.listAllVideo();
    }

}
