//package com.example.laogong.rabbitMq;
//
//import com.rabbitmq.client.MessageProperties;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class HelloController {
//
//    @Autowired
//    private AmqpTemplate rabbitTemplate;
//
//    @RequestMapping("/send/{message}}")
//    public String sendMessage(@PathVariable String message){xx
//
//        rabbitTemplate.convertAndSend("myex","direct.biz.ex",message);
//        return "OK";
//    }
//}
