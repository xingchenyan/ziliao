package com.example.laogong.threadcode.threadSixStates;


/**
 * 线程的3种状态
 */
public class NewRunnableTerminated implements Runnable{
    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTerminated());
        //new状态 已创建未执行 未调用start
        System.out.println(thread.getState());
        thread.start();
        //runnable状态 已就绪 调用start方法前
        System.out.println(thread.getState());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //runnable状态 调用start方法后
        System.out.println(thread.getState());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //terminated状态 线程已结束 不管是否正常结束
        System.out.println(thread.getState());
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
