package com.qiezi.demo.action;

import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.http.Headers;

/**
 * Created by Daniel on 9/23/16.
 */
public class HeadHandler implements Handler {
    @Override
    public void handle(Context ctx) throws Exception {
        Headers headers = ctx.getRequest().getHeaders();
        String clientHeader = headers.get("Client-Header");
        ctx.getResponse().send(clientHeader);
    }
}
