package com.javainputoutput;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelWrite {
    public static void main(String[] args){
        String outputFile = "newHello1.txt";
        String text = "I love Bangladesh";

        try{
            FileOutputStream fos = new FileOutputStream(outputFile);
            FileChannel fileChannel = fos.getChannel();

            byte[] bytes = text.getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(bytes);

            fileChannel.write(buffer);
            fileChannel.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
