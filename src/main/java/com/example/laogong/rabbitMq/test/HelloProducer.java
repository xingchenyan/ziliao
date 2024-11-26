package com.example.laogong.rabbitMq.test;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class HelloProducer {

    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取链接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 设置主机名 hostname
        factory.setHost("node1");
        // 设置虚拟主机名称 /在url中的转义字符 %2f
        factory.setVirtualHost("/");
        // 用户名
        factory.setUsername("root");
        // 密码
        factory.setPassword("123456");
        // amqp的端口号
        factory.setPort(5672);

        // 建立TCp连接
        Connection connection = factory.newConnection();
        // 获取通道
        Channel channel = connection.createChannel();

        // 声明消息队列 消息队列名称 是否持久化 是否排他 是否自动删除 消息队列的属性信息使用默认值
        channel.queueDeclare("queue.biz",false,false,true,null);

        //声明交换器 交换器名称 交换器类型 是否持久化 是否自动删除 交换器的属性map集合
        channel.exchangeDeclare("ex.biz", BuiltinExchangeType.DIRECT,false,false,null);

        //将交换器和消息队列绑定，并指定路由键
        channel.queueBind("queue.biz","ex.biz","holle world");

        // 发送消息 交换器的名字 路由键 属性basicproperties对象 消息的字节数组
        channel.basicPublish("ex.biz","holle world",null,"holle world 1".getBytes());
        channel.close();
        connection.close();

    }
}
