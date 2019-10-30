package com.yan.demo.controller;

import com.yan.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by yan on  25/09/2018.
 */
@RestController
public class TestController {

    @Autowired
    private Environment environment;

    //json 转对象 要加@RequestBody
    @PostMapping( "/test")
    public User test(@RequestBody @Valid User user) throws InterruptedException
    {
        System.err.println("in");
        TimeUnit.SECONDS.sleep(10);
        System.err.println("out");
        return user;
    }

    @GetMapping("/env/{name}")
    public Map<String ,String> env(@PathVariable String name){
        Map<String ,String> map = new HashMap<>();
        map.put(name,environment.getProperty(name));
        return  map;
    }
}
