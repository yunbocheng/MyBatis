package com.yunbocheng;

import com.yunbocheng.entity.Student;
import com.yunbocheng.utils.MyBatisUtils4;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 *
 * 使用mybatis的对象 SqlSession，通过他的方法执行sql语句。
 */
public class MyApp2 {
    public static void main(String[] args) throws IOException {

        // 5.【重点】获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession = MyBatisUtils4.getSqlSession();
        // 6.【重点】指定要执行的sql语句的标识。sql映射文件中的namespace的值 + "." + select标签的id值。
        // String sqlId = "com.yunbocheng.dao.StudentDao" + "." + "selectstudents";
        String sqlId = "com.yunbocheng.dao.StudentDao.selectStudents";
        // 7. 执行sql语句，通过sqlId找到语句
        List<Student> studentList = sqlSession.selectList(sqlId);
        // 8. 输出结果
        studentList.forEach(stu -> System.out.println(stu));
        // 9. 关闭SqlSession对象
        sqlSession.close();
    }
}