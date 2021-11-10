package com.yunbocheng.entity;

import java.io.Serializable;

public class Student implements Serializable {

    // 这里尽量保持类的属性名和数据库中的字段名保持一致，因为这里使用的映射方式
    // 如果不一致的话，需要在mapper.xml中使用 resultMap标签来进行修改

    private String num;

    private String province;

    private String city;

    private String name;

    private Integer age;

    private Double score;

    private String room;

    public Student() {
    }

    public Student(String num, String province, String city, String name, Integer age, Double score, String room) {
        this.num = num;
        this.province = province;
        this.city = city;
        this.name = name;
        this.age = age;
        this.score = score;
        this.room = room;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Student{" +
                "num='" + num + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", room='" + room + '\'' +
                '}';
    }
}
