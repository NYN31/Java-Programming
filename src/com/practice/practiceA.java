package com.practice;

import java.util.Scanner;

public class practiceA {
    public static final Scanner sc = new Scanner(System.in);

    public static void solve() {
        String str = sc.next();
        boolean flag = false;

        if(str.length() % 2 != 0) {
            System.out.println("NO");
            return;
        }
        for(int i=0; i<str.length()/2; i++) {
            if(str.charAt(i) != str.charAt(str.length()/2 + i)) {
                flag = true;
                break;
            }
        }
        if(flag) System.out.println("NO");
        else System.out.println("YES");
    }

    public static void main(String[] args){
        int t = 1, no = 0;
        t = sc.nextInt();
        while(t-- > 0) {
            solve();
        }
    }
}
