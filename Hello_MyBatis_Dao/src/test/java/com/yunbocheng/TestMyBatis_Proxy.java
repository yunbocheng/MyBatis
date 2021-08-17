package com.yunbocheng;

import com.yunbocheng.dao.StudentDao;
import com.yunbocheng.entity.Student;
import com.yunbocheng.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * 以下是使用mybatis动态代理的写法。
 *
 *  mybatis动态代理 : mybatis根据 dao的方法调用，获取执行sql语句的信息。
 *      mybatis根据你的dao接口，创建出一个dao接口的实现类，并创建这个类的对象。
 *      完成SqlSession调用方法，访问数据库。
 *      意思 ：就是我们不用在自己创建 StudentDao接口的实现类 StudentDaoImpl
 *            由mybatis根据dao接口自己创建出这个实现类，并完成数据的调用。
 *            这个时候我们只需要提供接口即可，剩下的交给mybatis。
 */
public class TestMyBatis_Proxy {

    @Test
    public void testSelectStudent(){
        /*
        *   使用mybatis的动态代理机制，使用SqlSession.getMapper(dao接口)
        *   getMapper(dao接口) ：这个方法可以获取dao接口的实现类对象
        * */
        // 第一步 ：使用MyBatisUtils这个工具类，创建出一个 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 第二步 ：使用 SqlSession实现类对象调用 getMapper(dao接口) 这个方法。
        // 也就是使用 mybatis动态代理机制，这个机制会帮我们完成接口实现类对象的创建，
        // 返回一个查询完数据之后的接口实现类对象。
        // 我们只需要接收这个接口是实现类对象，之后直接遍历即可。
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        // 调用 dao 的方法（这个方法是在dao这个接口中的方法），执行数据库的操作
        List<Student> students = dao.testSelect();
        // 遍历查询结果
        for (Student student : students) {
            System.out.println("查询的学生是 : " + student);
        }

    }
}
