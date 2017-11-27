package com.zyr.demo.service.impl;

import com.zyr.demo.domain.Account;
import com.zyr.demo.repository.AccountRepository;
import com.zyr.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account insertAccount(Account account) {
        if (account != null) {
            accountRepository.save(account);
        }
        return account;
    }

    @Override
    public List<Account> findByName(String name) {
        return accountRepository.findByName(name);
    }

    @Override
    public void deleteById(Integer id) {
        accountRepository.delete(new Account(id));
    }

    @Override
    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }
}
