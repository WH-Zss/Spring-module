package com.zou.Config;

import com.zou.bean.User;
import org.springframework.context.annotation.*;


/*
注解方式依赖注入
配置类==配置文件 例：beans.xml
 */
//配置类
@Configuration      //告诉Spring 这是一个配置类
//注解方式 包扫描，只要标注了@com.zou.Controller、@com.zou.Service、@Repository、@Component注解的都会被自动扫描加入容器
//use-default-filters="false"：禁用默认过滤规则，默认为true。代表扫描所有的 (若想使用includeFilters，必须先将use-default-filters设置为false，因为默认会扫描全部)
@ComponentScans(value = {
        @ComponentScan(value = "com.zou",includeFilters = {
                /*@ComponentScan.Filter(type = FilterType.ANNOTATION , classes = {Controller.class}),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),*/
                @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
        },useDefaultFilters = false)
})
//@ComponentScans 可写多个ComponentScan规则
//@ComponentScan  value:指定要扫描的包
//excludeFilters = @ComponentScan.Filter：指定扫描的时候按照什么规则排除哪些组件
//includeFilters = @ComponentScan.Filter：指定扫描的时候只需要扫描哪些组件
/**
 *     扫描规则
 *     ANNOTATION           :type = FilterType.ANNOTATION（按照注解） classes = （需要的注解）
 *     ASSIGNABLE_TYPE      :type = FilterType.ASSIGNABLE_TYPE（按照给定的类型）
 *     ASPECTJ              :type = FilterType.ASPECTJ（使用ASPECTJ表达式）
 *     REGEX                :type = FilterType.REGEX（按照正则表达式）
 *     CUSTOM               :type = FilterType.CUSTOM（使用自定义规则）
 */
public class MainConfig {
    //相当于配置文件里的Bean标签，给容器中注册一个Bean，类型为返回值类型，id默认为方法名
    //value 给组件设置id，不设置id默认为方法名
    @Bean(value = "user01")
    public User user(){
        return new User("张三",19);
    }
}
