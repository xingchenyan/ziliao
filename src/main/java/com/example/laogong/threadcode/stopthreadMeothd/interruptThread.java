package com.example.laogong.threadcode.stopthreadMeothd;

public class interruptThread implements Runnable{
    //没有sleep和wait的情况下停止线程
    @Override
    public void run() {
        Integer num = 0;
        while( !Thread.currentThread().isInterrupted() && num <= Integer.MAX_VALUE){
            //取余
            if((num % 10000) == 0){
                System.out.println(num);
            }
            num++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new interruptThread());
        thread.start();
        Thread.sleep(1000);
        //需要线程做出配合，这是通知不是强制中断
        //没有sleep和wait的情况下停止线程,有的情况下线程在阻塞中时需要catch异常才能响应中断，sleep过程中收到中断通知响应异常后会清楚中断通知标记
        thread.interrupt();
    }
}
