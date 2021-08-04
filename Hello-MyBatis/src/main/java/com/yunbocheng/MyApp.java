package com.yunbocheng;

import com.yunbocheng.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *
 * 使用mybatis的对象 SqlSession，通过他的方法执行sql语句。
 */
public class MyApp {
    public static void main(String[] args) throws IOException {
        // 访问mybatis读取student数据
        // 1. 定义mybatis主配置文件的名称，从类路径下的根路径开始(target/classes下开始)
        // target才是我们执行查询等操作时的资源文件。
        // 注意这个路径是使用compile命令编译之后的路径，
        // 这个时候这个主配置文件就在target/classes路径下，直接书写即可。
        // 此时MyBatis会自动找 target/classes路径下的这个 mybatis.xml 文件
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
        String sqlId = "com.yunbocheng.dao.StudentDao.selectStudents";
        // 7. 执行sql语句，通过sqlId找到语句
        List<Student> studentList = sqlSession.selectList(sqlId);
        // 8. 输出结果
        // studentList.forEach(stu -> System.out.println(stu));
        for (Student stu : studentList) {
            System.out.println("查询的学生 = " + stu);
        }
        // 9. 关闭SqlSession对象
        sqlSession.close();
        /*
        * 运行后的结果：（注意：这个格式是因为重写了toString方法）
        *  Student{id=1, name='1001', email='zhangsan@13.com', age=20}
        *  Student{id=2, name='1002', email='lisi@12.com', age=28}
        * */
    }
}
