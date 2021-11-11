package org.example;


import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.entity.Student;
import org.example.utils.MyBatisUtils;

import java.util.List;

public class Test {

    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    StudentDao dao = sqlSession.getMapper(StudentDao.class);

    // 测试分页查询
    @org.junit.Test
    public void testHelper(){
        // 加入PageHelper的方法，分页
        // PageNum:第几页，从1开始
        // pageSize : 一页中有多少条数据
        PageHelper.startPage(2,8);
        List<Student> list = dao.selectAllPage();
        list.forEach(System.out::println);
    }
}
