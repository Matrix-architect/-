package cn.zehong.dao;

import cn.zehong.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账户dao接口
 * @author x
 */
@Repository
public interface AccountDao {

    //查询所有账户
    @Select("select * from account")
    public List<Account> finaAll();

    //保存账户信息
    @Insert("insert into account (name, money) values (#{name}, #{money})")
    public void saveAccount(Account account);
}
