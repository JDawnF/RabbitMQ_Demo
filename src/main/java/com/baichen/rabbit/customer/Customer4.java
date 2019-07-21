package com.baichen.rabbit.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Program: Customer2
 * @Author: baichen
 * @Description: 消费者2
 */
@Component
@RabbitListener(queues = "baichen_rabbit")
public class Customer4 {
    @RabbitHandler
    public void showMessage(String message) {
        System.out.println("baichen_rabbit接收到消息:" + message);
    }
}
