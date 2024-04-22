package com.example.laogong.threadcode.createThreadMeothd;

public class RunnableStyle implements Runnable{

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }

    /**
     * 实现runnable接口的多线程方式更好，通常不使用继承thread的方式
     * 1.多线程的任务应与多线程创建运行等解耦 从解耦角度 runnable更好
     * 2.thread类的创建就定死了线程类 从而增加了线程的创建和销毁 增加了性能的消耗
     * 3.java是单继承的 继承thread之后就不能继承其他类了 限制了可扩展性
     */

    @Override
    public void run() {
        System.out.println("你好，用runnable方法多线程");
    }
}
