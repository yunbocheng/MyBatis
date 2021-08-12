package com.yunbocheng;

import com.yunbocheng.dao.StudentDao;
import com.yunbocheng.dao.impl.StudentDaoImpl;
import com.yunbocheng.entity.Student;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {

    @Test
    public void testSelectStudent(){
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> students = studentDao.testSelect();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
