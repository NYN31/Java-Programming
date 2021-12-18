package com.advance.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Stream180 {
    public static void main(String args[]){
        try{
            URL url = new URL("http://example.com/");
            URLConnection conn = url.openConnection();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );
            reader.lines().limit(50).forEach(val -> System.out.println(val));
        } catch (IOException e){
            System.out.println("Message: " + e);
        }
    }
}
