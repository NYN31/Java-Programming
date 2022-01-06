package com.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Thread145 {
    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Executor executor = Executors.newFixedThreadPool(10);

        while(true){
            Socket connection = serverSocket.accept();

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    //serverRequest(connection);
                }
            });
        }
    }
}
