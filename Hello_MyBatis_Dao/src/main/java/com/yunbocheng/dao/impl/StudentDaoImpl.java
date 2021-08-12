package com.yunbocheng.dao.impl;

import com.yunbocheng.dao.StudentDao;
import com.yunbocheng.entity.Student;
import com.yunbocheng.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> testSelect() {
        // 获取SqlSession对象，使用工具包
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.yunbocheng.dao.StudentDao.testSelect";
        // 执行sql语句，使用SqlSession类的方法
        List<Student> list = sqlSession.selectList(sqlId);
        //关闭 SqlSession对象，保证线程安全
        sqlSession.close();
        return list;
    }
}
