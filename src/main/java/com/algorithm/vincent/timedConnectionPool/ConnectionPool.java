package com.algorithm.vincent.timedConnectionPool;

import java.sql.Connection;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class ConnectionPool {
    private ConcurrentLinkedQueue<Connection> pool = new ConcurrentLinkedQueue<>();
    public ConnectionPool(int initialSize){
        if(initialSize > 0){
            for(int i = 0; i< initialSize; i++){
                pool.offer(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connection){
        if(connection != null){
            synchronized (pool){
                pool.offer(connection);
                pool.notifyAll();
            }
        }
    }

    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool){
            if(mills <= 0){
                while(pool.isEmpty()){
                    pool.wait();
                }
                return pool.poll();
            }else{
                final long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                while(pool.isEmpty() && remaining > 0){
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;
                if(!pool.isEmpty()){
                    result = pool.poll();
                }
                return result;
            }
        }
    }
}
