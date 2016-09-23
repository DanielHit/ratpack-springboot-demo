package com.qiezi.demo;

import com.qiezi.demo.action.RouterChain;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ratpack.server.RatpackServer;
import ratpack.server.ServerConfig;

/**
 * Created by Daniel on 9/22/16.
 */
@SpringBootApplication
public class Application {

    public static void main(String... args) throws Exception {
        RatpackServer.start(server -> server
                .serverConfig(ServerConfig.embedded().port(8080))
                .registryOf(registry -> registry.add("World!"))
                .handlers(
                        new RouterChain()
                )
        );

    }

}