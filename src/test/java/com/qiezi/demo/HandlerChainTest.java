package com.qiezi.demo;

import ratpack.handling.Handler;
import ratpack.registry.Registry;
import ratpack.server.RatpackServer;

import java.util.ArrayList;
import java.util.List;

import static ratpack.jackson.Jackson.json;

/**
 * Created by Daniel on 9/23/16.
 */
public class HandlerChainTest {

    public static void main(String[] args) throws Exception {
        new HandlerChainTest().start();
    }

    public void start() throws Exception {
        RatpackServer.start(server ->
                server.registry(Registry.single(new ArrayList<String>()))
                        .handlers(chain ->
                                chain.get(ctx -> ctx.insert(
                                        addOutput("Hello"),
                                        addOutput("World"),
                                        ctx3 -> ctx3.render(json(ctx3.get(List.class)))
                                ))
                        )
        );
    }

    private Handler addOutput(final String text) {
        return ctx -> {
            ctx.get(List.class).add(text);
            ctx.next();
        };
    }

}
