package com.qiezi.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Daniel on 9/23/16.
 */
public class RequestVo {

    private final String name;

    public RequestVo(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
