package com.example.laogong.threadcode.createThreadMeothd;

public class ThreadStyle extends Thread{

    public static void main(String[] args) {
        new ThreadStyle().start();
    }

    @Override
    public void run() {
        System.out.println("你好,用thread方法的多线程");
    }
}
