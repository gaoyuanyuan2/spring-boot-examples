package com.yan.demo.webflux;

import com.yan.demo.dao.UserDao;
import com.yan.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by yan on  28/10/2019.
 */
@RestController
public class UserController
{
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Autowired
    private UserDao userDao;


    @PostMapping( "/saveUser")
    public boolean test(@RequestBody @Valid User user) throws ExecutionException, InterruptedException
    {
        Future<Boolean> res = executorService.submit(()->userDao.save(user));
        return res.get();
    }
}
