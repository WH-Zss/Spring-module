package com.zou;

import com.zou.Config.MainConfig;
import com.zou.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
    public static void main(String[] args) {
//        /*
//        使用xml文件方式依赖注入
//        ClassPathXmlApplicationContext    Xml文件方式
//         */
//        //传入beans.xml文件地址，返回一个ioc容器对象
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
//        //使用beanId从ioc容器中取出user对象。
//        User user = (User) applicationContext.getBean("user");
//        System.out.println(user);

        /*
        使用注解方式依赖注入
        AnnotationConfigApplicationContext   注解方式
         */
        //传入配置类，返回一个ioc容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        //按照类型取出user对象
        User user = (User) applicationContext.getBean(User.class);
        System.out.println(user);
        //按照类型找到Bean的id
        String[] names = applicationContext.getBeanNamesForType(User.class);
        for (String string: names) {
            System.out.println(string);
        }
    }
}
