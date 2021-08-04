package com.yunbocheng.entity;

/**
 * 推荐和表名一样。容易记忆。
 * 可以认为是表中的一行数据就是一个student对象
 */
public class Student {
    // 定义属性，目前的要求属性名和列名一致，以及数据类型一致。
    // 这些属性数量的和表中的列的数量是相等的，且数据是相等的。
    // 可以把数据库表中的每一行数据看作是一个student对象
    private Integer id;
    private String name;
    private String email;
    private Integer age;

    public Student() {
    }

    public Student(Integer id, String name, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
