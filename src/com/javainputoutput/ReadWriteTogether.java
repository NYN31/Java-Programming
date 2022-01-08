package com.javainputoutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class ReadWriteTogether {
    public static void main(String[] args){
        File sourceFile = new File("newFile.txt");
        File sinkFile = new File("newHello1.txt");
        copy(sourceFile, sinkFile);
    }

    public static void copy(File sourceFile, File sinkFile){
        if(!sourceFile.exists() || !sinkFile.exists()){
            System.out.println("Source or destination file doesn't exist");
            return;
        }

        try(FileChannel srcChannel = new FileInputStream(sourceFile).getChannel();
            FileChannel sinkChannel = new FileOutputStream(sinkFile).getChannel()){

            srcChannel.transferTo(0, srcChannel.size(), sinkChannel);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
