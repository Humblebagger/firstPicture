package com.pw.controller;

import com.pw.pojo.Video;
import com.pw.service.VideoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 三季人
 * @create 2020-08-16 15:38
 */
@Controller
public class VideoController {
    @Autowired
    private VideoService videoService;

    @ApiOperation("视频接口")
    @RequestMapping(value = "/video")
    public String list(Model model) {
        List<Video> video = (List<Video>) videoService.listAllVideo();
        model.addAttribute("AllVideo", video);
        return "AllVideo";
    }

}
