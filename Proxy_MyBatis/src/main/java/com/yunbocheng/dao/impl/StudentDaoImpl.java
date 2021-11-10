package com.yunbocheng.dao.impl;

import com.yunbocheng.dao.StudentDao;

import com.yunbocheng.utils.MyBatisUtils;
import com.yunbocheng.vo.QueryParam;
import com.yunbocheng.entity.Student;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 这个类是实现接口中的方法，在测试类中创建这个类使用这个类中的方法。
 */
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

    @Override
    public int testInsert(Student student) {
        // 获取SqlSession对象，使用工具包
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.yunbocheng.dao.StudentDao.testInsert";
        // 执行sql语句，插入数据
        int insert = sqlSession.insert(sqlId,student);
        // 提交事务
        sqlSession.commit();
        // 关闭sqlSession对象
        sqlSession.close();
        return insert;
    }

    @Override
    public List<Student> selectMulitParam(String name, Integer age) {
        return null;
    }

    @Override
    public List<Student> selectQueryStudents(QueryParam param) {
        return null;
    }

    @Override
    public List<Student> selectMultizPosition(String name, Integer age) {
        return null;
    }

}
