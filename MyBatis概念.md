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

