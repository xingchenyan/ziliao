package com.laogong.config;

import com.laogong.pojo.SimpleBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass//当类路径下有指定的类的情况下，就会进行自动装配 不指定具体的类就没有限制前提条件
public class MyAutoConfiguration {

    static {
        System.out.println("MyAutoConfiguration init........");
    }

    @Bean
    public SimpleBean simpleBean(){
        return new SimpleBean();
    }
}
