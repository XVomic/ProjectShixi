package com.hd.controller;

import com.hd.commons.PlatformResponse;
import com.hd.commons.ResponseCode;
import com.hd.mapper.UserMapper;
import com.hd.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    UserMapper userMapper;

    //  http://localhost:8989/todo/user/login
    @PostMapping("/login")
    public PlatformResponse Login(@RequestBody User user){
        User quser = userMapper.queryUserByUsernameAndPassword(user);
        if(quser != null){
            return PlatformResponse.success(ResponseCode.SYS_SUCCESS.getCode(),"用户信息成功",quser);
        }
        return PlatformResponse.failure(ResponseCode.SYS_FAILURE.getCode(),"用户名或密码错误");
    }

    @GetMapping("/selectUser/{id}")
    public PlatformResponse selectUser(@PathVariable("id") int id) {
        User user = new User();
        user.setId(id);
        user.setUsername("zz");
        user.setPassword("123456");
        return PlatformResponse.success(user);
    }

    //  http://localhost:8989/todo/user/insertUser
    @PostMapping("/insertUser")
    public PlatformResponse insertUser(@RequestBody User user) {
        int result = this.userMapper.addUser(user);
        if (result <= 0) {
            return PlatformResponse.failure(ResponseCode.OPERATE_DATA_FAILURE.getCode(), ResponseCode.OPERATE_DATA_FAILURE.getMessage());
        }
        return PlatformResponse.success(ResponseCode.OPERATE_DATA_SUCCESS.getCode(), ResponseCode.OPERATE_DATA_SUCCESS.getMessage());
    }

    //  http://localhost:8989/todo/user/updatePass
    @PostMapping("/updatePass")
    public PlatformResponse updatePassword(@RequestBody User user) {
        int result = this.userMapper.updatePassword(user);
        if (result <= 0) {
            return PlatformResponse.failure(ResponseCode.OPERATE_DATA_FAILURE.getCode(), ResponseCode.OPERATE_DATA_FAILURE.getMessage());
        }
        return PlatformResponse.success(ResponseCode.OPERATE_DATA_SUCCESS.getCode(), ResponseCode.OPERATE_DATA_SUCCESS.getMessage());
    }

    //  http://localhost:8989/todo/user/updateName
    @PostMapping("/updateName")
    public PlatformResponse updateUsername(@RequestBody User user) {
        int result = this.userMapper.updateUsername(user);
        if (result <= 0) {
            return PlatformResponse.failure(ResponseCode.OPERATE_DATA_FAILURE.getCode(), ResponseCode.OPERATE_DATA_FAILURE.getMessage());
        }
        return PlatformResponse.success(ResponseCode.OPERATE_DATA_SUCCESS.getCode(), ResponseCode.OPERATE_DATA_SUCCESS.getMessage(),userMapper.queryById(user.getId()));
    }

    //  http://localhost:8989/todo/user/updateSign
    @PostMapping("/updateSign")
    public PlatformResponse updatePersign(@RequestBody User user) {
        int result = this.userMapper.updatePersign(user);
        if (result <= 0) {
            return PlatformResponse.failure(ResponseCode.OPERATE_DATA_FAILURE.getCode(), ResponseCode.OPERATE_DATA_FAILURE.getMessage());
        }
        return PlatformResponse.success(ResponseCode.OPERATE_DATA_SUCCESS.getCode(), ResponseCode.OPERATE_DATA_SUCCESS.getMessage(),userMapper.queryById(user.getId()));
    }



}
