package com.javainputoutput;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamExample {
    public static void main(String[] args){
        String destFile = "newHello1.txt";
        String data = "Hello there!";

        try{
            FileOutputStream fos = new FileOutputStream(destFile);
            fos.write(data.getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
