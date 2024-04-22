package com.example.laogong.threadcode.threadSixStates;

/**
 * 线程的3种状态
 */
public class BlockIngWaitingTimedWating implements Runnable{
    public static void main(String[] args) {
        BlockIngWaitingTimedWating wating = new BlockIngWaitingTimedWating();
        Thread thread1 = new Thread( wating);
        thread1.start();
        Thread thread2 = new Thread( wating);
        thread2.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //timedWating状态 因为该线程在调用Thread.sleep()
        System.out.println(thread1.getState());
        //blocked状态 因为该线程未拿到锁 在阻塞等待的状态
        System.out.println(thread2.getState());
        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //waiting状态 因为调用了wait()方法
        System.out.println(thread1.getState());

    }

    @Override
    public void run() {
        sync();
    }

    private synchronized void sync() {
        try {
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
