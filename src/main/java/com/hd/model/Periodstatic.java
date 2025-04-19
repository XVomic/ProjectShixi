package com.hd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Periodstatic {
    private String focusName;   //区分专注事项
    private int nameTotalTime;  //记录当前事项的总时间，当前时间段
    private float percent;      //计算当前事务占比
}
