package com.zyr.demo.service;

import com.zyr.demo.domain.Account;

import java.util.List;

public interface AccountService {
    Account insertAccount(Account account);

    List<Account> findByName(String name);

    void deleteById(Integer id);

    Account updateAccount(Account account);
}
