package com.shiluying.platformbackend.controller;

import com.shiluying.platformbackend.entity.User;
import com.shiluying.platformbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/findUser/{id}")
    public User findUser(@PathVariable("id") Integer id) {
        return userService.findUserById(id);
    }
    @GetMapping(value = "/findUser")
    public List<User> findUser() {
        return userService.findAllUser();
    }

    @GetMapping(value = "/checkUser/{id}/{pwd}")
    public Boolean checkUser(@PathVariable("id") Integer id,@PathVariable("pwd") String pwd) {
        return userService.checkUser(id,pwd);
    }

    @GetMapping(value = "/changeUserType/{id}/{type}")
    public Boolean changeUserType(@PathVariable("id") Integer id,@PathVariable("type") Integer type) {
        return userService.changeUserType(id,type);
    }

    @GetMapping(value = "/changeUserExamine/{id}/{examine}")
    public Boolean changeUserExamine(@PathVariable("id") Integer id,@PathVariable("examine") Integer examine) {
        return userService.changeUserExamine(id,examine);
    }

    @GetMapping(value = "/addUser/{id}/{name}/{pwd}/{type}/{examine}")
    public Boolean addUser(@PathVariable("id") Integer id,@PathVariable("name") String name,
                           @PathVariable("pwd") String pwd,@PathVariable("type") Integer type,
                           @PathVariable("examine") Integer examine) {
        return userService.addUser(id,name,pwd,type,examine);
    }

    @GetMapping(value = "/deleteUser/{id}")
    public Boolean deleteUser(@PathVariable("id") Integer id) {
        return userService.deleteUser(id);
    }
}
