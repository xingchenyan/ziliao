package com.laogong.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(SimpleBean.class) //开启ConfigurationProperties注解。
@ConfigurationProperties(prefix = "simplebean") //获取配置文件中前缀以‘simplebean’开头的值，按照映射关系封装到当前实例的属性上。或者说，将配置文件转换为bean来使用。
public class SimpleBean {

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
