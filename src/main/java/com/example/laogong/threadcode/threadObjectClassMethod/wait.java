package com.example.laogong.threadcode.threadObjectClassMethod;

public class wait {
    static Object object = new Object();

    static class Thread1 extends Thread{
        @Override
        public void run() {
            System.out.println("线程"+ Thread.currentThread().getName()+"开始执行了");

            synchronized (object){
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("线程"+Thread.currentThread().getName()+"获取到了锁");
            }

        }
    }

    static class Thread2 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                object.notify();
                System.out.println("线程"+Thread.currentThread().getName()+"唤醒了线程");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 =new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        Thread.sleep(200);
        thread2.start();
    }
}
