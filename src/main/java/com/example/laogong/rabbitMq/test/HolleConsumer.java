package com.example.laogong.rabbitMq.test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.GetResponse;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class HolleConsumer {

    // 拉消息模式
    public static void main(String[] args) throws URISyntaxException, NoSuchAlgorithmException, KeyManagementException, IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();

        //指定协议 amqp://
        // 用户名 root
        // 密码 123456
        // host node1
        // 端口号 5672
        // 虚拟主机 %2f
        factory.setUri("amqp://root:123456@node1:5672/%2f");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // 声明消息队列 确保存在 消息队列名称 是否持久化 是否排他 是否自动删除 消息队列的属性信息使用默认值
        channel.queueDeclare("queue.biz",false,false,true,null);

        // 监听消息 有消息推送 就调用第一个lambda表达式
        channel.basicConsume("queue.biz",(consumerTag,message) -> {
            System.out.println(new String(message.getBody()));
        },(consumerTage) -> {});

        // 拉消息模式
        // 指定从哪个消费者消费消息 是否自动确认消息
        GetResponse getResponse = channel.basicGet("queue.biz", true);

        byte[] body = getResponse.getBody();
        System.out.println(new String(body));

        channel.close();
        connection.close();

    }
}
