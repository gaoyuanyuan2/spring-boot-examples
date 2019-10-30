package com.yan.demo.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 *
 题外话:在Spring Boot 2.0.0，如果应用采用Spring Web MVC作为Web服务，默认情况下， 使用嵌入式Tomcat。

 如果采用Spring Web Flux，默认情况下，使用Netty WebServer (嵌入式)

 从Spring Boot 1.4支持FailureAnalysisReporter实现

 WebFlux

 Mono:0- 1 Publisher (类似于Java 8中的Optional)

 Flux: 0- N Publisher ( 类似于Java中的List)

 传统的Servlet采用HttpServletRequest、HttpServletResponse

 WebFlux采用: ServerRequest、 ServerResponse (不再限制于Servlet容器，可以选择自定义实现，比如Netty Web Server)

 **/


@Component
public class WebfluxConfig {

    @Bean
    public RouterFunction<ServerResponse> saveUser(UserHandler userHandler) {
        return route(POST("/web/flux/user/save"), userHandler::save);
    }
}
