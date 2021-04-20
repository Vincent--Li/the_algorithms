package com.algorithm.vincent.jdkproxy;

import javax.xml.transform.Result;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class NavigationHandler implements InvocationHandler {

    private OriginalNavigator originalNavigator;

    public NavigationHandler(OriginalNavigator originalNavigator) {
        this.originalNavigator = originalNavigator;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before the navigation, I'd like to check the car status");
        Object result = null;
        if(method.getName().equals("navigate")){
            result = method.invoke(originalNavigator, args);
        }
        System.out.println("after the navigation, I'd like to charge for the car");
        return result;
    }
}
