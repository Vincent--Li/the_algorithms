package com.algorithm.vincent.singlton;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class DoubleCheckSingleton {

    private volatile Helper helper = null;

    private DoubleCheckSingleton(){}

    public Helper getInstance(){
        if(helper == null){
            synchronized (this){
                if(helper == null){
                    helper = new Helper();
                }
            }
        }
        return helper;
    }
}
