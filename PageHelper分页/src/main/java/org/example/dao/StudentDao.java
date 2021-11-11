package org.example.dao;


import org.example.entity.Student;

import java.util.List;

public interface StudentDao {

    // 定义一个查询全部学生信息的方法
    public List<Student> selectAllPage();
}

