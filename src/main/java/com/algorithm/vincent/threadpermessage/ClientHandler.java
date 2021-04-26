package com.algorithm.vincent.threadpermessage;

import java.io.*;
import java.net.Socket;

/**
 * @author by zhiyuan.li@hand-china.com
 */
public class ClientHandler implements Runnable {

    private final Socket socket;

    private final String clientIdentify;

    public ClientHandler(final Socket socket){
        this.socket = socket;
        this.clientIdentify = socket.getInetAddress().getHostAddress() + ":" + socket.getPort();
    }

    @Override
    public void run() {
        try {
            this.chat();
        } catch (IOException e){
            e.printStackTrace();;
        }
    }

    private void chat() throws IOException  {
        BufferedReader bufferedReader = wrap2Reader(this.socket.getInputStream());
        PrintStream printStream = wrap2Print(this.socket.getOutputStream());
        String received;
        while((received = bufferedReader.readLine()) != null){
            System.out.printf("client:%s-message:%s\n", clientIdentify, received);
            if(received.equals("quit")){
                write2Client(printStream, "client will close");
                socket.close();
                break;
            }

            write2Client(printStream, "Server: "+ received);
        }
    }

    private BufferedReader wrap2Reader(InputStream inputStream){
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    private PrintStream wrap2Print(OutputStream outputStream){
        return new PrintStream(outputStream);
    }

    private void write2Client(PrintStream printStream, String message){
        printStream.println(message);
        printStream.flush();
    }
}
