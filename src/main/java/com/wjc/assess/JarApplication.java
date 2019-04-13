package com.wjc.assess;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



//@SpringBootApplication
//springboot启动时会自动注入数据源和配置jpa,排除它们
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
//@MapperScan("com.wjc.assess.dao")
//括号后面表示忽视自动配置，或者配置dataSource可以把后面去掉
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class JarApplication {
//    public static void main(String[] args) {
//        SpringApplication.run(JarApplication.class, args);
//    }
}
