package com.luv2code.springboot.curddemo.service;

public class Factorial {

    public static void main(String[] args) {
        int i= fact(4);
        System.out.println(i);
    }
    public static int fact(int num){

        if(num >= 1)
            return num * fact(num-1);
        return 1;
    }
}
