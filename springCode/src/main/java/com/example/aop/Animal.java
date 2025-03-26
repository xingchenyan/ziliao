package com.example.aop;

import org.springframework.stereotype.Component;

@Component
public class Animal {
    private String height; //高度
    private float weight; // 体重

    public void eat(){

        //业务逻辑代码
        System.out.println("i can eat...");
    }

    public void run(){

        //业务逻辑代码
        System.out.println("i can run...");
    }

}
