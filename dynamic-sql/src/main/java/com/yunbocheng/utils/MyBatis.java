package com.yunbocheng.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatis {
    // 创建一个全局的 SqlSessionFactory接口的实现类对象，用于创建SqlSession接口的实现类对象。
    private static SqlSessionFactory factory = null;
    // 创建一个静态块，只要程序已启动，就会自动执行静态代码块中的代码
    static {
        // 访问mybatis主配置文件的信息,
        // 这个也是书写的主配置文件在target/classes路径下的路径。
        // 需要和你的项目中的文件名一样
        String config = "mybatis.xml";
        // 读取这个config表示的文件
        try {
            InputStream in = Resources.getResourceAsStream(config);
            // 创建SqlSessionFactory对对象，使用SqlSessionFactoryBuild
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
