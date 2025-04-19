package com.hd.controller;

import com.hd.commons.PlatformResponse;
import com.hd.commons.ResponseCode;
import com.hd.mapper.RoutineMapper;
import com.hd.model.Routine;
import com.hd.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/list")
public class routineController {

    @Autowired
    RoutineMapper routineMapper;

    // http://localhost:8989/todo/list/add
    @PostMapping("/add")
    public PlatformResponse addRoutine(@RequestBody Routine routine){
        int row = routineMapper.addRoutine(routine);
        if(row>0){
            return PlatformResponse.success(ResponseCode.OPERATE_DATA_SUCCESS.getCode(),"添加待办成功",routineMapper.queryLastInsert());
        }
        return PlatformResponse.failure(ResponseCode.OPERATE_DATA_FAILURE.getCode(),"添加待办失败");
    }

    //  http://localhost:8989/todo/list/queryAll
    @PostMapping("/queryAll")
    public PlatformResponse queryAllRoutine(@RequestBody User user){
        List<Routine> allroutine= routineMapper.queryAllRoutine(user.getId());
        if(allroutine != null){
            return PlatformResponse.success(ResponseCode.SYS_SUCCESS.getCode(),"查询所有数据成功",allroutine);
        }
        return PlatformResponse.failure(ResponseCode.SYS_FAILURE.getCode(),"查询所有数据失败");
    }

    //  http://localhost:8989/todo/list/delete
    @PostMapping("/delete")
    public PlatformResponse deleteRoutine(@RequestBody Routine routine){
        int row=routineMapper.deleteRoutine(routine);
        if(row > 0){
            return PlatformResponse.success(ResponseCode.SYS_SUCCESS.getCode(),"删除待办成功");
        }
        return PlatformResponse.failure(ResponseCode.OPERATE_DATA_FAILURE);
    }
    }

