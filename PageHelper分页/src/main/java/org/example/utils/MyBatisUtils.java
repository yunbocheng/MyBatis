package org.example.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

// myBatis工具类
public class MyBatisUtils {

    private static  SqlSessionFactory factory = null;

    static {
        // 获取mybatis主配置文件
        try {
            InputStream in = Resources.getResourceAsStream("myBatis.xml");
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 定义一个获取SqlSession的方法
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        if (factory != null) {
            sqlSession= factory.openSession(true);
        }
        return sqlSession;
    }

}
