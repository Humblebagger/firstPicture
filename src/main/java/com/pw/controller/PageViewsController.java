package com.pw.controller;

import com.pw.pojo.Picture;
import com.pw.service.PageViewsService;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 三季人
 * @create 2020-08-21 10:10
 */
@Controller
public class PageViewsController {
    @Autowired
    @Qualifier("pageViewsServiceImpl")
    private PageViewsService pageViewsService;

    @CrossOrigin
    @RequestMapping(value = "/userPageViewApi", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation("浏览量增添接口")
    public String userPageViewApi(Integer id, Model model) {
        Integer pictureId = pageViewsService.updatePageView(id);
        model.addAttribute("pageviews", pageViewsService.getPageViewById(id));
        return "统计成功";
    }
}
