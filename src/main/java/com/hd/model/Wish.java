package com.hd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Wish {
    private int id;
    private int userID;
    private String content;
    private int support;
}
