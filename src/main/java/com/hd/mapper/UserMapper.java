package com.hd.mapper;

import com.hd.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    //登录验证
    User queryUserByUsernameAndPassword(User user);

    //注册用户
    int addUser(User user);

    //用户修改密码
    int updatePassword(User user);

    User queryById(int id);

    //用户修改密码
    int updateUsername(User user);

    int updatePersign(User user);

    int updateImage(User user);
}
