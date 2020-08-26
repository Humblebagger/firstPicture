package com.pw.dao;

import com.pw.pojo.Picture;
import com.pw.pojo.utils.PicturePage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Mapper
@Repository
public interface PictureMap {

     //查询信息
     List<Picture> findPicture(PicturePage picturePage);
     //图片上传
     Integer uploadPicture(Picture picture);
     //删除图片
     Integer deletePicture(int id);
     //查询分页
     List<Picture> findPicturePage(PicturePage picturePage);
     //查询图片数量
     Integer findPictureCount(PicturePage picturePage);
     //修改图片
     Integer updatePicture(Map<String, Object> map);
     //根据id查询
     Picture findById(int id);
     //根据id查询轮播图
     Picture findByIdL(int id);
     //根据图片位置查找
     Picture findByPosition(String position);
}
