package com.yunbocheng.dao;

import com.yunbocheng.entity.Student;

import java.util.List;

public interface StudentDao {

    /**
     * 测试查询数据库的方法
     * @return Student对象的List集合
     */
    public List<Student> testSelect();

}
