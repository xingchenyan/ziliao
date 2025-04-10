package com.example.seate_demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SeateDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(SeateDemo1Application.class, args);
    }

}
