package com.xwj.controller;

import com.xwj.domain.Account;
import com.xwj.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/account")
public class MyController {
    @Autowired
 private AccountService accerviceImpl;

    @RequestMapping("/test")
    public String test(Model model){
        List<Account> accounts = accerviceImpl.selectAll();
        model.addAttribute("account",accounts.get(0));
        Account ac =new Account();
        ac.setName("z");
        ac.setMoney(20000.00);
        accerviceImpl.add(ac);
        return "success";
    }
}
