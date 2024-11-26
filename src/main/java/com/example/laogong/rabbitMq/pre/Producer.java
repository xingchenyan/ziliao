package com.example.laogong.rabbitMq.pre;

import com.example.laogong.rabbitMq.pre.Money;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    // 队列
    private BlockingQueue<Money> queue;

    // 编号
    private int index = 0;

    public Producer(BlockingQueue<Money> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                if (queue.remainingCapacity() <= 0) {
                    System.out.println("百元大钞放不下拉。");
                } else {
                    Thread.sleep(100);
                    Money money = new Money();
                    money.setId(index++);
                    money.setMany(100);
                    System.out.println("给了" + index + "张。");
                    queue.put(money);
                    System.out.println("已经给了" + queue.size() + "张百元大钞。");
                }
            } catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
}
