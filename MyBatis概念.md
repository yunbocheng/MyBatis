# MyBatis框架

## 1. 软件开发常用结构

- **MyBatis是<mark>操作数据库</mark>的，相当于是一个<mark>增强的JDBC</mark>**

### 1.1 三层架构

**三层架构包括：**

- 界面层（User Interface layer）
- 业务逻辑层（Business Logic Layer）
- 数据访问层（Data access layer）

**三层的职责：**

-  <mark>界面层（表示层，视图层）</mark>：主要功能是接受用户的数据，显示请求的处理结果。使用 web 页面和 用户交互，手机 app 也就是表示层的，用户在 app 中操作，业务逻辑在服务器端处理。

  可以认为是<mark>jsp、servlet、html、css...</mark>。

- <mark>业务逻辑层</mark>：接收表示传递过来的数据，检查数据，计算业务逻辑，调用数据访问层获取数据。可以认为是<mark>service</mark>，处理业务逻辑，调用dao的。

- <mark>数据访问层（持久层）</mark>：与数据库打交道。主要实现对数据的增、删、改、查。将存储在数据库中的数据提交 给业务层，同时将业务层处理的数据保存到数据库.

**三层对应的包：**

- 面层： controller包 （servlet）
- 业务逻辑层： service 包（XXXService类）
- 数据访问层： dao包（XXXDao类）用来对数据库进行增、删、改、查。

**三层的处理请求的交互：**

- **用户---> 界面层--->业务逻辑层--->数据访问层--->DB 数据库**

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20210803214420794.png" alt="image-20210803214420794" style="zoom:80%;" />

**为什么要使用三层：**

- 结构清晰、耦合度低, 各层分工明确 
- 可维护性高，可扩展性高 
- 有利于标准化 
- 开发人员可以只关注整个结构中的其中某一层的功能实现 
- 有利于各层逻辑的复用

**<mark>重点 ：因为每一层都对应一个处理框架</mark>**

**三层对应的处理框架：**

- 界面层---servlet---<mark>springmvc（框架）</mark>：接收请求，处理结果。
- 业务逻辑层---service类--<mark>spring（框架）</mark> ：管理service类。
- 数据访问层---dao类--<mark>mybatis（框架）</mark>：代替JDBC访问数据库。

## 2. 什么是框架

**框架的定义：**

- 框架（Framework）是整个或部分系统的可重用设计，表现为一组抽象构件及构件实例间交互的方 法;另一种认为，框架是可被应用开发者定制的应用骨架、模板。 简单的说，框架其实是半成品软件，就是一组组件，供你使用完成你自己的系统。从另一个角度来 说框架一个舞台，你在舞台上做表演。在框架基础上加入你要完成的功能。 <mark>框架是安全的，可复用的，不断升级的软件。 </mark>
- 简单理解：可以把框架当做是一个舞台、一个模板(规定好的一些条款、内容)。

**框架解决的问题：**

- 框架要解决的最重要的一个问题是<mark>技术整合</mark>，在 J2EE 的 框架中，有着各种各样的技术，不同的应 用，系统使用不同的技术解决问题。需要从 J2EE 中选择不同的技术，而技术自身的复杂性，有导致更 大的风险。企业在开发软件项目时，主要目的是解决业务问题。 即要求企业负责技术本身，又要求解 决业务问题。这是大多数企业不能完成的。<mark>框架把相关的技术融合在一起，企业开发可以集中在业务领 域方面。</mark>
-  另一个方面可以提供开发的效率。

**框架的特点：**

- 框架一般不是全能的， 不能做所有事情

- 框架是针对某一个领域有效。 特长在某一个方面，比如mybatis做数据库操作强，但是他不能做其它的。

- 框架是安全的，可复用的，不断升级的软件。

**常用的J2EE开发框架：**

- J2EE是一套针对企业级分布式应用的计算环境。它定义了动态Web页面功能（Servlet和Jsp）、商业组件（EJB）、异步消息传输机制（JMS）、名称和目录定位服务（JNDI）、数据库访（JDBC）、与子系统的连接器（JCA）和安全服务等。

------

> <mark>MyBatis 框架</mark>： MyBatis 是一个优秀的基于 java 的持久层框架，内部封装了 jdbc，开发者只需要关注 sql 语句 本身，而不需要处理加载驱动、创建连接、创建 statement、关闭连接，资源等繁杂的过程。 MyBatis 通过 xml 或注解两种方式将要执行的各种 sql 语句配置起来，并通过 java 对象和 sql 的 动态参数进行映射生成最终执行的 sql 语句，最后由 mybatis 框架执行 sql 并将结果映射为 java  对象并返回。

------

> <mark>Spring 框架</mark>： Spring 框架为了解决软件开发的复杂性而创建的。Spring 使用的是基本的 JavaBean 来完成以前 非常复杂的企业级开发。Spring 解决了业务对象，功能模块之间的耦合，不仅在 javase,web 中使用， 大部分 Java 应用都可以从 Spring 中受益。 Spring 是一个轻量级控制反转(IoC)和面向切面(AOP)的容器。

------

> <mark>SpringMVC 框架</mark>:  Spring MVC 属于 SpringFrameWork 3.0 版本加入的一个模块，为 Spring 框架提供了构建 Web  应用程序的能力。现在可以 Spring 框架提供的 SpringMVC 模块实现 web 应用开发，在 web 项目中 可以无缝使用 Spring 和 Spring MVC 框架。

## 3.MyBatis框架

### 3.1 MyBatis介绍

- 一个框架，早期叫做ibatis,  代码在github。
-    mybatis是（MyBatis SQL Mapper Framework for Java ）（sql映射框架）
  - <mark>sql mapper</mark> : <mark>sql映射</mark>
    可以把数据库表中的一行数据  映射为 一个java对象。一行数据可以看做是一个java对象。操作这个对象，就相当于操作表中的数据。
  - <mark>Data Access Objects（DAOs）</mark> : 数据访问 ， 对数据库执行增删改查。

### 3.1 MyBatis 提供的功能

- 提供了创建Connection ,Statement, ResultSet的能力 ，不用开发人员创建这些对象了。
- 提供了执行sql语句的能力， 不用你执行sql。
- 提供了循环sql， 把sql的结果转为java对象， List集合的能力。

```java
// 这是以前使用JDBC时获取到的数据库查询结果，此时需要使用循环来获取到查询的结果，并将这个结果写入到一个List集合中，很麻烦。
// 此时使用MyBatis框架，他会把这些sql语句当做是一个个的对象，在底层对自动帮我们完成这个循环，我们获取到的是一个装满sql对象的List集合。
while (rs.next()) {
		Student stu = new Student();
		stu.setId(rs.getInt("id"));
		stu.setName(rs.getString("name"));
		stu.setAge(rs.getInt("age"));
		//从数据库取出数据转为 Student 对象，封装到 List 集合
		stuList.add(stu);
	  }
```

- 提供了关闭资源的能力，不用你关闭Connection, Statement, ResultSet。

### 3.2 开发人员做的工作

- <mark>提供sql语句</mark>，剩下的怎么执行这个sql语句，怎么获取到这个List集合，MyBatis会帮我们自己写好。
- 使用MyBatis之后的<mark>开发步骤</mark>：

```markdown
开发人员提供sql语句--->MyBatis处理sql--->开发人员得到List集合或者java对象(表中的数据)
```

## 3.3 对MyBatis的总结概述

-   mybatis是一个<mark>sql映射框架</mark>，提供的数据库的操作能力。<mark>增强的JDBC</mark>,
    使用mybatis让开发人员集中精神写sql就可以了，不必关心Connection,Statement,ResultSet
    的创建，销毁，sql的执行。 

## 4.入门案例

## 5.MyBatis对象分析

### 5.1 Resources 类

- Resources 类，顾名思义就是资源，<mark>用于读取资源文件。</mark>其有很多方法通过加载并解析资源文件，返 回不同类型的 IO 流对象。

- 简单的说这个类就是读取以上<mark>入门案例</mark>，中的Resources： mybatis中的一个类， 负责读取主配置文件。

  ```java
  InputStream in = Resources.getResourceAsStream("mybatis.xml");
  ```

### 5.2 SqlSessionFactoryBuilder 类

- SqlSessionFactory 的 创 建 ， 需 要 使 用 SqlSessionFactoryBuilder 对 象 的 build() 方 法 。 由 于 SqlSessionFactoryBuilder 对象在创建完工厂对象后，就完成了其历史使命，即可被销毁。所以，一般会将 该 SqlSessionFactoryBuilder 对象创建为一个方法内的局部对象，方法结束，对象销毁。

- SqlSessionFactoryBuilder : <mark>创建SqlSessionFactory对象。   </mark>

  ```java
  SqlSessionFactoryBuilder builder  = new SqlSessionFactoryBuilder();
  //创建SqlSessionFactory对象
  SqlSessionFactory factory = builder.build(in);
  ```

### 5.3 SqlSessionFactory 接口

- SqlSessionFactory 接口对象是一个<mark>重量级对象（系统开销大的对象）</mark>，是线程安全的，所以一个应用 只需要一个该对象即可。创建 SqlSession 需要使用 SqlSessionFactory 接口的openSession()方法。

- SqlSessionFactory 这个接口的实现类是 DefaultSqlSessionFactory。这个实现类中有<mark>openSession()方法，</mark>使用这个接口就是为了使用这个openSession()方法来获取<mark>SqlSession对象</mark>。

- SqlSessionFactory 作用 ： 获取SqlSession对象。

  ```java
  SqlSession sqlSession = factory.openSession();
  ```

**openSession()方法的几种形式：**

➢ openSession(true)：创建一个有自动提交功能的 SqlSession 。

➢ openSession(false)：创建一个非自动提交功能的 SqlSession，需手动提交 。

➢ openSession()：无参数，获取的是非自动提交事务的SqlSession对象。

### 5.4  SqlSession 接口

- SqlSession 接口对象用于执行持久化操作。一个 SqlSession 对应着一次数据库会话，一次会话以 SqlSession 对象的创建开始，以 SqlSession 对象的关闭结束。 SqlSession 接口对象是线程不安全的，所以每次数据库会话结束前，需要马上调用其 close()方法，将 其关闭。再次需要会话，再次创建。 SqlSession 在方法内部创建，使用完毕后关闭。
- SqlSession 接口 :<mark> 定义了操作数据的方法。</mark> 例如 selectOne() ,selectList() ,insert(),update(), delete(), commit(), rollback()。
-   SqlSession接口的<mark>实现类DefaultSqlSession。</mark>

**使用要求：**

- SqlSession对象<mark>不是线程安全的，</mark>需要在方法内部使用， 在执行sql语句之前，使用openSession()获取SqlSession对象。在执行完sql语句后，需要关闭它，执行SqlSession.close(). 这样能保证他的使用是线程安全的。

## 6.动态代理

- 动态代理： 使用SqlSession.getMapper(dao接口.class) 获取这个dao接口的对象
- **注意：在接口中不要使用重载的抽象方法。**

### 6.1 标准的mybatis配置主文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--namespace : 里边填写接口路径，这个类在项目中是唯一的，可以保证namespace值唯一-->
<mapper namespace="com.yunbocheng.dao.StudentDao">
<!--
    mybatis的配置文件：注意，一般是一个表文件一个这种配置文件。
    这个sql映射文件是写 sql语句的，mybatis会执行这些sql。
    对于这个sql映射文件的解释：
    1.指定约束文件
        <!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

        mybatis-3-mapper.dtd : 是约束文件的名称，扩展名是dtd的。
    2. 约束文件的作用
        限制、检查在当前文件中出现的标签，属性必须符合mybatis的要求。

    3.mapper（sql mapper 这个mapper就是映射的意思）：是当前文件的根标签。必须的，不可以改变。
        namespace ：叫做命名空间，这个空间是一个唯一值。可以是自定义的字符串
                    要求使用dao接口的【全限定名称】。定位的这个接口，而不是这个xml配置文件
                    【全限定名称】 = 包名 + 接口名(类名)
        <mapper namespace="com.yunbocheng.dao.StudentDao">

    4. 在当前文件中，可以使用特定的标签，表示数据库的特定操作。
       <select> : 表示执行查询，执行的是select语句。
       <update> : 表示更新数据库的操作，就是在<update>标签中写的是update sql语句
       <insert> : 表示插入，放的是insert语句
       <delete> : 表示删除，执行的delete语句

   5. 编写sql语句
         <select id="selectstudents" resultType="Student">
        /* 此时会将以下的数值依此赋值给Student对象 */
        select id,name,email,age from student order by id;
        </select>
        id : 代表执行的sql语句的唯一标识，mybatis会使用这个id的值来找到要
             执行的sql语句。这个id值可以自定义。但是要求使用接口中的方法名称。
             就相当于使用这个id值来代表这条sql语句。
        resultType : 代表结果的类型，是sql语句执行后得到的ResultSet，
                     遍历这个ResultSet得到Java对象的类型。
                     这个值写类型的全限定名称。
                    也就是把查询到的数据传递给com.yunbocheng.entity.Student类
                    此时MyBatis会自动创建出的一个student对象。并给属性赋值。
                    MyBatis会把从数据库中的id值赋给Student类中id的属性。
                    MyBatis会把从数据库中的name值赋给Student类中name的属性。
                    MyBatis会把从数据库中的email值赋给Student类中email的属性。
                    MyBatis会把从数据库中的age值赋给Student类中age的属性。
                    返回的这个类型和接口中方法的返回类型一致，都是一个student对象的集合。
     以上就是一个标准的 mybatis配置文件。
```

## 7.传入参数

- 传入参数 ：从java代码(也就是测试程序中的代码)中把数据传入到mapper文件的sql语句中。

## 8. 深入理解参数

### 8.1 parameterType 参数

#### 8.1.1 parameterType  介绍

- <mark>parameterType </mark>: 接口中方法参数的类型， 类型的完全限定名或别名。这个属性是可选的，因为 MyBatis 可以推断出具体传入语句的参数，默认值为未设置（unset）。接口中方法的参数从 java 代码传入到 mapper 文件的 sql 语句。

- 什么是parameterType ：写在mapper文件中的 一个属性。 表示dao接口中方法的参数的数据类型。

  ​	例如StudentDao接口 ：public Student  selectStudentById(Integer id) 

- parameterType  :  dao接口中方法参数的数据类型。

  parameterType 它的值是 Java的数据类型<mark>全限定名称</mark>或者是<mark>mybatis定义的别名</mark> (这个别名可以在mybatis官方文档中查询到)。

  > 例如 ：
  >
  > parameterType  = "java.lang.Integer"
  >
  > parameterType  = "int"
  >
  > int 或 java.lang.Integer 
  >
  > hashmap 或 java.util.HashMap 
  >
  > list 或 java.util.ArrayList student 或 com.yunbocheng.domain.Student

- 注意 ：parameterType 参数<mark>不是强制的 </mark>，mybatis通过反射机制能够发现接口参数的数据类型，可以不存在，一般我们不写。

- select、insert、update、delete 都可以使用parameterType 指定数据类型。

#### 8.1.2 parameterType 使用方式

- 第一步 ：在接口中声明一个带有参数抽象方法。（此时传递的参数是 ：整型的id值）

  ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210815161237.png)

- 第二步 ： 在mapper文件中写出查询数据库的语句。（此时是通过id查询数据）

  ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210815162545.png)

  以上 <mark>parameterType</mark> 使用的是 Java数据类型的<mark>全限定名称</mark>。

  <br/>

  ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210815162626.png)

  以上省略了<mark>parameterType</mark> ，使用的是 parameterType的<mark>默认值</mark>。默认值为未设置（unset）

  <br/>

  ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210815162808.png)

  以上 <mark>parameterType</mark> 使用的是<mark>mybatis定义的别名</mark> 。

- 第三步 :这个是测试类代码，也就是要传递到mapper中的参数代码。(此时传递的id值是1005)

- 声明<mark>@Test</mark>之后代表这是一个测试类，<mark>不需要使用psvm(主函数)</mark>也可以进行运行，如果不写@Test即不声明是一个测试类，此时需要放在主函数中才可以运行。

  ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210815160753.png)

  这个时候mybatis会自动将1005这个值传递给 mapper文件中的<mark>占位符 id=#{id}</mark>。

- 以上三步就完成对特定参数的查询数据。(此时查询的是id=1005的数据)。

### 8.2 传入一个简单参数

- dao 接口中方法的参数只有一个简单类型（java 基本类型和 String），占位符 #{ 任意字符 }，和方 法的参数名无关。

- **传递一个简单的参数使用 占位符 #{}**

- 一个简单类型的参数：mybatis把java的<mark>基本数据类型(包括包装类)</mark>和<mark>String</mark>都叫简单类型。

  比如 ：下边的这个就叫一个简单的参数。

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210815161237.png)

- 在mapper文件中获取简单类型的一个参数的值，使用占位符 ：<mark>#{任意字符}</mark>。

  以下两段代码代表的含义是一样的。<mark><mark>#{任意字符}</mark>

  ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210815162808.png)

  ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210815164808.png)

- 查询<mark>id=1005</mark>，的student。mybatis会自动将这个1005传递给<mark>占位符id</mark>。

  ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210815160753.png)

- MyBatis传递参数 ：**从 java 代码中把参数传递到 mapper.xml 文件。**

### 8.3 MyBatis是封装的JDBC操作

- 使用<mark>占位符 ：#{}</mark>之后，mybatis执行sql是使用的jdbc中的<mark>PreparedStatement</mark>对象。

- 由mybatis执行下面的代码：（mybatis中的占位符 ：<mark>#{}</mark>相当于jdbc中的<mark> ？</mark>）

- 注意 ：一个 <mark>#{}</mark>对应一个<mark>?</mark>。

  1. mybatis**创建Connection , PreparedStatement 对象**

     ```java
     // 以下这些代码都是在mapper文件中的操作，是MyBatis帮我们操作的。
     String sql = "select id,name,email,age from student where id= ?";
     PreparedStatement pst = conn.PreparedStatement(sql);
     pst.setInt(1,1001);
     ```

  2. 执行sql封装为 **resultType = "com.yunbocheng.domain.Student"** 这个对象。

     ```Java
     ResultSet rs = ps.executeQuery();
     Student student = null;
     while(rs.next()){
         // 从数据库取出id=1001的这一行数据，存储到一个java对象属性中。
         // 注意 ：在Student类中必须有每个属性的set/get，以及创建对象时的无参构造。
         student = new Student();
         student.setId(rs.getInt("id"));
         student.setName(rs.getString("name"));
         student.setEmail(rs.getString("email"));
         student.setAge(rs.getInt("age"));
         // 也可以将这些数据写在一个student类的有参构造的方法中。
         // 此时查询的是id=1001这个对象，而不是一多个student，此时不用放在一个集合中。
     }
     return student;  
     // 把mapper文件中查询到的这个student赋给了dao方法调用的返回值。也就是以下这段代码
     // 以下这段代码是测试类代码
     Student student = dao.selectStudentById(1001);
     System.out.println("student = " + student);
     ```

### 8.2 传入多个参数

#### 8.2.1 [必须掌握] 多个参数-使用@Param命名参数。

- 当 Dao 接口方法多个参数，需要通过名称使用参数。在方法形参前面加入<mark>@Param(“自定义参数名”)</mark>， mapper 文件使用<mark>#{自定义参数名}。</mark>

- **重点 ：这里必须保证mapper 文件使用<mark>#{自定义参数名}。</mark>中的自定义参数名与 <mark>@Param(“自定义参数名”)</mark>中的自定义参数名一致。**

- 定义格式：

  ```java
  // 在接口中，使用 @Param(“自定义参数名”) 形式
  public List<Student> selectMulitParam(@Param("myname") String name , 											  @Param("myage") Integer age);
  ```

  ```xml
  <!--mapper文件中，使用#{自定义参数名}形式。-->
  <select>
  	select * from student where name = #{myname} or age = {myage}
  </select>
  ```

- 使用@Param命名参数传递多个参数

  第一步 ：创建包含多个参数的接口

  <img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210815175421.png"  />

  第二步 ： 创建传递多个参数的查询语句。

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210815200206.png)

**注意 ：必须保证接口中的自定义参数名 与 mapper文件中的自定义参数名一致**

​	第三步 :  使用测试类传递参数，将参数传递给 mapper文件返回最后的结果。

​	<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210815200904.png" style="zoom:80%;" />

​	**以上查询的是 ： <mark>名字是程云博</mark>以及<mark>年龄是50</mark>的student数据。**

#### 8.2.2 [用的最多] 多个参数-使用对象传递参数。

- 使用 java 对象传递参数， java 的属性值就是 sql 需要的参数值。 每一个属性就是一个参数。

- 语法格式 ：

  ```java
   #{ property,javaType=java 中数据类型名,jdbcType=数据类型名称 }
  // javaType, jdbcType 的类型 MyBatis 可以检测出来，一般不需要设置。
  // 常用格式 
  #{ property }
  ```

  第一步 ：先创建一个Java类，使用这个Java类的对象中的属性值来传递参数信息。

  <img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210815214341.png" style="zoom:80%;" />

  **注意 ：在这个类中要声明属性值，以及无参构造，以及set/get方法。**

  第二步 ： 在dao接口中创建一个参数为以上QueryParma类的对象的抽象方法。

  <img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210815214551.png" style="zoom:80%;" />

  **注意 ：这个返回值是一个Student对象集合，而不是QueryParma对象集合。**

  **注意 ：这个并不一定非要创建出另外一个类，使用现有的Student类完全没问题。只不过是其中的属性值的数量不同**

  第三步 ： 在mapper文件中，创建使用该抽象方法查询数据库的SQL语句。

  <img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210815215108.png" style="zoom: 67%;" />

  javaType对应的就是 ：这个数据类型的 全限定名称 java.lang.String。

  jdbcType对应的就是 ：由mybatis提供的（见下表）

  ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210815203602.png)

  **注意 ：这个语句有原始语句与简写语句之分。**

  **原始语句 ：**

  <img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210815215242.png" style="zoom: 67%;" />

  **简化语句 ：**

  <img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210815215320.png" style="zoom: 67%;" />

  **注意 ：mapper文件中的<mark>定位符#{自定义名称}</mark>，必须和QueryParma（传递参数的类）类中属性值的名称一致**

  第四步 ：使用测试类来创建传递参数的QueryParma对象，输出查询结果

  <img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210815222033.png" style="zoom:80%;" />

  **以上查询出的是名称为程云博和年龄为50的数据。** 

#### 8.2.3 [了解] 多个参数-按位置

- 参数位置从 0 开始， <mark>引用参数语法 #{ arg 位置 }</mark> ， 第一个<mark>参数是#{arg0}</mark>, 第二个是<mark>#{arg1}</mark>
-  **注意：mybatis-3.3 版本和之前的版本使用#{0},#{1}方式， 从 mybatis3.4 开始使用#{arg0}方式。也就是现在使用的是 #{arg0}的语法格式。**
- **其中 agr是关键字，是固定的，不可以改变，只能改变这个位置信息。**

第一步：在接口中创建抽象方法

**注意 ：抽象方法中的参数从左到右进行编号，比如下边的这个参数，<mark>name位置是0</mark>，<mark>age是1。</mark>**

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20210816144419599.png" alt="image-20210816144419599" style="zoom:80%;" />

第二步 ：在mapper文件中创建SQL语句

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210816144319.png)

**注意 ：在<mark>mybatis3.4</mark>之后开始使用 <mark>#{arg0}</mark>的语法格式，我们这里使用的是3.5.7版本。** 

**注意 ：<mark>#{arg0}</mark>对应的是name，如果将name对应的<mark>#{arg0}</mark>改为<mark>#{arg1}</mark>，此时会将age的值传递给name，此时会赋值反。结果会变为 name = 20 age = 程云博。**

第三步 ：在测试类中显示查询结果

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210816145005.png" style="zoom:80%;" />

此时查询到的就是name是程云博或者年龄是20岁的信息。

#### 8.2.24[了解] 多个参数-使用Map

- Map 集合可以存储多个值，使用Map向 mapper 文件一次传入多个参数。
- Map 集合使用 <mark>String的 key</mark> ，<mark>Object 类型的值存储参数</mark>。
- **mapper 文件使用 <mark># { key } 引用参数值。</mark>**

第一步 ：在接口中创建抽象方法，使用的是Map集合，返回值是Student对象集合。

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210816154913.png" style="zoom:80%;" />

第二步 ：在mapper文件中创建SQL语句 <mark>语法格式 ：#{map的key值}</mark>

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210816155008.png)

**注意 ：这个key值必须和测试类中创建的Map中的key值一致。**

第三步 ：在测试类中显示查询结果

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210816155202.png" style="zoom:80%;" />

**注意  :  在我们日常的开发中，不建议参数是Map集合，因为什么信息也表达不出来，可读性差，不建议使用。**

- **以上四种传递多个参数的方式，我们<mark>掌握前两个</mark>即可，后两个作为了解。**

## 9. 两个占位符比较 （\#和$的区别）

- #与$所实现的效果是一样的，只是内部执行的方式不一样。

### 9.1 #占位符

- <mark>#：占位符</mark>，**告诉 mybatis 使用实际的参数值代替。**并使用 **PrepareStatement 对象**执行 sql 语句,

- <mark>#{…}代替 sql 语句的“?”</mark>。这样做更安全，更迅速，通常也是首选做法。

- ```xml
  <!--maper 文件，使用的是 #占位符-->
  <select id="selectById" resultType="com.yunbocheng.entity.Student">
   select id,name,email,age from student where id=#{studentId}
  </select>
  ```

- ```xml
  <!--转为 MyBatis 的执行是：-->
  String sql=” select id,name,email,age from student where id=?”;
  PreparedStatement ps = conn.prepareStatement(sql);
  ps.setInt(1,1005);
  ```

- ```xml
  <!--解释：-->
  where id=? 就是 where id=#{studentId}
  <!--此时#{studentId}会替换掉?-->
  ps.setInt(1,1005) , 1005 会替换掉 #{studentId}
  ```

### 9.2 $ 字符串替换

- <mark>$ 字符串替换</mark>，告诉 mybatis 使用<mark>$包含的“字符串”替换所在位置</mark>。

- 使用 <mark>Statement对象把 sql 语句和${}中的内容连接起来</mark>。

- $:可以替换表名或者列名， 你能确定数据是安全的。可以使用$

- **注意 ：使用$符号的时候是完成字符串的拼接，此时必须满足SQL语句的格式。**

  ![image-20210816163831535](https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20210816163831535.png)

  此时需要使用<mark>" '李四' "</mark>这种格式，才能保证拼接完的字符是以下格式(正确的SQL格式)

  ![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210816164016.png)

**将两个语句放在一起比较**

```
<!--使用 #占位符的结果-->
<!--这个原理是 ：将#{studentId}代表的值替换掉SQL语句中的 ? 占位符-->
<!--替换-->
select id,name, email,age from student where id=#{studentId}
 	# 的结果： select id,name, email,age from student where id=? 

<!--使用 $字符串拼接的结果-->
<!--这个原理是 ：将${studentId}代表的值拼接到SQL语句最后的 id = 的后边-->
<!--拼接-->
select id,name, email,age from student where id=${studentId}
	$ 的结果：select id,name, email,age from student where id=1001
```

### 9.3 # 与 的区别（面试题）

- #使用 ？在sql语句中做站位的， 使用PreparedStatement执行sql，效率高
- #能够避免sql注入，更安全。
- $不使用占位符，是字符串连接方式，使用Statement对象执行sql，效率低
- $有sql注入的风险，缺乏安全性。
- $:可以替换表名或者列名

## 10.封装MyBatis输出结果

- MyBatis执行完sql，怎么将sql语句的执行结果变成一个java对象。

### 10.1 定义自定义类型的别名（比如对象）

1. 在<mark>mybatis主配置文件</mark>中定义，使<typeAlias>定义别名

2. 可以在<mark >resultType中使用自定义别名。

   ```xml
   <typeAliases>
   	<!--
   		定义别名的第一种方式
   		可以指定一个类型一个自定义别名
   		type : 自定义类型的全局限定名称
   		alias ：别名 （短小、容易记忆的）
   	-->
   	<!--可以在这里边同时定义多个别名也就是 typeAlias-->
   	<typeAlias type="com.yunbocheng.entity.Student" alias="stu"/>
   
   	<!--
   		定义别名的第二种方式
   		<package> name是包名，这个包中的所有类，类名就是别名(类名不区分大小写)
   	-->
   	<package name="com.yunbocheng.entity"/>
   </typeAliases>
   ```

- **不建议使用别名，建议使用全限定名称**。全限定名称更安全。因为如果使用通过<mark>定义包名的方式定义别名</mark>，可能在两个包中都存在Student类，此时返回值使用Student，那不此时不能确定是哪个包中的Student别名。使用的时候会报错，发生奇异。不能确定的到底是使用的哪个包中的Student别名。

### 10.2 resultType

- <mark>resultType</mark> : (结果类型)执行 sql 得到 ResultSet 转换的类型，使用类型的<mark>完全限定名</mark>或<mark>别名。</mark> 
- <mark>别名是 mybatis 给出的</mark>，比如 ：**全限定名称 java.lang.Interger对应的别名是 INTEGER。**
- 如果<mark>resultType返回值是一个对象，</mark>比如返回值是一个Student对象，此时的resultType返回值可以使用全限定名称。**com.yunbocheng.entity.Student。**也可以使用别名。别名定义方式在上边。
- 注意如果返回的是<mark>集合</mark>，那应该设置为集合包含的类型，而不是集合本身。
- **resultType 和 resultMap，不能同时使用。**

- resultType结果类型， 指sql语句执行完毕后， 数据转为的java对象， java类型是任意的。

**resultType处理方式：**

1. mybatis执行sql语句， 然后mybatis调用类的无参数构造方法，创建对象。
2. mybatis把ResultSet指定列值付给同名的属性。

```xml
<!--mapper文件中的语句，Mybatis动态代理-->
<select id="selectMultiPosition" resultType="com.bjpowernode.domain.Student">
  select id,name, email,age from student
</select>

<!--以上MyBatis动态代理对等的jdbc代码-->
ResultSet rs = executeQuery(" select id,name, email,age from student" )
while(rs.next()){
	Student student = new Student();
    student.setId(rs.getInt("id"));
    student.setName(rs.getString("name"));
    student.setEmail(rs.getString("email"));
    student.setAge(rs.getInt("age"));
}
```

#### 10.2.1 resultType返回一个简单类型

第一步 ：定义接口中的方法

```java
int countStudent();
```

第二步 ：mapper 文件：

**注意：返回值类型可以是全限定名称也可以是别名。**

```xml
<!--此时 resultType 的返回值是一个int类型，代表查询到的结果数-->
<select id="countStudent" resultType="int">
 select count(*) from student
</select>
```

第三步 ：测试方法

```java
@Test
public void testRetunInt(){
 int count = studentDao.countStudent();
 System.out.println("学生总人数："+ count);
}
```

#### 10.2.2 resultType返回一个对象类型(推荐使用)	

第一步 ：接口中的抽象方法

```java
Student selectById(int id);
```

第二步 ：mapper文件

```xml
<!--此时返回的结果是一个Student对象-->
<select id="selectById" resultType="com.bjpowernode.domain.Student">
	 select id,name,email,age from student where id=#{studentId}
</select>
```

这个是时候会使用框架处理 ：使用构造方法创建对象。调用 setXXX 给属性赋值。

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210816202536.png" style="zoom:80%;" />

- **注意：Dao 接口方法返回是<mark>集合类型</mark>，需要<mark>指定集合中的类型，不是集合本身。</mark>**

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210816202809.png" style="zoom:80%;" />

- 这个java对象可以是任意的，此时就将这个查询结果赋给一个ViewStudendnt对象。

![image-20210816200008750](https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20210816200008750.png)

第三步 ：测试程序

```java
@Test
public void testSelectStudent(){
StudentDao studentDao = new StudentDaoImpl();
List<Student> students = studentDao.testSelect();
	for (Student student : students) {
    	System.out.println(student);
    }
}
```

#### 10.2.3 resultType返回一个Map类型	

- **sql 的查询结果作为 Map 的 <mark>key 和 value</mark>。推荐使用 <mark>Map<Object,Object></mark>。**
- **注意：Map 作为<mark>接口返回值</mark>，sql 语句的查询结果<mark>最多只能有一条</mark>记录。大于一条记录是错误。**

第一步 ：接口定义抽象方法返回Map

```Java
Map<Object,Object> selectReturnMap(int id);
```

第二步 ：mapper文件 (返回值map的全限定名称是 java.util.HashMap或者是别名map)

```xml
<!--此时返回值是一个Map集合，且这个集合中只能有一条记录。推荐使用Map<Object,Object>-->
<select id="selectReturnMap" resultType="java.util.HashMap">
 	select id,name from student where id = #{studentId}
</select>
```

第三步 ：测试方法(返回的结果是：列名是map的key，列值是map的value)。

```Java
@Test
public void testReturnMap(){
 	Map<Object,Object> retMap = studentDao.selectReturnMap(1002);
 	System.out.println("查询结果是 Map:"+retMap);
}
```

**注意 ：上边SQL语句获取的是id,name的字段值。所以传递到Map集合中的是<id,name>。** 

**返回的结果是 ：<mark>查询的结果是 Map : {name=李四, id=1001}</mark>。**查询的结果是:<mark>{列名=列值，列名=列值}的格式</mark>。

以上查询到的是两个key，如果是多个key，其map就是多增加列名和列值。

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210817081842.png)

 **注意 ：使用map只能返回一行数据，返回大一一行的数据会报错，是错误的。**

### 10.3 resultMap

- resultMap : <mark>结果映射</mark>， 指定<mark>数据库中数据的列名</mark>和<mark>java对象的属性</mark>对应关系。

- resultMap的作用 ：
  1. 你自定义列值赋值给哪个属性。
  2. 当你的列名和属性名不一样时，一定使用resultMap。
- 这个返回值类型主要解决列名和属性名不一样的问题。

第一步 ：创建一个接口的抽象方法

```java
/**
* 使用resultMap定义映射关系
*/
List<Student> selectAllStudents();
```

第二步 ：mapper文件

```xml
<!--使用resultMap
    1. 先定义一个resultMap
    2. 在select标签中，使用resultMap来调用已定义的resultMap。
-->
<!--定义resultMap
    id : 自定义名称，表示定义的这个resultMap
    type : java类型的全限定名称。相当于以前select的resultType。
-->
<resultMap id="studentMap" type="com.yunbocheng.entity.Student">
    <!--数据库中的列名和java属性的关系-->
    <!--主键列，使用id标签
        column : 数据库中的列名
        property : java类型的属性名
	-->
    <id column="id" property="id"/>
    <!--非主键列，使用result标签-->
    <result column="name" property="name"/>
    <result column="email" property="email"/>
    <result column="age" property="age"/>
</resultMap>
<!--此时这个 resultMap的值就是这个id值studentMap-->
<select id="selectAllStudents" resultMap="studentMap">
    select id,name,email,age from student;
</select>
```

第三步 ：测试类 (返回值是一个List<Student>集合)

```java
@Test
public void testSelectAllStudents(){
    // 使用工具类获取到SqlSession对象
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    // 使用mybatis动态代理模式获取到dao的实现类对象
    StudentDao dao = sqlSession.getMapper(StudentDao.class);
    // 使用dao的是实现类对象来调用其中的抽象方法。
    List<Student> students = dao.selectAllStudents();
    for (Student student : students) {
        System.out.println(student);
    }
}
```

**注意 ：resultMap和resultType不要一起用，二选一。**

## 11.解决实体类属性名与列名不同的处理方式

### 11.1 使用列别名和 resultType（第一种方式）

**使用方式**

- 第一步 ：创建新的实体类

```java
package com.yunbocheng.entity;
public class PrimaryStudent {
 private Integer stuId;
 private String stuName;
 private Integer stuAge;
 // 省略了 set , get 以及toString方法
```

- 第二步 ：接口方法 (返回一个不是Student对象的LIst集合)

```java
List<PrimaryStudent> selectUseFieldAlias(QueryParam param);
```

- 第三步 ：mapper文件

```xml
<select id="selectUseFieldAlias" 
resultType="com.yunbocheng.entity.PrimaryStudent">
 	select id as stuId, name as stuName,age as stuAge
 	from student where name=#{queryName} or age=#{queryAge}
</select>
```

- 测试方法

```java
@Test
public void testSelectUseFieldAlias(){
 QueryParam param = new QueryParam();
 param.setQueryName("程云博");
 param.setQueryAge(20);
 List<PrimaryStudent> stuList;
 stuList = studentDao.selectUseFieldAlias(param);
 stuList.forEach( stu -> System.out.println(stu));
}
```

### 11.2 使用 resultMap

**使用方式**

- 接口方法

```java
List<PrimaryStudent> selectUseDiffResultMap(QueryParam param);
```

- mapper文件 (使用定义别名的方式)

```xml
<!-- 创建 resultMap
 id:自定义的唯一名称，在<select>使用
 type:期望转为的 java 对象的全限定名称或别名 
-->
<resultMap id="primaryStudentMap" 
type="com.yunbocheng.entity.PrimaryStudent">
 <!-- 主键字段使用 id -->
 <id column="id" property="stuId" />
 <!--非主键字段使用 result-->
 <result column="name" property="stuName"/>
 <result column="age" property="stuAge" />
</resultMap>
<!--resultMap: resultMap 标签中的 id 属性值-->
<select id="selectUseDiffResultMap" resultMap="primaryStudentMap">
 select id,name,email,age from student
 where name=#{queryName} or age=#{queryAge}
</select>
```

- 测试方法

```java
@Test
public void testSelectUseDiffResultMap(){
 QueryParam param = new QueryParam();
 param.setQueryName("程云博");
 param.setQueryAge(20);
 List<PrimaryStudent> stuList;
 stuList = studentDao.selectUseDiffResultMap(param);
 stuList.forEach( stu -> System.out.println(stu));
}
```

## 12. 模糊查询like

### 12.1 模糊查询的第一种方式 （推荐使用）

- **第一种方式 ：在Java代码指定 like 的内容。**

**实现方式**

- 第一步 ：接口中创建方法 （返回值是一个Student对象的List集合）传递的参数是模糊的名字

```java
/**
* 第一种模糊查询
* 在Java代码指定 like 的内容。
*/
public List<Student> selectLikeOne(String name);
```

- 第二步 ：mapper文件中创建SQL查询语句 （这里使用 #{} 占位符格式）

```xml
<!--第一种like,java代码指定 like内容-->
<select id="selectLikeOne" resultType="com.yunbocheng.entity.Student">
    select id,name,email,age from student where name like #{name};
</select>
```

- 第三步 ：测试方法，使用模糊查询查询结果，此时使用的是模糊查询语句 <mark>"%程%"</mark>，%代表前边有任意个字符，即使没有字符也可以的，只要名字里边有<mark>程</mark>这个字符即可查询出来。

```java
@Test
public void selectSelectLikeOne(){
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    StudentDao dao = sqlSession.getMapper(StudentDao.class);
    // 准备好like的内容，使用dao接口的实现类对象调用方法
    String name = "%程%";
    List<Student> students = dao.selectLikeOne(name);
    for (Student student : students) {
        System.out.println("查询到的学生 ：" + student);
    }
}
```

**查询到的结果 ：**

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210817215010.png" style="zoom:80%;" />

### 12.2 模糊查询的第一种方式 

- **在mapper文件中拼接 like 的内容**

**实现方式**

- 接口方法

```java
/**
 * 第二种模糊like查询的方法
 * name就是 程 这个值，在mapper文件中拼接 like %程% 
 */
List<Student> selectLikeTwo(String name);
```

- mapper文件

```xml
<!--第二种方式 ：在mapper文件中拼接like内容 %程%-->
<!--如果要求查询的第一个字符是程，那么就不写第一个 "%"-->
<!--注意 ：这个"%"与#{name}之间的空格必须存在-->
<!--这个name为查询的值，比如 程，这样拼接之后就是 %程%-->
<select id="selectLikeOne" resultType="com.yunbocheng.entity.Student">
    select id,name,email,age from student where name like "%" #{name} "%";
</select>
```

- 测试方法

```java
@Test
public void selectSelectLikeTwo(){
    SqlSession sqlSession = MyBatisUtils1.getSqlSession();
    StudentDao dao = sqlSession.getMapper(StudentDao.class);
    // 准备好like的内容，使用dao接口的实现类对象调用方法
    String name = "李";
    List<Student> students = dao.selectLikeOne(name);
    for (Student student : students) {
        System.out.println("查询到的学生 ：" + student);
    }
}
```

- 测试结果

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20210817220512104.png" alt="image-20210817220512104"  />

 

## 13.动态sql概念

- <mark>动态sql</mark> : sql的内容是变化的，可以根据条件获取到不同的sql语句。
- **主要是where部分发生变化。**
- 动态sql的实现，使用的是<mark>mybatis提供的标签</mark>:
  - **if 标签**
  - **where 标签**
  - **foreach 标签**

- 动态 SQL，通过 MyBatis 提供的各种标签对条件作出判断以实现动态拼接 SQL 语句。这里的条件判 断使用的表达式为 OGNL 表达式。常用的动态 SQL 标签有、、、等。 MyBatis 的动态 SQL 语句，与 JSTL 中的语句非常相似。 动态 SQL，主要用于解决查询条件不确定的情况：在程序运行期间，根据用户提交的查询条件进行 查询。提交的查询条件不同，执行的 SQL 语句不同。若将每种可能的情况均逐一列出，对所有条件进行 排列组合，将会出现大量的 SQL 语句。此时，可使用动态 SQL 来解决这样的问题
- 在 mapper 的动态 SQL 中若出现大于号（>）、小于号（<）、大于等于号（>=），小于等于号（<=）等 符号，最好将其转换为实体符号。否则，XML 可能会出现解析出错问题。
- **特别是对于小于号（<），在 XML 中是绝不能出现的。否则解析 mapper 文件会出错。**

### 13.1 if 标签

- **if 是判断条件的。**
- **if中存在一个问题，就是可能发生SQL语句拼接错误。Where标签会解决这个问题。**
- **语法格式：**

```xml
<if test="判断java对象的属性值">
	部分sql语句
</if>
```

**对于该标签的执行，当 test 的值为 true 时，会将其包含的 SQL 片断拼接到其所在的 SQL 语句中。 语法： sql 语句的部分** 

**实现方式**

- 第一步 ：创建接口中的抽象方法（<mark>注意 : sql动态代理动态sql要使用java对象作为参数</mark>）

```java
/*
    测试动态sql中的 if 标签
    动态sql要使用java对象作为参数
*/
List<Student> selectStudentIf(Student student);
```

- 第二步 ：在mapper文件中使用动态sql语句。

- 下边代码中存在一个小技巧<mark>id > 0</mark>，这个代码的作用是为了：使当输入的name不满足条件时可以拼接出正确SQL语句。**因为表中的所有id都是大于0的 ，不影响查询结果。** **这个小技巧不一定非得是id>0，只要是true的表达式即可。比如：<mark>1=1</mark> 都可以的。**

- 当name不满足条件时，不使用<mark>id>0</mark>，拼接的字符串是 ：

  ```xml
  select id,name,email,age from student where and age > ?; //不符合SQL语句格式,会报错。
  ```

- 当name不满足条件时，使用<mark>id>0</mark>，拼接的字符串是 ：

  ```xml
  select id,name,email,age from student where id>0 and age > ?; 
  //因为表中的所有id都是大于0的 ，不影响查询结果，此时符合SQL语句格式。
  ```

```xml
<!--if标签
    <if : test="使用接口中参数Java对象的属性值作为i判断条件">
    语法格式 ：属性=xxx值 （当然也可以是 属性!=xxx值）
-->
<select id="selectStudentIf" resultType="com.yunbocheng.entity.Student">
    select id,name,email,age from student
    where id > 0
    <if test="name != null and name != '' ">
        name = #{name} 
    </if>
    <if test="age > 0">
        and age > #{age};
    </if>
</select>
```

**以上语句拼接出的SQL语句是：**

```mysql
select id,name,email,age from student where name = ? and age > ?; //?占位符 
```

- 第三步 ：测试方法

```java
// 测试if标签
@Test
public void testSelectStudentIf(){
    SqlSession sqlSession = MyBatisUtils1.getSqlSession();
    StudentDao dao = sqlSession.getMapper(StudentDao.class);
    Student student = new Student();
    student.setName("");
    student.setAge(10);
    List<Student> students = dao.selectStudentIf(student);
    for (Student student1 : students) {
        System.out.println("if===" + student1);
    }
}
```

- 输出的结果是：

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210817231518.png)

### 13.2 where 标签

-  <mark>where标签</mark> : where标签是用来<mark>包含多个if的</mark>
- <mark>where的作用</mark> **：当多个if有一个成立的，where会自动增加一个where关键字体。并且去掉多余的拼接属性字符，比如 ：and  or 等。**

**实现方式：**

- 第一步 ：创建接口中的抽象方法（<mark>注意 : sql动态代理动态sql要使用java对象作为参数</mark>）

```java
/**
 * 测试动态sql中的 where 标签
 * 动态sql要使用java对象作为参数
 */
List<Student> selectStudentWhere(Student student);
```

- 第二步 ：在mapper文件中使用动态sql语句。
- 使用where标签会自动帮我们添加where关键字并且消除多余的or、and语句。如下语句：

![image-20210818210800061](https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20210818210800061.png)

**即使我们传递的名字是一个空的，这个时候也会拼接出正确的SQL，不会报错**

```xml
<select id="selectStudentWhere" resultType="com.yunbocheng.entity.Student">
    select id,name,email,age from student
    <where>
        <if test="name != null and name != '' ">
            name = #{name}
        </if>
        <if test="age > 0">
        and age > #{age};
        </if>
    </where>
</select>
```

- 第三步 ：测试方法

```java
// 测试where标签
@Test
public void testSelectStudentWhere() {
    SqlSession sqlSession = MyBatis.getSqlSession();
    StudentDao dao = sqlSession.getMapper(StudentDao.class);
    Student student = new Student();
    student.setName("");
    student.setAge(100);
    List<Student> students = dao.selectStudentWhere(student);
    for (Student student1 : students) {
        System.out.println(student1);
    }
}
```

### 13.3 foreach 语句

- foreach : 循环java中的数组，list集合的。 主要用在<mark>sql的in语句</mark>中。
      比如：查询id是 1001,1002,1003的三个学生。

```mysql
 select * from student where id in (1001,1002,1003);
```

- **标签用于实现对于<mark>数组</mark>与<mark>集合</mark>的遍历**
-  <mark>collection</mark> 表示要遍历的集合类型, list ，array 等。
-  <mark>open、close、separator</mark> 为对遍历内容的 SQL 拼接。
- **语法格式：**

```xml
<foreach collection="集合类型" open="开始的字符" close="结束的字符" 
item="集合中的成员" separator="集合成员之间的分隔符">
 	#{item 的值}
</foreach>
```

**参数解释：**

- **collection** :表示接口中的方法参数的类型， 如果是数组使用array , 如果是list集合使用list。
- **item:** 自定义的，表示数组和集合成员的变量
- **open**  :循环开始是的字符
- **close** :循环结束时的字符
- **separator** :集合成员之间的分隔符 

#### 13.3.1 遍历 List<简单类型>

- **表达式中的 List 使用 list 表示，其大小使用 list.size 表示。**

**实现方式需求：查询学生 id 是 1002,1005,1006**

-  第一步 ：接口中定义抽象方法 **参数是一个简单的Integer类型集合类型**

```java
List<Student> selectStudentForeach(List<Integer> stulist);
```

- 第二步 ：mapper文件

```xml
<!--
    测试foreach标签 此时遍历的是一个简单类型
-->
<select id="selectStudentForeach" resultType="com.yunbocheng.entity.Student">
    <!--此时item的值是一个属性，直接使用即可-->
    select id,name,email,age from student where id in
    <foreach collection="list" item="myid" open="(" close=")" separator=",">
        #{myid}
    </foreach>
</select>
<!--注意：这个collection中的liet与测试方法中的list没有关系。-->
```

- 第三步 ：测试方法

```java
// 测试foreach
@Test
public void testSelectForEachOne() {
    SqlSession sqlSession = MyBatis.getSqlSession();
    StudentDao dao = sqlSession.getMapper(StudentDao.class);
    List<Integer> list = new ArrayList<>();
    list.add(1002);
    list.add(1003);
    list.add(1004);
    List<Student> students = dao.selectStudentForeach(list);
    for (Student student1 : students) {
        System.out.println(student1);
    }
}
```

- 拼接的查询语句：使用foreach会自动拼接出这个<mark>in格式的SQL语句</mark>。
- 此时查询出的是一个<mark>id=1002，id=1003，id=1004</mark> 的所有学生。

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210818215931.png)

- 输出的结果：

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210818220031.png" style="zoom:80%;" />

#### 13.3.2 遍历 List<对象类型>

- 使用对象可以一次性向SQL语句中传递多个参数值。

- 自己创建两个对象，创建出一个对象集合，进行实现。
- 第一步：接口中的抽象方法 **参数是一个简单的对象集合类型**

```java
List<Student> selectStudentForeachTwo(List<Student> stuList);
```

- 第二步 ：mapper文件

```xml
<!--
    测试foreach遍历对象集合
-->
<select id="selectStudentForeachTwo" resultType="com.yunbocheng.entity.Student">
    select id,name,email,age from student where id in
    <!--此时stu是一个Student对象集合 这个stu与测试方法中的studentList没有关系-->
    <foreach collection="list" item="stu" open="(" close=")" separator=",">
        <!--这个语法格式是 ：对象.属性值 获取的是id属性的值，如果是 #{stu.name}此时获取的name属性-->
        #{stu.id}
    </foreach>
</select>
```

- 第三步 ：测试方法

```java
// 测试foreach遍历对对象集合
@Test
public void testSelectForEachTwo() {
    SqlSession sqlSession = MyBatis.getSqlSession();
    StudentDao dao = sqlSession.getMapper(StudentDao.class);
    //定义一个Student对象集合
    List<Student> studentList = new ArrayList<>();
    // 创建第一个Student对象
    Student student1 = new Student();
    // 给id属性赋值
    student1.setId(1002);
    // 将这个对象加入到Student对象集合中
    studentList.add(student1);
    // 创建第二个Student对象
    Student student2 = new Student();
    student2.setId(1003);
    studentList.add(student2);
    // 此时对象集合中有两个对象（student1 student2）
    List<Student> studentList1 = dao.selectStudentForeachTwo(studentList);
    for (Student student : studentList1) {
        System.out.println(student);
    }
}
```

- **拼接的SQL语句**。**此时查询的是id=1002，id=1003的学生**

![image-20210818225305490](https://gitee.com/YunboCheng/imageBad/raw/master/image/image-20210818225305490.png)

- **输出的结果：**

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210818225522.png" style="zoom:80%;" />

#### 13.3.3 foreach很灵活

- 修改mapper文件，我们可以不使用 <mark>open以及close属性</mark>，我们自己拼接这个SQL语句。就是这个语句。我们不使用<mark>open="("  和  close=")"</mark>，而是自己拼接这个开始和结束字符。

```java
<select id="selectStudentForeachTwo" resultType="com.yunbocheng.entity.Student">
    select id,name,email,age from student where id in (
    <!--此时stu是一个Student对象集合 这个stu与测试方法中的studentList没有关系-->
    <foreach collection="list" item="stu" separator=",">
        <!--这个语法格式是 ：对象.属性值 获取的是id属性的值，如果是 #{stu.name}此时获取的name属性-->
        #{stu.id}
    </foreach>
    )
</select>
```

- 使用以上我们手动拼接的SQL语句与使用<mark>open和colse属性</mark>拼接出的SQL语句是一样的。

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210820192709.png)

### 13.4 动态sql-代码片段

- <mark>sql标签</mark>用于定义 SQL 片断，以便其它 SQL 标签复用。而其它标签使用该 SQL 片断，需要使用 <mark>子标签</mark>。该标签可以定义 SQL 语句中的<mark>任何部分</mark>，所以子标签可以放在动态 SQL 的任何位置。
- <mark>sql代码片段</mark>，就是复用一些语法，我们在实际的开发过程中，难免会书写重复的SQL语句，这个重复的SQL语句可能是一整条SQL语句，也可能是SQL语句的一部分，我们这个时候可以使用<mark>动态sql-代码片段</mark>的方式将这个些重复的SQL语句包装起来，定义一个id属性，便于我们以后使用。
- 在一个mapper文件中可以定义<mark>多个代码片段</mark>

**使用方式**

1. 先在mapper文件中定义 <sql id="自定义名称唯一">  sql语句， 表名，字段等 </sql>
2. 再使用， <include refid="id的值" />

**实现方式**

- 定义接口中的抽象方法，

```java
<!--这个定义一个 if标签 方法-->
List<Student> selectStudentIf(Student student);

<!--这个定义一个 where标签 方法-->
List<Student> selectStudentWhere(Student student);    
```

- 修改mapper文件,以下两个SQL语句中都需要<mark>select id,name,email,age from student</mark>。这个语句，我们此时将这个语句放在动态sql-代码片段中，定义一个别名，可以让我们重复使用。

```xml
<!--定义sql片段，给以下这段代码定义为动态片段，定义一个别名，以后代码可以重复利用-->
<sql id="studentSql">
    
</sql>

<!--以下代码是使用 if标签 查询数据的SQL语句-->
<select id="selectStudentIf" resultType="com.yunbocheng.entity.Student">
    <include refid="studentSql"/>
    where id>0 and
    <if test="name != null and name != '' ">
        name = #{name}
    </if>
    <if test="age > 0">
     and  age > #{age};
    </if>
</select>

<!--以下代码是使用 where标签 查询数据的SQL语句-->
<select id="selectStudentWhere" resultType="com.yunbocheng.entity.Student">
    <include refid="studentSql"/>
    <where>
        <if test="name != null and name != '' ">
            name = #{name}
        </if>
        <if test="age > 0">
        and age > #{age};
        </if>
    </where>
</select>
```

- 测试方法，以下我们只测试一个，测试结果和以前一样不。

```java
// 测试sql-代码片段
@Test
public void testSelectStudentIf() {
    SqlSession sqlSession = MyBatis.getSqlSession();
    StudentDao dao = sqlSession.getMapper(StudentDao.class);
    Student student = new Student();
    student.setName("程云博");
    student.setAge(10);
    List<Student> students = dao.selectStudentIf(student);
    for (Student student1 : students) {
        System.out.println("if===" + student1);
    }
}
```

- **查询结果，我们可以看到查询结果是和不使用动态代码的结果是一样的。**

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210820200219.png" style="zoom:80%;" />



- 我们还可以定义一段类名或者代码片段

```xml
<!--定义一个只包含列名的代码片段-->
<sql id="studentOne">
    id,name,email,age  
</sql>

<!--使用动态代码片段创建SQL语句-->
<select id="selectStudentIf" resultType="com.yunbocheng.entity.Student">
    select <include refid="studentOne"/> from student
    where id>0 and
    <if test="name != null and name != '' ">
        name = #{name}
    </if>
    <if test="age > 0">
     and  age > #{age};
    </if>
</select>
```

- **这样我们需要自己拼接剩余的SQL。**

## 14.MyBatis配置文件

### 14.1 主配置文件

- **之前项目中使用的 mybatis.xml 是主配置文件。**

- 主配置文件特点：

  1. xml 文件，需要在头部使用约束文件

  ```xml
  <?xml version="1.0" encoding="UTF-8" ?>
  <!DOCTYPE configuration
   PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
   "http://mybatis.org/dtd/mybatis-3-config.dtd">
  ```

  2. 根元素，configuration
  3. 主要包含内容：  <mark>定义别名</mark>  <mark>数据源</mark>  <mark>mapper 文件</mark>

### 14.2 dataSource 标签

- Mybatis 中访问数据库，可以连接池技术，但它采用的是自己的连接池技术。
- 在 Mybatis 的 mybatis.xml 配置文件中，通过来实现 Mybatis 中连接池的配置。

#### 14.2.1  dataSource 类型

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210820205104.png" style="zoom:80%;" />

上图看出 Mybatis 将数据源分为三类：

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210820204612.png" style="zoom: 67%;" />

其中 UNPOOLED ,POOLED 数据源实现了 javax.sq.DataSource 接口， JNDI 和前面两个实现方式不同，了解可以。

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210820205234.png)

#### 14.2.2 dataSource 配置

- **在 MyBatis.xml 主配置文件，配置 dataSource**

```xml
<dataSource type="POOLED">
 <!--连接数据库的四个要素-->
 <property name="driver" value="com.mysql.jdbc.Driver"/>
 <property name="url" 
value="jdbc:mysql://localhost:3306/ssm?charset=utf-8"/>
 <property name="username" value="root"/>
 <property name="password" value="123456"/>
</dataSource>
```

**MyBatis 在初始化时，根据的 type 属性来创建相应类型的的数据源 DataSource**

-  type=”POOLED”：MyBatis 会创建 PooledDataSource 实例
- type=”UNPOOLED” ： MyBatis 会创建 UnpooledDataSource 实例 
- type=”JNDI”：MyBatis 会从 JNDI 服务上查找 DataSource 实例，然后返回使用

### 14.3 事务

#### 14.3.1  默认需要手动提交事务

- **Mybatis 框架是对 JDBC 的封装**，所以 Mybatis 框架的事务控制方式，本身也是用 JDBC 的 Connection 对象的 commit(), rollback() 。
- Connection 对象的 setAutoCommit()方法来设置事务提交方式的。**自动提交和手工提交**

```xml
<transactionManager type="JDBC"/>
```

- 该标签用于指定 MyBatis所使用的事务管理器。MyBatis 支持两种事务管理器类型：**JDBC 与 MANAGED。**

- <mark>JDBC</mark>：使用 JDBC 的事务管理机制。即，通过 Connection 的 commit()方法提交，通过 rollback()方法 回滚。但默认情况下，MyBatis 将自动提交功能关闭了，改为了手动提交。即程序中需要显式的对 事务进行提交或回滚。从日志的输出信息中可以看到。

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210820205654.png" style="zoom:67%;" />

- <mark>MANAGED</mark>：由容器来管理事务的整个生命周期（如 Spring 容器）。

<img src="https://gitee.com/YunboCheng/imageBad/raw/master/image/20210820202613.png" style="zoom: 50%;" />

#### 14.3.2 自动提交事务

- **设置自动提交的方式，factory 的 openSession() 分为有参数和无参数的。**

![](https://gitee.com/YunboCheng/imageBad/raw/master/image/20210820205821.png)

- 有参数为 true，使用自动提交，可以修改 MyBatisUtil 的 getSqlSession()方法。

```java
session = factory.openSession(true);
```

- 再执行 insert 操作，无需执行 session.commit(),事务是自动提交的

### 14.4  数据库属性配置文件

- 为了**方便对数据库连接的管理**，<mark>DB（数据存储单位）连接四要素数据</mark>一般都是存放在一个专门的属性文件中的。MyBatis 主配置文件需要从这个属性文件中读取这些数据。

- 目的是便于修改、保存、处理多个数据库的信息。
- 这样做的目的是<mark>不用修改Mybatis文件</mark>，只需要修改<mark>properties配置文件</mark>即可。
- 这样可以在一个<mark>properties配置文件</mark>中<mark>创建连接多个数据库信息</mark>，在主配置文件中想使用哪个数据库直接修改即可。可以更加方便的维护mybatis主配置文件。

**使用方式**

1. **在 resources 路径下，创建 properties 文件，在这个创建一个jdbc.properties配置文件**

   在<mark>resources 目录创建 xxxx.properties</mark> 属性配置文件，文件名称自定义。

   例如：jdbc.properties

   在属性配置文件中，定义数据，<mark>格式是 ：key = value </mark>  （其中key和value是自定义的）

   key : 一般使用 ，做多级目录的（一般使用两级到三级的）。 例如 ： <mark>jdbc.mysql.driver</mark> 或者 <mark>jdbc.deiver</mark>。如果不想这个使用，使用<mark>mydriver </mark> 也完全没有问题。

   ```java
   jdbc.driver=com.mysql.jdbc.Driver
   jdbc.url=jdbc:mysql//.....
   jdbc.username=root
   jdbc.password=123456
   ```

2. **在mybatis的主配置文件，使用<properties> 指定文件的位置 。**在需要使用值的地方<mark>${key}</mark>

   ```xml
   <!--指定properties配置文件所在的位置，从类路径根开始找文件-->
   <!--这个类路径的根路径就是这个resources 文件-->
   <!--修改主配置文件，文件开始位置加入-->
   <configuration>
   	<properties resource = "jdbc.properties" />
   ```

3. **使用 key 指定值，使用的格式是 ：<mark>${key}</mark>** 

   ```xml
   <!--其中key是 jdbc.properties 配置文件中的key-->
   <dataSource type="POOLED">
    <!--使用 properties 文件: 语法 ${key}-->
    <property name="driver" value="${jdbc.driver}"/>
    <property name="url" value="${jdbc.url}"/>
    <property name="username" value="${jdbc.username}"/>
    <property name="password" value="${jdbc.password}"/>
   </dataSource>
   ```

### 14.5  typeAliases（类型别名）

- **Mybatis 支持默认别名，我们也可以采用自定义别名方式来开发。**
- 主要使用在 ： <mark><select resultType="别名"></mark>

- **第一步 ：mybatis.xml 主配置文件定义别名：**

```xml
<typeAliases>
 <!--
 定义单个类型的别名
 type:类型的全限定名称
 alias:自定义别名 
 -->
 <typeAlias type="com.yunbocheng.entity.Student" alias="mystudent"/>

<!--
 批量定义别名，扫描整个包下的类，别名为类名（首字母大写或小写都可以）
 name:包名 
 -->
 <package name="com.yunbocheng.entity"/>
 <package name="...其他包"/>
</typeAliases>    
```

- **第二步 ：mapper.xml 文件，使用别名表示类型**

```xml
<select id="selectStudents" resultType="mystudent">
 select id,name,email,age from student
</select>
```

### 14.6  mappers（映射器）

#### 14.6.1 第一种方式 (使用mapper文件)mapper resource=" " 

- **mapper依一次只能指定一个文件**，如果有多个mapper文件，需要创建多个mapper文件。

- **使用相对于类路径的资源,从 classpath（Java文件）路径查找文件**

```xml
<!--resource代表这个项目的一个mapper文件地址，这个地址从Java根路径开始-->
<mapper resource="com/yunbocheng/dao/StudentDao.xml" /> 
```

#### 14.6.2  第二种方式(使用包名) package name=""

- **指定包下的所有 Dao 接口**

```xml
<!--name: xml文件(mapper文件)所在的包名，可以导入多个包名-->
<!--name：xml文件(mapper文件)所在的包名，这个包中的所有xml文件一次都能加载给mybatis-->
<package name="com.yunbocheng.entity"/>
<package name="com.yunbocheng.entity1"/>
<package name="com.yunbocheng.entity2"/>
```

- **注意：此种方法要求 Dao 接口名称和 mapper 映射文件名称相同(区分大小写)，且在同一个目录中。**

