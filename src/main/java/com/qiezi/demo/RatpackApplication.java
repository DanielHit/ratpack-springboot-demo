package com.qiezi.demo;

import ratpack.server.RatpackServer;
import ratpack.server.ServerConfig;

/**
 * Created by Daniel on 9/22/16.
 */
public class RatpackApplication {

    public static void main(String... args) throws Exception {
        RatpackServer.start(server -> server
                .serverConfig(ServerConfig.embedded().port(8080))
                .handlers(chain -> chain.get(
                        ctx -> ctx.render("hello")
                ))
        );

    }

}