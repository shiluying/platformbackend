package com.shiluying.platformbackend.controller;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.entity.User;
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
    @RequestMapping(value = "/findAllUser",method = RequestMethod.GET)
    public ServerResponse findAllUser() {
        return userService.findAllUser();
    }

    // 确认用户存在
    @RequestMapping(value = "/checkUser",method = RequestMethod.GET)
    public ServerResponse checkUser(@RequestParam("email") String email,@RequestParam("pwd") String pwd) {
        return userService.checkUser(email,pwd);
    }
    // 确认管理用户存在
    @RequestMapping(value = "/checkAdminUser",method = RequestMethod.GET)
    public ServerResponse checkAdminUser(@RequestParam("email") String email,@RequestParam("pwd") String pwd) {
        return userService.checkAdminUser(email,pwd);
    }
    // 修改用户类型
    @RequestMapping(value = "/changeUserType",method = RequestMethod.PUT)
    public ServerResponse changeUserType(@RequestBody User user) {
        System.out.println(user);
        int id= user.getUser_id();
        int type=user.getType();
        return userService.changeUserType(id,type);
    }
    // 修改用户的商品审核权限
    @RequestMapping(value = "/changeUserExamine",method = RequestMethod.PUT)
    public ServerResponse changeUserExamine(@RequestBody User user) {
        int id=user.getUser_id();
        int examine=user.getExamine();
        return userService.changeUserExamine(id,examine);
    }
    // 添加用户
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public ServerResponse addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
    //删除用户
    @RequestMapping(value = "/deleteUser",method = RequestMethod.DELETE)
    public ServerResponse deleteUser(@RequestParam("id") Integer id) {
        return userService.deleteUser(id);
    }
}
