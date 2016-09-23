package com.qiezi.demo;

import ratpack.exec.Blocking;
import ratpack.server.RatpackServer;

/**
 * Created by Daniel on 9/23/16.
 */
public class BlockingGetTest {

    public static void main(String[] args) throws Exception {
        RatpackServer.start(server ->
                server.handlers(chain ->
                        chain.get(ctx -> Blocking.get(() -> {
                            Thread.sleep(5000);
                            return "Hello World";
                        }).then(str -> ctx.render(str)))
                )
        );
    }

}
