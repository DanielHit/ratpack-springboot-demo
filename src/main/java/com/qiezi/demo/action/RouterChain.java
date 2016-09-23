package com.qiezi.demo.action;

import com.qiezi.demo.handler.BarHandler;
import com.qiezi.demo.handler.FooHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.handling.Chain;
import ratpack.handling.Handler;

/**
 * Created by Daniel on 9/23/16.
 */
public class RouterChain implements ratpack.func.Action<Chain> {

    public static final Logger LOGGER = LoggerFactory.getLogger(RouterChain.class);

    Handler fooHandler = new FooHandler();
    Handler barHandler = new BarHandler();

    @Override
    public void execute(Chain chain) throws Exception {
        LOGGER.info("enter 1");
        chain.path("foo", fooHandler);
        LOGGER.info("enter 2");
        chain.path("bar", barHandler);
        LOGGER.info("enter 3");
        chain.path(barHandler).get(ctx -> ctx.render(barHandler));
    }

}
