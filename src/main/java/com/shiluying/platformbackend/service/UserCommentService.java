package com.shiluying.platformbackend.service;

import com.shiluying.platformbackend.Response.ServerResponse;

public interface UserCommentService {
    ServerResponse findUserCommentById(Integer user_id);

    ServerResponse addUserComment(String comment, int buyer_id, int seller_id);
}
