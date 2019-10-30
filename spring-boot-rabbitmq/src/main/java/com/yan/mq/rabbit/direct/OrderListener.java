package com.yan.mq.rabbit.direct;


import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Created by yan on  08/06/2018.
 */
@Service
public class OrderListener {

    @RabbitListener(queues = "#{orderNotifyQueue.name}")
    public void onMessage(Message message, Channel channel) throws Exception {
        String msg = new String(message.getBody(), "utf-8");
    }

}
