package com.thread;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Thread140 {
    private static final String DOCUMENT = "" +
            "<html>" +
            "   <head>" +
            "   <title>Single Threaded server</title>" +
            "   </head>" +
            "   <body>" +
            "       <p> It Works! </p>" +
            "   </body>" +
            "</head>";

    private static final String HEADER = "" +
            "HTTP/1.1 200 OK\r\n" +
            "Content-Type: text/html; charset=UTF-8\r\n" +
            "Content-Type: " + DOCUMENT.length() + "\r\n\r\n";

    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while(true){
            Socket connection = serverSocket.accept();
            serverRequest(connection);
        }
    }

    private static void serverRequest(Socket connection){
        System.out.println("New connection request form: " + connection.toString());

        try(OutputStream os = connection.getOutputStream();
            PrintWriter out = new PrintWriter(os)){
            out.write(HEADER);
            out.write(DOCUMENT);
        } catch (IOException e){
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }
    }
}
