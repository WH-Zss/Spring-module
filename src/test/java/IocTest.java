import com.Config.MainConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocTest {
    @Test
    public void test01(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        //获取ioc容器中所有组件的id数组
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name: beanDefinitionNames) {
            System.out.println(name);
        }
    }
}
