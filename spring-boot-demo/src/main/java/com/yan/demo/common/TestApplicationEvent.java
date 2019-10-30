package com.yan.demo.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by yan on  26/09/2018.
 */

public class TestApplicationEvent {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.addApplicationListener(
                //监听事件
                (MyApplicationEvent event) -> System.out.println("接收到事件" + event.getSource() + "#" + event
                        .getApplicationContext())
        );
        context.refresh();
        //事件发布
        context.publishEvent(new MyApplicationEvent(context,"Hello World"));
    }

    private static class MyApplicationEvent extends ApplicationEvent
    {

        private final ApplicationContext applicationContext;

        public MyApplicationEvent(ApplicationContext applicationContext, Object source) {
            super(source);
            this.applicationContext = applicationContext;
        }

        public ApplicationContext getApplicationContext() {
            return applicationContext;
        }
    }
}
