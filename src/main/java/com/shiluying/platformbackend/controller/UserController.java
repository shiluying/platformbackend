package com.shiluying.platformbackend.controller;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    // 根据user_id查找用户
    @RequestMapping(value = "/findUserById",method = RequestMethod.GET)
    public ServerResponse findUserById(@RequestParam("id") Integer id) {
        return userService.findUserById(id);
    }

    //查找所有用户
    @RequestMapping(value = "/findAllUser")
    public ServerResponse findAllUser() {
        return userService.findAllUser();
    }

    // 确认用户存在
    @RequestMapping(value = "/checkUser",method = RequestMethod.GET)
    public ServerResponse checkUser(@RequestParam("id") Integer id,@RequestParam("pwd") String pwd) {
        return userService.checkUser(id,pwd);
    }
    // 修改用户类型
    @RequestMapping(value = "/changeUserType",method = RequestMethod.GET)
    public ServerResponse changeUserType(@RequestParam("id") Integer id,@RequestParam("type") Integer type) {
        return userService.changeUserType(id,type);
    }
    // 修改用户的商品审核权限
    @RequestMapping(value = "/changeUserExamineById",method = RequestMethod.GET)
    public ServerResponse changeUserExamineById(@RequestParam("id") Integer id,@RequestParam("examine") Integer examine) {
        return userService.changeUserExamineById(id,examine);
    }
    // 添加用户
    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public ServerResponse addUser(@RequestParam("id") Integer id,@RequestParam("name") String name,
                           @RequestParam("pwd") String pwd,@RequestParam("type") Integer type,
                           @RequestParam("examine") Integer examine) {
        return userService.addUser(id,name,pwd,type,examine);
    }
    //删除用户
    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public ServerResponse deleteUser(@RequestParam("id") Integer id) {
        return userService.deleteUser(id);
    }
}
