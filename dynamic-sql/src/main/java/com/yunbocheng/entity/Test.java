package com.yunbocheng.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
/*@Data注解整合了get/set、toString、hashCode、equals、以及无参构造方法*/
@AllArgsConstructor
/*@AllArgsConstructor代表构造所有属性的全参构造*/
@NoArgsConstructor
/*@NoArgsConstructor无参构造方法，省略也可以，因为无参构造已经整合到了@Data注解中*/

public class Test {
    private String name;
    private String sex;
    private int age;
}
