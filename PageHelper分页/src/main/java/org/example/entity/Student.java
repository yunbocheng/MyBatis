package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 使用lombok中的注解来创建实体类中方法
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String num;

    private String province;

    private String city;

    private String name;

    private Integer age;

    private Double score;

    private String room;

}
