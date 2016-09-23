package com.qiezi.demo.handler;

import com.qiezi.demo.model.People;
import com.qiezi.demo.vo.RequestVo;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import static ratpack.jackson.Jackson.fromJson;
import static ratpack.jackson.Jackson.json;

/**
 * Created by Daniel on 9/23/16.
 */
public class FooHandler implements Handler {
    @Override
    public void handle(Context ctx) throws Exception {
        ctx.render(ctx.parse(fromJson(RequestVo.class)).map(p -> json(new People(p.getName(), 23))));
    }
}
