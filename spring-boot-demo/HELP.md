# Springboot Demo

## 自定义验证

## Exception

## 监听事件

## 观察者模式

## DataSource

## Transaction

## Webflux

## spring.factories

spring.factories文件是帮助spring-boot项目包以外的bean（即在pom文件中添加依赖中的bean）注册到spring-boot项目的spring容器。
由于@ComponentScan注解只能扫描spring-boot项目包内的bean并注册到spring容器中，因此需要@EnableAutoConfiguration注解来注册项目包外的bean。
而spring.factories文件，则是用来记录项目包外需要注册的bean类名。
   