package com.algorithm.vincent.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class MyClassLoaderTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        MyClassLoader classLoader = new MyClassLoader();
        Class<?> aClass = classLoader.loadClass("com.example.HelloWorld");
        System.out.println(aClass.getClassLoader());

        // 此处生成第一个实例的时候, 才会主动初始化类的内容;
        // 仅仅通过类加载器加载类, 并不会触发类的初始化过程
        Object helloWorld = aClass.newInstance();
        System.out.println(helloWorld);
        Method welcomeMethod = aClass.getMethod("welcome");
        String result = (String)welcomeMethod.invoke(helloWorld);
        System.out.println("Result: " + result);
    }
}
