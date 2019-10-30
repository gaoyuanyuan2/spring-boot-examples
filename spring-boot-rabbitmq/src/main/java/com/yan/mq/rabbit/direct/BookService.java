package com.yan.mq.rabbit.direct;


import com.yan.mq.rabbit.object.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    //  自动监听接受消息
    @RabbitListener(queues = "bookQueue")
    public void receive(Book book) {
        System.out.println("收到消息：" + book);
    }

    @RabbitListener(queues = "bookQueue")
    public void receive02(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
