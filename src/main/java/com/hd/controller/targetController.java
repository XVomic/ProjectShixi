package com.hd.controller;

import com.hd.commons.PlatformResponse;
import com.hd.commons.ResponseCode;
import com.hd.mapper.TargetMapper;
import com.hd.model.Target;
import com.hd.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Date;

import static java.lang.Math.abs;

@RestController
@RequestMapping("/target")
public class targetController {
    @Autowired
    private TargetMapper targetMapper;

    //    http://localhost:8989/todo/target/add
    @PostMapping("/add")
    public PlatformResponse addTarget(@RequestBody Target target) {
        int row = targetMapper.addTarget(target);
        if (row > 0) {
            return PlatformResponse.success(ResponseCode.OPERATE_DATA_SUCCESS.getCode(), "添加目标成功",targetMapper.queryLastInsert());
        }
        return PlatformResponse.failure(ResponseCode.OPERATE_DATA_FAILURE.getCode(), "添加目标失败");
    }

    //    http://localhost:8989/todo/target/queryAll
    @PostMapping("/queryAll")
    public PlatformResponse queryAllTarget(@RequestBody User user){
        List<Target> alltarget=targetMapper.queryAllTarget(user.getId());
        if(alltarget != null){
            return PlatformResponse.success(ResponseCode.SYS_SUCCESS.getCode(),"查询所有数据成功",alltarget);
        }
        return PlatformResponse.failure(ResponseCode.SYS_FAILURE.getCode(),"查询所有数据失败");
    }

    //后端计算剩余时间
//    //    http://localhost:8989/todo/target/queryAll
//    @PostMapping("/queryAll")
//    public PlatformResponse queryAllTarget(@RequestBody User user){
//        List<Target> alltarget=targetMapper.queryAllTarget(user.getId());
//        if(alltarget != null){
//            List<TargetReturn> targetReturnList = new ArrayList<>();
//
//            Date referenceDate = new Date(); // 设置基准日期为 2024-05-05
//
//            for (Target target : alltarget) {
//                int remainDays = abs(calculateRemainDays(referenceDate, target.getEndDate()));
//                TargetReturn targetReturn = new TargetReturn(target, remainDays);
//                targetReturnList.add(targetReturn);
//            }
//
//            // 打印结果
//            for (TargetReturn targetReturn : targetReturnList) {
//                System.out.println(targetReturn);
//            }
//            return PlatformResponse.success(ResponseCode.SYS_SUCCESS.getCode(),"查询所有数据成功",targetReturnList);
//        }
//        return PlatformResponse.failure(ResponseCode.SYS_FAILURE.getCode(),"查询所有数据失败");
//    }

    //    http://localhost:8989/todo/target/delete
    @PostMapping("/delete")
    public PlatformResponse deleteTarget(@RequestBody Target target){
        int row = targetMapper.deleteTarget(target);
        if (row > 0) {
            return PlatformResponse.success(ResponseCode.OPERATE_DATA_SUCCESS.getCode(), "删除目标成功",targetMapper.queryLastInsert());
        }
        return PlatformResponse.failure(ResponseCode.OPERATE_DATA_FAILURE.getCode(), "删除目标失败");
    }

}

