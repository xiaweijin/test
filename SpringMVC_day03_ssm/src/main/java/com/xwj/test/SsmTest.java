package com.xwj.test;

import com.xwj.dao.AccountDao;
import com.xwj.domain.Account;
import com.xwj.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SsmTest {

    @Test
    public void selectAll(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountServiceImpl = (AccountService) ac.getBean("accountServiceImpl");
        accountServiceImpl.selectAll();
    }

    @Test
    public void selectMybatis() throws IOException {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        AccountDao mapper = new SqlSessionFactoryBuilder().build(in).openSession(true).getMapper(AccountDao.class);
        List<Account> accounts = mapper.selectAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
        Account account =new Account();
        account.setName("嘤嘤嘤");
        account.setMoney(2000.00);
        mapper.add(account);
    }
}
