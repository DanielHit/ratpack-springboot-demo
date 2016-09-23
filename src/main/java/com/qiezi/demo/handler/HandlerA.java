package com.qiezi.demo.handler;

import ratpack.handling.Context;
import ratpack.handling.Handler;

/**
 * Created by Daniel on 9/23/16.
 */
public class HandlerA implements Handler {

    @Override
    public void handle(Context ctx) throws Exception {
        // 这是什么
        ctx.getResponse().send("what a fuck!");
    }

}
