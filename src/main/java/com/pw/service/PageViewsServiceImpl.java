package com.pw.service;

import com.pw.dao.PageViewsMapper;
import com.pw.pojo.Picture;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 三季人
 * @create 2020-08-21 9:44
 */
@Service

public class PageViewsServiceImpl implements PageViewsService {
    @Autowired

    private PageViewsMapper pageViewsMapper;

    public void setPageViewsMapper(PageViewsMapper pageViewsMapper) {
        this.pageViewsMapper = pageViewsMapper;
    }

    public Picture getPageViewById(Integer id) {
        return pageViewsMapper.getPageViewById(id);
    }

    public Integer updatePageView(Integer id) {
        return pageViewsMapper.updatePageView(id);
    }


}
