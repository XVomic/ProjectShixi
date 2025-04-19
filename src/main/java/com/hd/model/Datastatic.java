package com.hd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//传输给前前端的数据多，但是前端选择性使用，这样我不需要过多对实体类数据设计
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Datastatic {

    private int totalRecords;    //当前用户总的专注次数
    private int totalTime;      //当前用户专注的总时长
    private int totalDays;      //当前用户专注的总天数，用于计算日均时长

    private int aveDailytime;   //当前用户日均专注时长
    private int todayRecords;   //用户当天专注次数

    private int todayTotaltime;     //用户当天总的专注时长
}
