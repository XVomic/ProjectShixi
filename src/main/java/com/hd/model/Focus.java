package com.hd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Focus {

        private int id;

        private int userID;

        private String name;

        private int time;       //记录专注时长

        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date date;

}
