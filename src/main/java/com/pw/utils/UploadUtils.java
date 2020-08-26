package com.pw.utils;

import com.qiniu.common.Zone;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public class UploadUtils {
    public static void Upload(MultipartFile file, String name) throws IOException {
        String accessKey = "H8lf0rnzXbs7XnAnNA0FvzEPj5mxCmmXFZZ1VhDd";
        String secretKey = "lSKp4li7wTxtJ4ZRqVDnd9deKCPphxvIqre_O1w-";
        String bucket = "firepicture";//存储空间名

        Configuration cfg = new Configuration(Zone.zone2());
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        InputStream is = file.getInputStream(); //文件输入流
        uploadManager.put(is, name, upToken,null,null);
        is.close();
    }
}
