package cn.zehong.test;

import cn.zehong.dao.AccountDao;
import cn.zehong.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.test.context.jdbc.Sql;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author x
 * @version 1.0
 * @ClassName MyBatisTest
 * @Description TODO
 * @date 2019/10/22 23:05
 */
public class MyBatisTest {
    /**
     * 测试查询
     * @throws IOException
     */
    @Test
    public void run1() throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //查询所有
        List<Account> list = dao.finaAll();
        for (Account account: list) {
            System.out.println(account);
        }
        //释放资源
        session.close();
        in.close();
    }

    /**
     * 测试保存
     */
    @Test
    public void run2() throws IOException {
        Account account = new Account();
        account.setName("zongqi");
        account.setMoney(400d);
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);

        //保存
        dao.saveAccount(account);
        //提交事务
        session.commit();

        //释放资源
        session.close();
        in.close();
    }
}
