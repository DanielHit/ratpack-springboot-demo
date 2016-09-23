package com.qiezi.demo.handler;

import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.http.client.HttpClient;
import ratpack.server.PublicAddress;

import java.net.URI;

/**
 * Created by Daniel on 9/23/16.
 */
public class HttpHandler implements Handler {
    @Override
    public void handle(Context ctx) throws Exception {
        PublicAddress address = ctx.get(PublicAddress.class);         //find local ip address
        HttpClient httpClient = ctx.get(HttpClient.class);            //get httpClient

        // use httpclient
        URI uri = new URI("http://www.baidu.com");
        httpClient.get(uri).then(response ->
                ctx.render(response.getBody().getText())  //Render the response from the httpClient GET request
        );
    }
}
