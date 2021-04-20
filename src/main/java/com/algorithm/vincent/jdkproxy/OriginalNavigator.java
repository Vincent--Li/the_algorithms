package com.algorithm.vincent.jdkproxy;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class OriginalNavigator implements Navigator{
    @Override
    public String navigate(String source, String destination) {
        System.out.println("originalNavigator is navigating");
        return "navigate from " + source + " to " + destination;
    }
}
