package com.example.seate;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * seate:
 *  AT模式：无入侵的分布式事务解决方案，AT模式下用户只需要关注自己的业务sql，用户的业务sql作为一阶段，seate框架会自动生成事务的二阶段提交和回滚操作。
 *      TM：(事务的发起者)开启全局事务@GlobalTransactional的服务称之为TM。
 *      RM：设置数据源代理，操作分支事务数据库的服务称之为RM。AT模式在RM端需要UNDO_LOG表，来记录每个RM的事务信息，主要包含数据修改前，后的相关信息，用于回滚处理，所以在所有分布式事务相关数据库中分别执行UNDO_LOG表的创建
 *
 *  TCC模式：需要用户根据自己的业务场景实现Try、Confirm、Cancel三个操作；事务发起方在第一阶段执行Try方式，二阶段提交执行Confirm方法，二阶段回滚执行Cancel方法
 *      Try：资源的检查和预留
 *      Confirm：执行的业务操作提交；要求Try成功Confirm一定要能成功
 *      Cancel：预留资源释放
 *  SAGA模式：是seata开源的长事务解决方案，saga模式下，分布式事务内有多个参与者，每一个参与者都是一个冲正补偿服务，需要用户根据业务场景实现正向操作和逆向回滚操作
 *      
 */
@SpringBootApplication
public class SeateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeateApplication.class, args);
    }

}
