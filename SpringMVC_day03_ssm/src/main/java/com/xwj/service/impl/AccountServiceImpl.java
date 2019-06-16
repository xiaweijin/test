package com.xwj.service.impl;

import com.xwj.dao.AccountDao;
import com.xwj.domain.Account;
import com.xwj.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> selectAll() {
        System.out.println("accountServiceImpl");
        return accountDao.selectAll();
    }

    @Override
    public void add(Account account) {
        accountDao.add(account);
    }
}
