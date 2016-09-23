package com.qiezi.demo.action;

import com.qiezi.demo.handler.BarHandler;
import com.qiezi.demo.handler.FooHandler;
import com.qiezi.demo.handler.HttpHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.handling.Chain;
import ratpack.handling.Handler;
import ratpack.health.HealthCheckHandler;

/**
 * Created by Daniel on 9/23/16.
 */
public class RouterChain implements ratpack.func.Action<Chain> {

    public static final Logger LOGGER = LoggerFactory.getLogger(RouterChain.class);

    Handler fooHandler = new FooHandler();
    Handler barHandler = new BarHandler();
    Handler headHandler = new HeadHandler();

    @Override
    public void execute(Chain chain) throws Exception {
        chain.path("bar", barHandler);

        chain.path(barHandler).get(ctx -> ctx.render(barHandler));

        //
        chain.post("foo", fooHandler);

        // get head
        chain.get("head", headHandler);

        // use healthcheck
        chain.get("api/alive", new HealthCheckHandler());

        // use httpclient
        chain.get("http", new HttpHandler());
    }

}
