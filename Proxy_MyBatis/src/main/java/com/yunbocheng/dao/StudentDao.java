package com.yunbocheng.dao;

import com.yunbocheng.entity.Student;
import com.yunbocheng.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    /**
     * 测试查询数据库的方法
     * @return Student对象的List集合
     */
    public List<Student> testSelect();

    public  int testInsert(Student student);

    /**
     * 多个参数：命名参数，在形参定义的前面加入 @Param("自定义参数名称")
     */
    List<Student> selectMulitParam(@Param("myname")String name ,
                                   @Param("myage") Integer age);

    /**
     * 多个参数，使用Java对象作为接口中方法的参数
     */
    public List<Student> selectQueryStudents(QueryParam param);

    /**
     * 多个参数，简单类型的，按位置传值。
     * mybatis 3.4之前 ：使用 #{0},#{1}
     * mybatis 3.5之后 ：使用 #{arg0},#{arg1}
     * 注意 ；这个arg不能改变
     */
    public List<Student> selectMultiPosition(String name,Integer age);

    /**
     * 多个参数，使用Map存放多个值
     */
    List<Student> selectMulitByMap(Map<String,Object> map);
}
