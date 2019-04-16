package com.sxjf.blog;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Created with IntelliJ IDEA.
 * Description: SpringBoot启动类
 * Author: wangyang and zhujie
 * Date: 2018/11/29
 * Time: 20:23
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//
@ServletComponentScan //web.xml配置
//@MapperScan(basePackages = {"com.sxjf.blog.dao","com.sxjf.test.dao"})//此处配置了dao接口扫描，dao层则可以省略@Mapper注解，扫描的是mapper.xml中namespace指向值的包位置
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class);
    }

}
