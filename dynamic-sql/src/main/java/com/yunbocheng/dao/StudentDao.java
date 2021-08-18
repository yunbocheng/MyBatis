package com.yunbocheng.dao;

import com.yunbocheng.entity.Student;

import java.util.List;

/**
 * 这是一个接口操作Student表
 * 这个接口在这个项目中不会用到
 */
public interface StudentDao {
    /*
        测试动态sql中的 if 标签
        动态sql要使用java对象作为参数
    */
    List<Student> selectStudentIf(Student student);

    /**
     * 测试动态sql中的 where 标签
     * 动态sql要使用java对象作为参数
     */
    List<Student> selectStudentWhere(Student student);

    List<Student> selectStudentForeach(List<Integer> list);

    List<Student> selectStudentForeachTwo(List<Student> stuList);
}
