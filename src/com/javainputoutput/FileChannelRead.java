package com.javainputoutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.TimeUnit;

public class FileChannelRead {
    public final static String FILE = "/home/noyon_admin/Personal/Java/Java-advance-programming/newFile.txt";

    public static void main(String[] args){
        File inputFile = new File(FILE);
        if(!inputFile.exists()){
            System.out.println("The input file doesn't exist!");
        }
        try{
            FileInputStream fis = new FileInputStream(inputFile);
            FileChannel fileChannel = fis.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while(fileChannel.read(buffer) > 0) {
                buffer.flip();

                while(buffer.hasRemaining()){
                    byte b = buffer.get();
                    System.out.print((char) b);
                }
                buffer.clear();

                try{
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                    throw new AssertionError(e);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
