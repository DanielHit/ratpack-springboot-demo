package com.qiezi.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import ratpack.server.RatpackServer;

/**
 * Created by Daniel on 9/22/16.
 */
@SpringBootApplication
public class Main {
    public static void main(String... args) throws Exception {
        RatpackServer.start(server -> server
                .handlers(chain -> chain
                        .get(ctx -> ctx.render("Hello World!"))
                        .get(":name", ctx -> ctx.render("Hello " + ctx.getPathTokens().get("name") + "!"))
                )
        );
    }
}