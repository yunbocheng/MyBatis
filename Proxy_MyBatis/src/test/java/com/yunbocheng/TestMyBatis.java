package com.yunbocheng;

import com.yunbocheng.dao.StudentDao;
import com.yunbocheng.dao.impl.StudentDaoImpl;
import com.yunbocheng.entity.Student;
import org.junit.Test;

import java.util.List;

/**
 * 以下使用的是普通的实现方法，也就是创建接口的实现类对象，使用这个实现类对象
 * 调用接口实现类中的方法完成对数据库的操作。
 */
public class TestMyBatis {

    @Test
    public void testSelectStudent(){
        StudentDao studentDao = new StudentDaoImpl();
        /**
         * List<Student> students = studentDao.testSelect(); 调用
         * 1.students对象，类型是StudentDao，这个类的全限定名称是 :
         *            com.yunbocheng.dao.StudentDao
         *    全限定名称 和 namespace 是一样的。
         *
         * 2. 方法名称 ：testSelect，这个方法名称就是 mapper(StudentDao.xml)文件中
         *             id值 testSelect 。
         * 3. 通过dao中方法的返回值也可以确定Mybatis要调用的SqlSession的方法。
         *    如果返回值是List，调用的就是SqlSession.selectList()方法。
         *    如果返回值是 int , 或是非List的，看mapper文件中的标签是<insert>,<update>
         *    就会调用SqlSession的insert、update方法。
         *
         *  mybatis动态代理 : mybatis根据 dao的方法调用，获取执行sql语句的信息。
         *      mybatis根据你的dao接口，创建出一个dao接口的实现类，并创建这个类的对象。
         *      完成SqlSession调用方法，访问数据库。
         *      意思 ：就是我们不用在自己创建 StudentDao接口的实现类 StudentDaoImpl
         *            由mybatis根据dao接口自己创建出这个实现类，并完成数据的调用。
         *            这个时候我们只需要提供接口即可，剩下的交给mybatis。
         */
        List<Student> students = studentDao.testSelect();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testInsertStudent(){
        // 创建一个接口的实现类使用里边的方法
        StudentDao studentDao = new StudentDaoImpl();
        // 创建一个学生对象
        Student student = new Student();
        // 给这个对象赋值
        student.setId(1100);
        student.setName("大美");
        student.setEmail("789@qq.com");
        student.setAge(1000);
        // 调用这个接口实现类中的方法
        int i = studentDao.testInsert(student);
        System.out.println(i);
    }
}
