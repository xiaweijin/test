package com.xwj.service;

import com.xwj.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> selectAll();
    void add(Account account);
}
