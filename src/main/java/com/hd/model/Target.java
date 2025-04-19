package com.hd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Target {
    private int id;
    private int userID;
    private String name;
    private String depict;
    private String endDate;
}
