package com.example.ioc;

import com.example.aop.Animal;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * IOC和DI实际上描述的是同一件事（对象实例化及依赖关系维护这件事情），只不过角度不同
 *
 * IOC是站在对象的角度，对象实例化的权限交给（反转）给了容器
 *
 * DI是站在容器的角度，容器会把对象依赖的其他对象注入，比如A对象实例化过程中因为声明了一个B类型的属性，那么就需要容器把B注入给A
 *
 *IOC高级特性懒加载：lazy-init:延迟加载：false=立即加载，表示在spring启动时，立即实例化。
 *  设置<bean id="beanName" class="com.example.aop.Animal" lazy-init="true"/>的bean不会在spring启动时实例化，而是第一次向容器通过getBean索取bean时才会实例化的
 *
 *  如果一个设置了立即加载的bean引用了一个设置了延迟加载的bean那么bean在立即实例化时，由于延迟加载bean被引用所以也会立即实例化
 *
 *  spring是通过三级缓存解决循环依赖的
 */
public class IocCode {

    @Test
    public void test(){
        // ApplicationContext 指spring容器，是spring容器的抽象接口。
        // ClassPathXmlApplicationContext 是ApplicationContext的具体实现，主要用于加载xml配置文件来初始化spring容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Animal animal = applicationContext.getBean(Animal.class);

        animal.eat();
    };
}
