package com.algorithm.vincent.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class NavigatorProxyTest {
    public static void main(String[] args) {
        Navigator enhancedNavigator = (Navigator) Proxy.newProxyInstance(
                OriginalNavigator.class.getClassLoader(),
                new Class[]{ Navigator.class},
                new NavigationHandler(new OriginalNavigator())
        );
        System.out.println(enhancedNavigator.getClass().getName());
        String result = enhancedNavigator.navigate("Shanghai", "Chengdu");
        System.out.println("navigation succeed: " + result);
    }
}
