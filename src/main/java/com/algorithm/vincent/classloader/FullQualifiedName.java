package com.algorithm.vincent.classloader;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class FullQualifiedName {

    class InnerClass {

    }

    interface Anonymous {
        void test();
    }

    public static void main(String[] args) {
        System.out.println(InnerClass.class.getName());
        System.out.println(new Anonymous() {
            @Override
            public void test() {
                System.out.println("TEST");
            }
        }.getClass().getName());
        System.out.println((Anonymous)()->{
            System.out.println("TEST");
        });
    }
}
