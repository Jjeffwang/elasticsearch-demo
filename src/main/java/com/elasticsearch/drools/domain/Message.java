package com.elasticsearch.drools.domain;

/**
 * Created with IDEA
 * author:wang
 * Date:2018/8/23 0023 上午 9:39
 * Description:
 */
public class Message {

    public static final Integer HELLO = 0;
    public static final Integer GOODBYE = 1;

    private String message;

    private Integer status;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
