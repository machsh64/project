<center><h2>喜迎20大网页制作</h2></center>

## 1. 简介

喜迎20大网页制作主要目的用于让我归纳近期学习的知识，其中spring ioc源码的手写加深记忆，对于web项目的制作结构进行深入理解

*servlet优化 

*使用反射进行组件间的组装 

*引入DispatcherServlet中央控制器 

*IOC进行控制反转

*Filter进行网页过滤 对网页编码进行规范，以及打开网页前进行事务的开启

*事务管理的思想（trans中进行 数据库的初始化默认不提交 数据库的手动提交 数据库提交失败回滚 将多个事务绑定在一起，防止数据的单个提交造成数据库数据混乱）

*Listener监听器获取web.xml文件中application.xml地址传入IOC进行组件的组装

*thymeleaf的深入了解使用

*request作用域 session作用域 Application作用域的 理解并应用

#### 1.1 基本信息

开发工具：IDEA

JDK版本：8

MySQL版本：8

Tomcat版本：8

maven版本：3.6.3

项目编码：UTF-8

#### 1.2 使用技术

*JavaEE：后台服务的实现

*Html,Css,Js：网页实现

*bootstrap,fontawesome,ajax.googleapis.com：网页组件，矢量图，字体的引用

*maven：打包

#### 1.3 项目概览

*basedao：数据库连接，基本功能实现类

*filters：拦截过滤器

*ioc：IOC控制反转安装组件

*listeners：网页监听器

*myspringmvc：中央控制器

*trans：事务管理

*util：工具类

*web20：项目服务的实现

## 2 项目结构

#### 1.1 项目架构

[![zYvnv8.png](https://s1.ax1x.com/2022/11/25/zYvnv8.png)](https://imgse.com/i/zYvnv8)

#### 1.2 数据库表设计 

[![zYT5Uf.png](https://s1.ax1x.com/2022/11/25/zYT5Uf.png)](https://imgse.com/i/zYT5Uf)

## 3 使用教程

### 方式一： 若在idea中配合tomcat运行 (需要完整项目源码)

#### 1.1 导入数据库表 

将 w20schdb.sql 在Mysql中导入

#### 1.2 修改 druid.properties 

在web20sch1.2/src/main/resources中 将文件druid.properties中 username 与 password 修改为本地mysql账号密码

#### 1.3 访问网站
 
tomcat初始访问路径为 http://localhost:8080/(配置后生成的Applection Context路径)/topic.do?operate=page&page=index

### 方式二： 若在本地tomcat中运行 (需要war包)

#### 1.1 导入数据库表 

将 w20schdb.sql 在Mysql中导入

##### 1.2 项目部署

将war包放在本地tomcat的webapps目录下 启动tomcat 完成war包解压

#### 1.3 修改 druid.properties 

在web20sch1.2-1.0-SNAPSHOT\WEB-INF\classes中 将文件druid.properties中 username 与 password 修改为本地mysql账号密码

#### 1.3 访问网站

启动tomcat 在浏览器中访问http://localhost:8080/web20sch1.2-1.0-SNAPSHOT/page.do?operate=page&page=index

### 3 默认初始账号

初始用户账号有3个 （loginId：w001 password：ok）（loginId：w002 password：ok）（loginId：w003 password：ok）
后期可在login界面注册添加更多用户

初始管理员账号为 （loginId：w001 password：ok） 
 不可在网页中进行添加
