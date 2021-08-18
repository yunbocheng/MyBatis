package com.yunbocheng;

import com.yunbocheng.dao.StudentDao;
import com.yunbocheng.entity.Student;
import com.yunbocheng.utils.MyBatis;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMyBatis {

    // 测试if标签
    @Test
    public void testSelectStudentIf() {
        SqlSession sqlSession = MyBatis.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("程云博");
        student.setAge(10);
        List<Student> students = dao.selectStudentIf(student);
        for (Student student1 : students) {
            System.out.println("if===" + student1);
        }
    }

    // 测试where标签
    @Test
    public void testSelectStudentWhere() {
        SqlSession sqlSession = MyBatis.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("");
        student.setAge(100);
        List<Student> students = dao.selectStudentWhere(student);
        for (Student student1 : students) {
            System.out.println(student1);
        }
    }

    // 测试foreach遍历简单数据对象
    @Test
    public void testSelectForEachOne() {
        SqlSession sqlSession = MyBatis.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Integer> list = new ArrayList<>();
        list.add(1002);
        list.add(1003);
        list.add(1004);
        List<Student> students = dao.selectStudentForeach(list);
        for (Student student1 : students) {
            System.out.println(student1);
        }
    }

    // 测试foreach遍历对对象集合
    @Test
    public void testSelectForEachTwo() {
        SqlSession sqlSession = MyBatis.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //定义一个Student对象集合
        List<Student> studentList = new ArrayList<>();
        // 创建第一个Student对象
        Student student1 = new Student();
        // 给id属性赋值
        student1.setId(1002);
        // 将这个对象加入到Student对象集合中
        studentList.add(student1);

        // 创建第二个Student对象
        Student student2 = new Student();
        student2.setId(1003);
        studentList.add(student2);

        List<Student> studentList1 = dao.selectStudentForeachTwo(studentList);
        for (Student student : studentList1) {
            System.out.println(student);
        }
    }
}
