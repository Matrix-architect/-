package cn.zehong.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.zehong.service.AccountService;

/**
 * @author x
 * @version 1.0
 * @ClassName TestSpring
 * @Description TODO
 * @date 2019/10/21 21:54
 */
public class TestSpring {
    @Test
    public void run1(){
        // 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        // 获取对象
        AccountService as = (AccountService) ac.getBean("accountService");
        // 调用方法
        as.findAll();
    }
}
