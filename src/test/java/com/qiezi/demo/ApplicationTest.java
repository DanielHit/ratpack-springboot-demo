package com.qiezi.demo;

import com.qiezi.demo.handler.FooHandler;
import org.junit.Test;
import ratpack.http.client.ReceivedResponse;
import ratpack.test.embed.EmbeddedApp;

import static org.junit.Assert.assertTrue;

/**
 * Created by Daniel on 9/23/16.
 */
public class ApplicationTest  {

    @Test
    public void name() throws Exception {
        EmbeddedApp.fromHandler(new FooHandler()).test(
                testHttpClient -> {
                    ReceivedResponse response = testHttpClient.get("bar");
                    System.out.println(response.getHeaders().get("Content-type"));
                    assertTrue(response.getHeaders().get("Content-type").startsWith("json"));
                }
        );
    }
}