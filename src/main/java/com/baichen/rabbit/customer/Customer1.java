package com.baichen.rabbit.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Program: Customer1
 * @Author: baichen
 * @Description: 消费者
 */
@Component
@RabbitListener(queues = "baichen")
public class Customer1 {
    @RabbitHandler
    public void showMessage(String message) {
        System.out.println("队列baichen接收到消息:" + message);
    }
}
