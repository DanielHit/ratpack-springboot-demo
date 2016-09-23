package com.qiezi.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import ratpack.server.RatpackServer;
import ratpack.server.ServerConfig;

/**
 * Created by Daniel on 9/22/16.
 */
@SpringBootApplication
public class Main {

        public static void main(String... args) throws Exception {

            RatpackServer.start(server -> server
                    .serverConfig(ServerConfig.embedded().port(8080))
                    .registryOf(registry -> registry.add("World!"))
                    .handlers(chain -> chain
                            .get(ctx -> ctx.render("Hello " + ctx.get(String.class)))
                            .get(":name", ctx -> ctx.render("Hello " + ctx.getPathTokens().get("name") + "!"))
                            .get("a", ctx -> ctx.render("fuck"))
                    )
            );

        }

}