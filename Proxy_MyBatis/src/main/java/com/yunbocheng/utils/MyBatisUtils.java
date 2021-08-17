package com.yunbocheng.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {
    // 创建一个全局的 SqlSessionFactory接口的实现类对象，用于创建SqlSession接口的实现类对象。
    private static SqlSessionFactory factory = null;
    // 创建一个静态块，只要程序已启动，就会自动执行静态代码块中的代码
    // 也就是使用下边的 getSqlSession() 方法的时候，一定会执行这个static静态代码块。
    // 执行静态代码块中的代码，可以创建出一个SqlSessionFactory对象. 这个对象用于创建SqlSession对象。
    static {
        // 访问mybatis主配置文件的信息,
        // 这个也是书写的主配置文件在target/classes路径下的路径。
        // 需要和你的项目中的文件名一样
        String config = "myBatis.xml";
        // 读取这个config表示的文件
        try {
            InputStream in = Resources.getResourceAsStream(config);
            // 创建SqlSessionFactory对象，使用SqlSessionFactoryBuild
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 获取SqlSession的方法
    public static SqlSession getSqlSession(){
        // 定义一个全局的SqlSession对象
        SqlSession sqlSession = null;
        if(factory != null){
            sqlSession = factory.openSession(); //默认，非自动提交事务。
        }
        return sqlSession;
    }
}
