package com.hd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Routine {

    private Integer id;

    private int userID;

    private String name;

    private int way;

}
