package com.yunbocheng;

import com.yunbocheng.dao.StudentDao;
import com.yunbocheng.entity.Student;
import com.yunbocheng.utils.MyBatisUtils;
import com.yunbocheng.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMyBatis_Proxy {

    /**
     * 以下是使用动态代理机制完成对数据库的操作。
     * 这个动态代理机制不用创建接口的实现类以及接口的实现类对象。
     * 也就是不用在创建 impl 类
     *
     * mybatis根据你的dao接口，创建出一个dao接口的实现类，并创建这个类的对象。
     * 完成SqlSession调用方法，访问数据库。
     *
     * 使用mybatis动态代理机制，使用SqlSession.getMapper(dao接口)。
     * 这个方法能获取到dao接口的实现类对象，使用这个对象就可以调用接口中的方法，
     *
     * 注意 ：1.此时不需要另外创建接口的实现类，这个方法会帮我们创建实现类对象，
     *       并帮我们实现接口中的方法，（注意 ：这个接口中并没有方法的实现，只是声明了一个抽象方法。）
     *
     *       2. 这个方法实现的是 定位SQL语句，（也就是查询数据库的语句的位置）
     *
     *       3. 根据调用接口中的返回值类型确定 SqlSession 所要调用的方法。
     *
     *       如果返回值是List，调用的就是SqlSession.selectList()方法。
     *       如果返回值是 int , 或是非List的，看mapper文件中的标签是<insert>,<update>
     *       就会调用SqlSession的insert、update方法。
     *
     * mybatis动态代理帮我们完成的事情 ：
     *        1. 定位到SQL语句 ：String sqlId = "com.yunbocheng.dao.StudentDao.testSelect";
     *        2. 根据返回值类型确定 sqlSession所要调用的方法
     *           List<Student> list = sqlSession.selectList(sqlId);
     *        3. 释放这个 sqlSession 对象，保证线程安全。
     *           sqlSession.close();
     *        4. 将执行的完的结果进行返回
     *           return list;
     */
    @Test
    public void testSelectStudents(){
        // 使用工具包获取一个 SqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 使用动态代理机制，获取接口的实现类对象 (dao对象)，这个方法会帮我们定位到SQL语句。
        // 并且会根据这个 返回值类型确定所用调用的 sqlSession 方法
        // List<Student> list = sqlSession.selectList(sqlId);
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        // 调用这个dao接口中的方法。(注意 ：这个方法里什么也没有，就是声明了一个抽象方法)
        List<Student> students = dao.testSelect();
        for (Student student : students) {
            System.out.println("查询的学生数据 : " + student);
        }
    }

    @Test
    public void testInsertStudents(){
        // 创建一个学生对象，将这个学生对象插入到数据库
        Student student = new Student();
        // 给student赋值，如果没有赋值的默认null，且顺序可以改变
        student.setAge(300);
        student.setId(1050);
        student.setName("花朵");
        student.setEmail("123@qq.com");
        // 使用工具类，获取到一个  sqlSession 对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 使用动态机制，获取接口实现类对象
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        // 调用接口中插入数据的方法
        int i = dao.testInsert(student);
        // 一定要提交事务
        sqlSession.commit();
        System.out.println("插入的数据数 :" + i);
    }

    @Test
    public void testSelectMulitiParam(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMulitParam("程云博", 50);
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    /**
     * 多参传递，使用java对象传递参数
     */
    @Test
    public void testSelectQueryStudents(){
        // 使用工具类获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 通过Mybatis动态代理获取dao接口的实现类对象
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        // 创建一个传递参数的java对象
        QueryParam queryParam = new QueryParam();
        // 设置这个对象的属性值，将其作为参数传递给
        queryParam.setParamName("程云博");
        queryParam.setParamAge(50);
        // 调用接口的中的方法
        List<Student> students = dao.selectQueryStudents(queryParam);
        // 遍历这个集合中的数据
        for (Student student : students) {
            System.out.println("stu : " + student);
        }
    }
    // 测试按位置传递多个参数
    @Test
    public void testSelectPosition(){
        // 使用工具类创建一个SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 使用动态代理获取到一个dao接口的实现类对象
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        // 使用dao调用其中的方法，传递参数
        List<Student> students = dao.selectMultiPosition("程云博", 20);
        // 遍历获取到的学生信息
        for (Student student : students) {
            System.out.println("查询到的学生 : " + student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectByMap() {
        // 使用工具类创建一个SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 使用动态代理获取到一个dao接口的实现类对象
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        // 创建一个Map集合
        Map<String,Object> data = new HashMap<>();
        data.put("myname","程云博");
        data.put("myage",20);
        // 调用dao中的方法
        List<Student> students = dao.selectMulitByMap(data);
        // 遍历获取到的学生信息
        for (Student student : students) {
            System.out.println("查询到的学生 : " + student);
        }
        sqlSession.close();
    }
}
