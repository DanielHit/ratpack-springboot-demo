package com.qiezi.demo.handler;

import ratpack.handling.Context;
import ratpack.handling.Handler;

/**
 * Created by Daniel on 9/23/16.
 */
public class BarHandler implements Handler {
    @Override
    public void handle(Context ctx) throws Exception {
        ctx.getResponse().send("bar");
    }
}
