package cn.zehong.service.impl;

import cn.zehong.dao.AccountDao;
import cn.zehong.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.zehong.service.AccountService;

import java.util.List;

/**
 * @author x
 * @version 1.0
 * @ClassName AccountServiceImpl
 * @Description TODO
 * @date 2019/10/21 19:54
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("Service：查询所有账户...");
        return accountDao.finaAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("Service：保存账户...");
        accountDao.saveAccount(account);
    }
}
