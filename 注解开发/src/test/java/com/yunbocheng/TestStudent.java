package com.yunbocheng;

import com.yunbocheng.dao.StudentDao;
import com.yunbocheng.entity.Student;
import com.yunbocheng.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestStudent {

    SqlSession sqlSession = MyBatisUtils.getSession();
    StudentDao dao = sqlSession.getMapper(StudentDao.class);
    @Test
    public void testSelectAll(){

        List<Student> list = dao.selectAllStudent();

        list.forEach(System.out::println);
    }

    @Test
    public void testSelectByAgeAndRoom(){
        List<Student> list = dao.selectByAgeAndRoom(21,"Java1105");

        list.forEach(System.out::println);
    }


    @Test
    public void testInsert(){
        Student student = new Student("110522","河北省","石家庄市","承运比",22,100.0,"Java1105");
        int i = dao.insertStudent(student);
        // 这里不需要手动提交一下事务，因为在工具类中设置了true，自动提交事务
        System.out.println(i);
    }

    @Test
    public void testDelete(){
        int i = dao.deleteStudent("110522");
        System.out.println(i);
    }

    @Test
    public void testUpdate(){
        Student student = new Student();
        student.setRoom("Java1103");
        student.setAge(80);
        student.setScore(89.4);
        student.setNum("110521");
        int i = dao.updateStudent(student);
        System.out.println(i);
    }
}
