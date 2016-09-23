package com.qiezi.demo.handler;

import com.qiezi.demo.model.People;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import static ratpack.jackson.Jackson.json;

/**
 * Created by Daniel on 9/23/16.
 */
public class BarHandler implements Handler {
    @Override
    public void handle(Context ctx) throws Exception {
        ctx.render(json(new People("daniel", 23)));
    }

}
