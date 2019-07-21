package com.baichen.test;

import com.baichen.rabbit.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Program: MqTest
 * @Author: baichen
 * @Description: 测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)        // 指定一个入口,可以指定配置文件
public class MqTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //    直接模式
    @Test
    public void testSend() {
        rabbitTemplate.convertAndSend("baichen", "直接模式消息发送");
    }

    //    分列模式
    @Test
    public void testSendFanout() {
        rabbitTemplate.convertAndSend("dongyang", "", "分列模式走起");
    }

    //    主题模式
    @Test
    public void testSendTopic1() {
        rabbitTemplate.convertAndSend("baichen_topic", "goods.aaa", "主题模式匹配1");
    }
    @Test
    public void testSendTopic2(){
        rabbitTemplate.convertAndSend("baichen_topic","article.content.log","主题模式匹配2");
    }
    @Test
    public void testSendTopic3(){
        rabbitTemplate.convertAndSend("baichen_topic","goods.log","主题模式匹配3");
    }
}
