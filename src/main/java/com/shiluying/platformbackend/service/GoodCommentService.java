package com.shiluying.platformbackend.service;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.entity.GoodComment;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface GoodCommentService {
    ServerResponse findGoodCommentById(Integer good_id);

    ServerResponse addGoodComment(GoodComment goodComment);
    ServerResponse upLoadImg(MultipartFile multipartFile) throws IOException;
}
