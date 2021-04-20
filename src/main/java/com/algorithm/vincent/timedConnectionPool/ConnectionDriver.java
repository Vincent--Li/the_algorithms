package com.algorithm.vincent.timedConnectionPool;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class ConnectionDriver {

    static class ConnectionHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if(method.getName().equals("commit")){
//                System.out.println(Thread.currentThread().getName() + " go to sleep for 100 mills");
                TimeUnit.MILLISECONDS.sleep(100);
            }
            return null;
        }
    }

    public static final Connection createConnection(){
        return (Connection) Proxy.newProxyInstance(
                ConnectionDriver.class.getClassLoader(),
                new Class[]{Connection.class},
                new ConnectionHandler()
        );
    }
}
