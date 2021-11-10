package com.yunbocheng.dao;

import com.yunbocheng.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentDao {

    // 使用注解的方式查询数据库中的全部数据
    @Select("select * from tab_student")
    public List<Student> selectAllStudent();

    // 使用注解的方式根据年龄和班级查询指定的学生对象
    @Select("select * from tab_student where age = #{age} and room = #{room}")
    public List<Student> selectByAgeAndRoom(@Param("age")int age,@Param("room")String room);

    //定义一个插入学生对象的方法
    @Insert("insert into tab_student(num,province,city,name,age,score,room) values(#{num},#{province},#{city},#{name},#{age},#{score},#{room})")
    public int insertStudent(Student student);


    // 定义一个删除学生信息的方法，这个方式与@Param(参数)中的参数有关系，与deleteStudent()方法中的参数没有关系。
    @Delete("delete from tab_student where num = #{num}")
    public int deleteStudent(@Param("num")String num1);

    // 定义一个修改学生信息的方法
    @Update("update tab_student set room = #{room},age = #{age},score = #{score} where num = #{num}")
    public int updateStudent(Student student);

}
