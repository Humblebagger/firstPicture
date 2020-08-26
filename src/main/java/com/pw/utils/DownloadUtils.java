package com.pw.utils;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;


public class DownloadUtils {
    public static void download(HttpServletResponse response, String name) throws IOException {
        String replace = name.replace(" ", "%20");
        response.reset(); //设置页面不缓存,清空buffer
        response.setCharacterEncoding("UTF-8"); //字符编码
        response.setContentType("multipart/form-data"); //二进制传输数据
        //设置响应头
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + URLEncoder.encode(name, "UTF-8"));

        URL url = new URL("http://wxsaxaxa.icu/" + replace);
        System.out.println(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = httpURLConnection.getInputStream();
        OutputStream out = response.getOutputStream();
        byte[] buff = new byte[1024];
        int index;
        //4、执行 写出操作
        while ((index = inputStream.read(buff)) != -1) {
            out.write(buff, 0, index);
            out.flush();
        }
        out.close();
        inputStream.close();
    }
}
