package com.pw.service;

import com.pw.pojo.Picture;
import com.pw.pojo.utils.PicturePage;

import java.util.List;
import java.util.Map;

public interface PictureService {
    //显示所有信息
    List<Picture> findPicture(PicturePage picturePage);
    //上传图片
    Integer uploadPicture(Picture picture);
    //删除图片
    Integer deletePicture(int id);
    //查询分页
    List<Picture> findPicturePage(PicturePage picturePage);
    //查询图片数量
    Integer findPictureCount(PicturePage picturePage);
    //返回页数的集合
    List<Integer> findPageList(String name);
    //查找图片的集合
    List<Picture> findPictureList(String name, int start);
    //修改图片
    Integer updatePicture(Map<String, Object> map);
    //根据id查询
    Picture findById(int id);
    //根据id查询轮播图
    Picture findByIdL(int id);
    Picture findByPosition(String position);
}
