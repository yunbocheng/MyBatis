package com.yunbocheng.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {

    private static SqlSessionFactory factory = null;

    static {
        try {
            InputStream in = Resources.getResourceAsStream("myBatis.xml");
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 声明一个获取sqlSession的方法
    public static SqlSession getSession(){
        SqlSession sqlSession = null;
        if (factory != null){
             sqlSession = factory.openSession(true);
        }
        return sqlSession;
    }
}
