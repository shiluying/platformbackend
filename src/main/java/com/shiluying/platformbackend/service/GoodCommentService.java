package com.shiluying.platformbackend.service;

import com.shiluying.platformbackend.Response.ServerResponse;

public interface GoodCommentService {
    ServerResponse findGoodCommentById(Integer good_id);

    ServerResponse addGoodComment(String comment, int buyer_id, int good_id);
}
