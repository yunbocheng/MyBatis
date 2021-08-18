package com.yunbocheng;

import com.yunbocheng.dao.StudentDao;
import com.yunbocheng.entity.Student;
import com.yunbocheng.utils.MyBatisUtils1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {
    // 测试方法，测试功能
    @Test
    public void testInsert() throws IOException {

        String config = "mybatis.xml";
        // 2.读取这个config表示的文件
        InputStream in = Resources.getResourceAsStream(config);
        // 3.创建了SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 4.创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        // 5.【重点】获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession = factory.openSession();
        // 6.【重点】指定要执行的sql语句的标识。sql映射文件中的namespace的值 + "." + select标签的id值。
        // String sqlId = "com.yunbocheng.dao.StudentDao" + "." + "selectstudents";
        String sqlId = "com.yunbocheng.dao.StudentDao.insertStudent";
        // 7.创建一个Student对象
        Student student = new Student();
        student.setId(1006);
        student.setName("中国");
        student.setEmail("891@qq.com");
        student.setAge(100);
        // 8. 执行sql语句，通过sqlId找到语句
        int nums = sqlSession.insert(sqlId, student);
        // 9.提交事务，MyBatis默认不是自动提交事务的，
        // 所以在insert、update、delete后要手动提交事务。
        sqlSession.commit();
        // 10. 输出结果
        System.out.println("执行insert的结果：" + nums);
        // 11 关闭SqlSession对象
        sqlSession.close();
        /*
         * 运行后的结果：（注意：这个格式是因为重写了toString方法）
         *  Student{id=1, name='1001', email='zhangsan@13.com', age=20}
         *  Student{id=2, name='1002', email='lisi@12.com', age=28}
         * */
    }

    @Test
    public void selectSelectLikeOne(){
        SqlSession sqlSession = MyBatisUtils1.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        // 准备好like的内容，使用dao接口的实现类对象调用方法
        String name = "%程%";
        List<Student> students = dao.selectLikeOne(name);
        for (Student student : students) {
            System.out.println("查询到的学生 ：" + student);
        }
    }

    @Test
    public void selectSelectLikeTwo(){
        SqlSession sqlSession = MyBatisUtils1.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        // 准备好like的内容，使用dao接口的实现类对象调用方法
        String name = "程";
        List<Student> students = dao.selectLikeOne(name);
        for (Student student : students) {
            System.out.println("查询到的学生 ：" + student);
        }
    }
}
