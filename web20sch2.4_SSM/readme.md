<center><h2>喜迎20大网页制作</h2></center>

## 1. 简介

喜迎20大网页使用SSM框架进行开发，旨在学习完成ssm后的过渡

*servlet优化 

*thymeleaf的深入了解使用

*request作用域 session作用域 Application作用域的 理解并应用

#### 1.1 基本信息

开发工具：IDEA

JDK版本：8

MySQL版本：8

Tomcat版本：8

spring.version：5.3.1
     
项目编码：UTF-8

#### 1.2 使用技术

*JavaEE：后台服务的实现

*Html,Css,Js：网页实现

*bootstrap,fontawesome,ajax.googleapis.com：网页组件，矢量图，字体的引用

*ssm框架
#### 1.3 项目概览

*mapper：数据库交互接口

*interceptor：拦截器

*util：工具类

*web20：项目服务的实现

## 2 项目结构

#### 1.1 项目架构

[![zT5jMt.png](https://s1.ax1x.com/2022/12/16/zT5jMt.png)](https://imgse.com/i/zT5jMt)

#### 1.2 数据库表设计 

[![zYT5Uf.png](https://s1.ax1x.com/2022/11/25/zYT5Uf.png)](https://imgse.com/i/zYT5Uf)

## 3 使用教程

#### 1.1 导入数据库表 

将 w20schdb.sql 在Mysql中导入

#### 1.2 修改 druid.properties 

在web20sch1.2/src/main/resources中 将文件jdbc.properties中 username 与 password 修改为本地mysql账号密码

#### 1.3 访问网站

部署好项目之后访问 http://YourServerName:YourProt/projectName

### 3 默认初始账号

初始用户账号有3个 （loginId：w001 password：ok）（loginId：w002 password：ok）（loginId：w003 password：ok）
后期可在login界面注册添加更多用户

初始管理员账号为 （loginId：w001 password：ok） 
 不可在网页中进行添加
