package com.algorithm.vincent.factoryexample.entity;

/**
 * @author by zhiyuan.li@hand-china.com
 * 当有多个实现类的时候, 我们可以通过工厂方法, 将生成对象的case方法隐藏起来
 */
public abstract class Employee {
    public abstract boolean isPayDay();
    public abstract Money calculatePay();
    public abstract void deliverPay(Money pay);
}
