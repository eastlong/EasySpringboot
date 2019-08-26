本文目录

<!-- TOC -->

- [1. SpringBoot Quick Start](#1-springboot-quick-start)
    - [1.1. springboot依赖](#11-springboot依赖)
    - [1.2. 编写SpringBoot引导类](#12-编写springboot引导类)
    - [1.3. 编写Controller](#13-编写controller)
    - [1.4. 测试](#14-测试)
- [2. 快速入门解析](#2-快速入门解析)
    - [2.1. 注解解析](#21-注解解析)
    - [2.2. SpringBoot工程热部署](#22-springboot工程热部署)
    - [2.3. 起步依赖分析](#23-起步依赖分析)
        - [2.3.1. 分析spring-boot-starter-parent](#231-分析spring-boot-starter-parent)
        - [2.3.2. 分析spring-boot-starter-web](#232-分析spring-boot-starter-web)
    - [2.4. SpringBoot配置文件](#24-springboot配置文件)

<!-- /TOC -->

# 1. SpringBoot Quick Start
## 1.1. springboot依赖
* SpringBoot要求，项目要继承SpringBoot的起步依赖spring-boot-starter-parent
```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.0.1.RELEASE</version>
</parent>
```
* SpringBoot要集成SpringMVC进行Controller的开发，所以项目要导入web的启动依赖
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```

## 1.2. 编写SpringBoot引导类
* 要通过SpringBoot提供的引导类起步SpringBoot才可以进行访问
```java
package com.itheima;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class);
    }
}
```
## 1.3. 编写Controller
在引导类MySpringBootApplication同级包或者子级包中创建QuickStartController
```java
package com.itheima.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuickStartController {
    @RequestMapping("/quick")
    @ResponseBody
    public String quick(){
        return "SpringBoot访问成功";
    }
}
```
## 1.4. 测试
执行SpringBoot起步类的主方法。
查看日志，发现：
```
Tomcat started on port(s): 8080 (http) with context path '
```
访问url:  
http://localhost:8080/quick
# 2. 快速入门解析
## 2.1. 注解解析
* @SpringBootApplication：标注SpringBoot的启动类，该注解具备多种功能（后面详细剖析）
* SpringApplication.run(MySpringBootApplication.class) 代表运行SpringBoot的启动类，参数为SpringBoot启动类的字节码对象。

## 2.2. SpringBoot工程热部署
我们在开发中反复修改类、页面等资源，每次修改后都是需要重新启动才生效，这样每次启动都很麻烦，浪费了大量的时间，我们可以在修改代码后不重启就能生效，在 pom.xml 中添加如下配置就可以实现这样的功能，我们称之为`热部署`。
1.添加依赖
```xml
<!--热部署配置-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
</dependency>
```
2.IDEA配置
<div align="center"><a><img width="1500" heigth="600" src="imgs/1.JPG"></a></div>

## 2.3. 起步依赖分析

### 2.3.1. 分析spring-boot-starter-parent
我们的SpringBoot工程继承spring-boot-starter-parent后已经具备版本锁定等配置了。所以起步依赖的作用就是进行``依赖的传递``。
### 2.3.2. 分析spring-boot-starter-web
spring-boot-starter-web就是将web开发要使用的spring-web、spring-webmvc等坐标进行了“打包”，这样我们的工程只要引入spring-boot-starter-web起步依赖的坐标就可以进行web开发了，同样体现了依赖传递的作用。

## 2.4. SpringBoot配置文件
SpringBoot是基于约定的，所以很多配置都有默认值，但如果想使用自己的配置替换默认配置的话，就可以使用application.properties或者application.yml（application.yaml）进行配置。

SpringBoot默认会从Resources目录下加载application.properties或application.yml（application.yaml）文件其中，application.properties文件是键值对类型的文件，之前一直在使用，所以此处不在对properties文件的格式进行阐述。除了properties文件外，SpringBoot还可以使用yml文件进行配置。

