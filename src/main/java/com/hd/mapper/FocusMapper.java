package com.hd.mapper;

import com.hd.model.Datastatic;
import com.hd.model.Focus;
import com.hd.model.Periodstatic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FocusMapper {
    int addFocus(Focus focus);

    Datastatic queryTotal(int useID);

    //计算当天专注次数
    Integer queryTodayRecords(Focus focus);

    //计算当天专注时间
    Integer queryTodayTotalTime(Focus focus);

    Integer queryWeekTotalTime(Focus focus);
    Integer queryMonthTotalTime(Focus focus);

    List<Periodstatic> queryTodayByname(Focus focus);

    List<Periodstatic> queryWeekByname(Focus focus);
    List<Periodstatic> queryMonthByname(Focus focus);

}
