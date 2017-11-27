package com.zyr.demo.service.impl;

import com.zyr.demo.domain.Account;
import com.zyr.demo.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    private String name1 = "Bob";
    private String nickName1 = "boooob";
    private Double money1 = 50.5;

    private String name2 = "Tom";
    private String nickName2 = "toooom";
    private Double money2 = 60.5;

    @Before
    public void setUp() throws Exception {
        Account account1 = new Account(name1, nickName1, money1);
        Account account2 = new Account(name2, nickName2, money2);
        accountService.insertAccount(account1);
        accountService.insertAccount(account2);
    }

    @Test
    public void testInsert_and_Find() throws Exception {
        Account account = accountService.findByName(name1).get(0);
        assertEquals(name1, account.getName());
        assertEquals(nickName1, account.getNickName());
        assertEquals(money1, account.getMoney(), .001);
    }

    @Test
    public void testDeleteById() throws Exception {
        accountService.deleteById(1);
        List<Account> accounts = accountService.findByName(name1);
        for (Account account : accounts) {
            assertTrue(account.getId() != 1);
        }
    }

    @Test
    public void testUpdateAccount() throws Exception {
        Account account = new Account("Jack", "jaacck", 200.5);
        account.setId(2);
        accountService.updateAccount(account);
        Account newAccount = accountService.findByName("Jack").get(0);
        assertEquals("Jack", newAccount.getName());
        assertEquals("jaacck", newAccount.getNickName());
        assertEquals(200.5, newAccount.getMoney(), .001);
        assertEquals(2, newAccount.getId(), .001);
    }

}