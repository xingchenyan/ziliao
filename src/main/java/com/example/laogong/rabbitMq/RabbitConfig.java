//package com.example.laogong.rabbitMq;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//public class RabbitConfig {
//
//    @Bean
//    public Queue myQueue(){
//        return new Queue("myQueue") ;
//    }
//
//    @Bean
//    public Exchange myExchange(){
//        return new DirectExchange("myex",false,false);
//    }
//    // 绑定目的地 绑定类型：到交换器还是队列 交换器名称 路由key 绑定的属性
//    // 绑定了交换器direct.biz.ex到队列myQueue 路由键是direct.biz.ex
//    @Bean
//    public Binding myBinding(){
//        return new Binding(
//                "myQueue",Binding.DestinationType.QUEUE,
//                "myex",
//                "direct.biz.ex",
//                null
//        );
//    }
//}
