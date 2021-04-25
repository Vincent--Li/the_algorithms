package com.algorithm.vincent.threadcommunication;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author by zhiyuan.li@hand-china.com
 * 基于管道流的通信方式, JDK提供了 PipedWriter/PipedReader, PipedOutputStream/PipedInputStream
 * 其中, 前两个是基于字符的, 后两个是基于字节流的
 */
public class PipeDemo {
    static class ReaderThread implements Runnable {
        private PipedReader reader;

        public ReaderThread(PipedReader reader){
            this.reader = reader;
        }

        @Override
        public void run() {
            System.out.println("this is reader");
            int receive = 0;
            try {
                while((receive = reader.read()) != -1){
                    System.out.println((char)receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class WriterThread implements Runnable{
        private PipedWriter writer;

        public WriterThread(PipedWriter writer){
            this.writer = writer;
        }

        @Override
        public void run() {
            System.out.println("this is writer");
            int receive = 0;
            try {
                writer.write("test");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();
        writer.connect(reader);

        new Thread(new ReaderThread(reader)).start();
        Thread.sleep(1000);
        new Thread(new WriterThread(writer)).start();
    }
}
