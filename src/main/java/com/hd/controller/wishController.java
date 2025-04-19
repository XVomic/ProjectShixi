package com.hd.controller;

import com.hd.commons.PlatformResponse;
import com.hd.commons.ResponseCode;
import com.hd.mapper.UserMapper;
import com.hd.mapper.WishMapper;
import com.hd.model.User;
import com.hd.model.Wish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wish")
public class wishController {
    @Autowired
    WishMapper wishMapper;

    //  http://localhost:8989/todo/wish/add
    @PostMapping("/add")
    public PlatformResponse addWish(@RequestBody Wish wish){
        int row = wishMapper.addWish(wish);
        if(row>0){
            return PlatformResponse.success(ResponseCode.OPERATE_DATA_SUCCESS.getCode(),"添加愿望成功",wishMapper.queryLastInsert());
        }
        return PlatformResponse.failure(ResponseCode.OPERATE_DATA_FAILURE.getCode(),"添加愿望失败");
    }

    //  http://localhost:8989/todo/wish/queryAll
    @PostMapping("/queryAll")
    public PlatformResponse queryAllWish(User user){
        List<Wish> allwish= wishMapper.queryAllWish();
        if(allwish != null){
            return PlatformResponse.success(ResponseCode.SYS_SUCCESS.getCode(),"数据查询成功",allwish);
        }
        return PlatformResponse.failure(ResponseCode.SYS_FAILURE.getCode(),"数据查询失败");
    }
}
