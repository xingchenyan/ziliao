package com.example.laogong.rabbitMq.pre;

import java.util.concurrent.BlockingQueue;

public class Comsumer implements Runnable{

    private BlockingQueue<Money> queue;

    public Comsumer(BlockingQueue<Money> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(200);
                System.out.println("正在拿钱。");
                Money money = queue.take();
                System.out.println("拿了" + money.getId() +"张百元大钞。");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
