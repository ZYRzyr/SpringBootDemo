package com.zyr.demo.controller;

import com.zyr.demo.domain.Account;
import com.zyr.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/account")
    public Account insertAccount(Account account) {
        return accountService.insertAccount(account);
    }

    @GetMapping("/accounts")
    public List<Account> findByName(String name) {
        return accountService.findByName(name);
    }

    @PutMapping("/account")
    public Account updateAccount(Account account) {
        return accountService.updateAccount(account);
    }

    @DeleteMapping("/account")
    public void deleteById(Integer id) {
        accountService.deleteById(id);
    }
}
