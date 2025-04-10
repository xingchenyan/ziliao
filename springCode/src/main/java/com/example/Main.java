package com.example;

import com.example.aop.Animal;
import com.example.aop.AopCode;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");
    }

    // aop测试方法
    @Test
    public void test(){
        // ApplicationContext 指spring容器，是spring容器的抽象接口。
        // ClassPathXmlApplicationContext 是ApplicationContext的具体实现，主要用于加载xml配置文件来初始化spring容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Animal animal = applicationContext.getBean(Animal.class);

        animal.eat();
    };
}