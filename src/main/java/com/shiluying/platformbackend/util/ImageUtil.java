package com.shiluying.platformbackend.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class ImageUtil {
    public static String COMMODITY_IMG = "/commodities/",
            ROOT_URL="http://localhost:8085/images", ROOT_PATH = "E://test";

    public static String uploadImg(MultipartFile file, String path) throws IOException {
//        获取文件名
        String filename = file.getOriginalFilename();
//        创建文件
        File newFile = new File(ROOT_PATH + path);
        if (!newFile.exists()) {
            newFile.mkdirs();
        }
//        打开输入输出准备保存文件
        FileInputStream inputStream = (FileInputStream) file.getInputStream();
        String savePath = ROOT_PATH + path + filename;
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(savePath));
        byte[] bs = new byte[1024];
        int len;
        while ((len = inputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
//        返回文件的url
        return ROOT_URL + path + filename;
    }
}
