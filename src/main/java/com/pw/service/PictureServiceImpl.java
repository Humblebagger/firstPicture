package com.pw.service;

import com.pw.dao.PictureMap;
import com.pw.pojo.Picture;
import com.pw.pojo.utils.PicturePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    PictureMap pictureMap;

    @Override
    public List<Picture> findPicture(PicturePage picturePage) {
        return pictureMap.findPicture(picturePage);
    }
    @Override
    public Integer uploadPicture(Picture picture) {
        return pictureMap.uploadPicture(picture);
    }


    @Override
    public Integer deletePicture(int id) {
        return pictureMap.deletePicture(id);
    }

    @Override
    public List<Picture> findPicturePage(PicturePage picturePage) {
        return pictureMap.findPicturePage(picturePage);
    }

    @Override
    public Integer findPictureCount(PicturePage picturePage) {
        return pictureMap.findPictureCount(picturePage);
    }

    @Override
    public List<Integer> findPageList(String name) {
        //查询总条数
        PicturePage picturePage = new PicturePage();
        picturePage.setName(name);
        Integer pictureCount = pictureMap.findPictureCount(picturePage);

        //生成分页的数组page，并存入model
        List<Integer> page = new ArrayList<Integer>();
        int count=pictureCount/24+1;
        if(count == 0 ) {
            page.add(1);
        }
        for (int i = 0; i < count; i++) {
            page.add(i+1);
        }
        return page;
    }

    @Override
    public List<Picture> findPictureList(String name, int start) {
        PicturePage picturePage = new PicturePage();
        picturePage.setName(name);
        picturePage.setStart(start);
        picturePage.setEnd(24);
        List<Picture> pictures = pictureMap.findPicturePage(picturePage);
        return pictures;
    }

    @Override
    public Integer updatePicture(Map<String, Object> map) {
        return pictureMap.updatePicture(map);
    }

    @Override
    public Picture findById(int id) {
        return pictureMap.findById(id);
    }

    @Override
    public Picture findByIdL(int id) {
        return pictureMap.findByIdL(id);
    }

    @Override
    public Picture findByPosition(String position) {
        return pictureMap.findByPosition(position);
    }


}
