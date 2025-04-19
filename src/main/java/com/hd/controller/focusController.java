package com.hd.controller;

import com.hd.commons.PlatformResponse;
import com.hd.commons.ResponseCode;
import com.hd.mapper.FocusMapper;
import com.hd.model.Datastatic;
import com.hd.model.Focus;
import com.hd.model.Periodstatic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/focus")
public class focusController {

    @Autowired
    FocusMapper focusMapper;

//    LocalDate date = LocalDate.of(2023, 12, 13);

    // http://localhost:8989/todo/focus/add
    @PostMapping("/add")
    public PlatformResponse addFocus(@RequestBody Focus focus){
        int row = focusMapper.addFocus(focus);
        if(row>0){
            return PlatformResponse.success(ResponseCode.OPERATE_DATA_SUCCESS.getCode(),"专注记录成功");
        }
        return PlatformResponse.failure(ResponseCode.OPERATE_DATA_FAILURE.getCode(),"专注记录失败");
    }

    // http://localhost:8989/todo/focus/query
    @PostMapping("/query")
    public PlatformResponse queryTotal(@RequestBody Focus focus){
        Datastatic data = focusMapper.queryTotal(focus.getUserID());
        data.setTodayRecords(focusMapper.queryTodayRecords(focus));
        data.setTodayTotaltime(focusMapper.queryTodayTotalTime(focus));
        data.setAveDailytime(data.getTotalTime()/data.getTotalDays());
        if(data != null){
            return PlatformResponse.success(ResponseCode.OPERATE_DATA_SUCCESS.getCode(),"专注统计成功",data);
        }
        return PlatformResponse.failure(ResponseCode.OPERATE_DATA_FAILURE.getCode(),"专注统计失败");
    }

    // http://localhost:8989/todo/focus/querytoday
    @PostMapping("/querytoday")
    public PlatformResponse queryToday(@RequestBody Focus focus){
        Integer todaytotalTime = focusMapper.queryTodayTotalTime(focus);
        System.out.println(todaytotalTime);
        if(todaytotalTime!=null){
            return PlatformResponse.success(ResponseCode.OPERATE_DATA_SUCCESS.getCode(),"今日专注统计成功",todaytotalTime);
        }
        return PlatformResponse.failure(ResponseCode.OPERATE_DATA_FAILURE.getCode(),"今日专注统计失败");
    }

    // http://localhost:8989/todo/focus/querytodaystatic
    //返回按天统计数据
    @PostMapping("/querytodaystatic")
    public PlatformResponse querytodaystatic(@RequestBody Focus focus){
        List<Periodstatic> todaystatic = focusMapper.queryTodayByname(focus);
//        Integer todaytotalTime = focusMapper.queryTodayTotalTime(focus);
//        for(Periodstatic name : todaystatic){
//            name.setPercent((name.getNameTotalTime()/todaytotalTime));
//        }
        if(todaystatic != null){
            return PlatformResponse.success(ResponseCode.OPERATE_DATA_SUCCESS.getCode(),"今日专注统计成功",todaystatic);
        }
        return PlatformResponse.failure(ResponseCode.OPERATE_DATA_FAILURE.getCode(),"今日专注统计失败");
    }

    // http://localhost:8989/todo/focus/queryweekstatic
    //返回按天统计数据
    @PostMapping("/queryweekstatic")
    public PlatformResponse queryweekstatic(@RequestBody Focus focus){

        // 获取前一个月的日期
        Date currentDate=focus.getDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        Date startDate = calendar.getTime();
        focus.setDate(startDate);

        List<Periodstatic> weekstatic = focusMapper.queryWeekByname(focus);
//        Integer weektotalTime = focusMapper.queryWeekTotalTime(focus);
//        System.out.println("-------------weektotaltime:"+weektotalTime);
////        for(Periodstatic name : weekstatic){
////            System.out.println("-------------focustotaltime:"+name.getFocusName()+"    "+name.getNameTotalTime()+"    "+name.getNameTotalTime()/weektotalTime);
////            name.setPercent(name.getNameTotalTime()/weektotalTime);
////            System.out.println("-------------percent:"+name.getPercent());
////        }
        if(weekstatic != null){
            return PlatformResponse.success(ResponseCode.OPERATE_DATA_SUCCESS.getCode(),"今日专注统计成功",weekstatic);
        }
        return PlatformResponse.failure(ResponseCode.OPERATE_DATA_FAILURE.getCode(),"今日专注统计失败");
    }


    // http://localhost:8989/todo/focus/querymonthstatic
    //返回按天统计数据
    @PostMapping("/querymonthstatic")
    public PlatformResponse querymonthstatic(@RequestBody Focus focus){
        // 获取前一个月的日期
        Date currentDate=focus.getDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.MONTH, -1);
        Date startDate = calendar.getTime();
        focus.setDate(startDate);

        List<Periodstatic> monthstatic = focusMapper.queryMonthByname(focus);
//        Integer monthtotalTime = focusMapper.queryMonthTotalTime(focus);
//        for(Periodstatic name : monthstatic){
//            name.setPercent((name.getNameTotalTime()/monthtotalTime));
//        }
        if(monthstatic != null){
            return PlatformResponse.success(ResponseCode.OPERATE_DATA_SUCCESS.getCode(),"今日专注统计成功",monthstatic);
        }
        return PlatformResponse.failure(ResponseCode.OPERATE_DATA_FAILURE.getCode(),"今日专注统计失败");
    }

}