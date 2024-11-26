package com.example.laogong.rabbitMq.pre;


import com.example.laogong.rabbitMq.pre.Comsumer;
import com.example.laogong.rabbitMq.pre.Money;
import com.example.laogong.rabbitMq.pre.Producer;
import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 1.项目中为什么要使用消息中间件
 * 2.项目中为什么使用rocketmq而不是rabbitmq
 * 3.TPS有多少，会不会撑爆
 * 4.出现大量消息堆积会有什么后果
 * 5.如何发现大量消息堆积？有什么措施？问题根源是什么？怎么避免
 *
 * -------------使用场景-------------------
 * 异步处理、流量削峰、限流、缓冲、排队、最终一致性、消息驱动等场景
 */
public class RabbitMqTest {

    /**
     * 自定义消息中间件 通过java代码实现生产者消费者模式
     */
    @Test
    public static void main(String[] args) {
        BlockingQueue<Money> queue = new ArrayBlockingQueue<>(5);
        new Thread(new Producer(queue)).start();
        new Thread(new Comsumer(queue)).start();

    }

}
