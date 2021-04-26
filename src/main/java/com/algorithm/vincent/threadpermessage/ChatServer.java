package com.algorithm.vincent.threadpermessage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



/**
 * @author by zhiyuan.li@hand-china.com
 */
public class ChatServer {

//    private final int port;
//
//    private ThreadPool threadPool;
//
//    private ServerSocket serverSocket;
//
//    public ChatServer(int port){
//        this.port = port;
//    }
//
//    public ChatServer(){
//        this(13312);
//    }
//
//    public void startServer() throws IOException {
//        this.threadPool = new DefaultThreadPool();
//        this.serverSocket = new ServerSocket(port);
//        this.serverSocket.setReuseAddress(true);
//        System.out.println("Chat server is started and listen at port: " + port);
//        this.listen();
//    }
//
//    private void listen() throws IOException {
//        for(;;){
//            Socket client = serverSocket.accept();
//            this.threadPool.execute(new ClientHandler(client));
//        }
//    }
}
