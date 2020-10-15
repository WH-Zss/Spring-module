package com.zou.Config;

import com.zou.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //配置类
public class MainConfig2 {

    //默认是单实例的
    @Bean("user02")//加入ioc容器
    public User user(){
        return new User("李四",19);
    }
}
