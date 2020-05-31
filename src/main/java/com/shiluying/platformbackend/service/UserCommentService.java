package com.shiluying.platformbackend.service;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.entity.UserComment;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserCommentService {
    ServerResponse findUserCommentById(Integer sender_id);

    ServerResponse addUserComment(UserComment userComment);

    ServerResponse upLoadImg(MultipartFile multipartFile) throws IOException;
}
