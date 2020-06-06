package com.shiluying.platformbackend.serviceImpl;

import com.shiluying.platformbackend.Response.ServerResponse;
import com.shiluying.platformbackend.entity.User;
import com.shiluying.platformbackend.repository.UserRepository;
import com.shiluying.platformbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public ServerResponse findUserById(Integer id) {
        ServerResponse serverResponse;
        User user= userRepository.getOne(id);
        if(user==null){
            serverResponse=ServerResponse.createByErrorMessage("用户不存在");
        }else{
            serverResponse=ServerResponse.createBySuccess("用户存在",user);
        }
        return serverResponse;
    }

    @Override
    public ServerResponse findAllUser() {
        ServerResponse serverResponse;
        List<User> users=userRepository.findAll();
        serverResponse=ServerResponse.createBySuccess(users);
        return serverResponse;
    }

    @Override
    public ServerResponse checkUser(String email, String pwd){

        ServerResponse serverResponse;
        List<User> users = userRepository.findByEmailAndPwd(email,pwd);
        if(users.size()==0){
            serverResponse=ServerResponse.createByErrorMessage("用户不存在");
        }else{
            serverResponse=ServerResponse.createBySuccess("用户存在",users.get(0));
        }
        return serverResponse;
    }

    @Override
    public ServerResponse changeUserType(Integer id, Integer type) {
        ServerResponse serverResponse;
//        确认用户是否存在
        serverResponse=findUserById(id);
        if(serverResponse.getStatus()==500){// 用户不存在
            return serverResponse;
        }else if(serverResponse.getStatus()==200) {// 用户存在， 修改用户类型
            int code= userRepository.updateTypeById(id,type);
            if(code==1){
                serverResponse=ServerResponse.createBySuccessMessage("用户类型修改成功");
            }else{
                serverResponse=ServerResponse.createByErrorMessage("用户类型修改失败");
            }
        }else{
            serverResponse=ServerResponse.createByError();
        }
        return serverResponse;
    }

    @Override
    public ServerResponse changeUserExamine(Integer id, Integer examine) {
        ServerResponse serverResponse;
//        确认用户是否存在
        serverResponse=findUserById(id);
        if(serverResponse.getStatus()==500){// 用户不存在
            return serverResponse;
        }else if(serverResponse.getStatus()==200) {// 用户存在， 修改用户类型
            int code= userRepository.updateExamineById(id,examine);
            if(code==1){
                serverResponse=ServerResponse.createBySuccessMessage("用户类型修改成功");
            }else{
                serverResponse=ServerResponse.createByErrorMessage("用户类型修改失败");
            }
        }else{
            serverResponse=ServerResponse.createByError();
        }
        return serverResponse;
    }

    @Override
    public ServerResponse addUser(User user) {
        ServerResponse serverResponse;
        userRepository.save(user);
        User user_info=userRepository.save(user);
        if(user_info!=null) {
            serverResponse = ServerResponse.createBySuccess("用户添加成功", user_info);
        }else {
            serverResponse = ServerResponse.createByErrorMessage("用户添加失败");
        }
        return serverResponse;
    }

    @Override
    public ServerResponse deleteUser(Integer id) {
        userRepository.deleteById(id);
        ServerResponse serverResponse;
        serverResponse=ServerResponse.createBySuccessMessage("用户删除成功");
        return serverResponse;
    }

    @Override
    public ServerResponse checkAdminUser(String email, String pwd) {
        ServerResponse serverResponse;
        System.out.println(email+"=="+pwd);
        List<User> users = userRepository.findByEmailAndPwd(email,pwd);
        if(users.size()==0){
            serverResponse=ServerResponse.createByErrorMessage("用户不存在");
        }else{
            User user=users.get(0);
            if(user.getExamine()==1||user.getType()==1){
                serverResponse=ServerResponse.createBySuccess("用户存在",user);
            }else{
                serverResponse=ServerResponse.createByErrorMessage("用户不存在");
            }
        }
        return serverResponse;
    }
}
