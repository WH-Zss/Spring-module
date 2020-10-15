package com.Config;

import com.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/*
注解方式依赖注入
配置类==配置文件 例：beans.xml
 */
//配置类
@Configuration      //告诉Spring 这是一个配置类
//注解方式 包扫描，只要标注了@com.Controller、@com.Service、@Repository、@Component注解的都会被自动扫描加入容器
@ComponentScan(value = "com")
public class MainConfig {
    //相当于配置文件里的Bean标签，给容器中注册一个Bean，类型为返回值类型，id默认为方法名
    //value 给组件设置id，不设置id默认为方法名
    @Bean(value = "user01")
    public User user(){
        return new User("lisi",19);
    }
}
