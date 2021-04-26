package com.algorithm.vincent.threadpermessage;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class Request {
    private final String business;

    public Request(String business) {
        this.business = business;
    }

    @Override
    public String toString() {
        return business;
    }
}
