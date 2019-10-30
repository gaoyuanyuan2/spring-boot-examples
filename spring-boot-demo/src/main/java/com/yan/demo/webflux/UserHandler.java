package com.yan.demo.webflux;

import com.yan.demo.dao.UserDao;
import com.yan.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
public class UserHandler {

    @Autowired
    private UserDao userDao;

    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        //在Spring Web MVC中使用@RequestBody
        // 在Spring Web F1ux使用ServerRequest
        // Mono<User>类似于Optional<User>
        Mono<User> userMono = serverRequest.bodyToMono(User.class);
        // map相当于转化工作
        Mono<Boolean> booleanMono = userMono.map(userDao::save);
        return ServerResponse.ok().body(booleanMono, Boolean.class);
    }

}
