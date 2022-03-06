package com.zf.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class student {
    private Integer id;
    private String name;

    public student(String name) {
        this.name = name;
    }
}
