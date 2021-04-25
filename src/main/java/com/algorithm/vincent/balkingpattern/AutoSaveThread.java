package com.algorithm.vincent.balkingpattern;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class AutoSaveThread extends Thread{
    private final Document document;

    public AutoSaveThread(Document document ){
        this.document = document;
    }

    @Override
    public void run() {
        while(true){
            try{
                document.save();
                TimeUnit.SECONDS.sleep(10);
            }catch (InterruptedException | IOException ex){
                return;
            }
        }
    }
}
