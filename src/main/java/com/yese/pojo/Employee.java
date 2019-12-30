package com.yese.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer id;
    private String lastName;

    private String email;
    //1 男, 0 女
    private Integer gender;
    private Department department;
    private Date birth;

}