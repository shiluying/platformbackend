package com.shiluying.platformbackend.controller;

import com.shiluying.platformbackend.entity.User;
import com.shiluying.platformbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/findUser/{id}")
    public User findUser(@PathVariable("id") Integer id) {
        return userService.findUserById(id);
    }
    @GetMapping(value = "/checkUser/{id}/{pwd}")
    public Boolean checkUser(@PathVariable("id") Integer id,@PathVariable("pwd") String pwd) {
        System.out.println(id+"===>"+pwd);
        System.out.println(userService.checkUser(id,pwd));
        return userService.checkUser(id,pwd);
    }

}
