package com.zyr.demo.controller;

import com.zyr.demo.domain.Account;
import com.zyr.demo.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AccountService accountService;

    private String name = "Bob";
    private String nickName = "boooob";
    private Double money = 50.5;

    @Before
    public void setUp() throws Exception {
        Account account = new Account(name, nickName, money);
        accountService.insertAccount(account);
    }

    @Test
    public void testInsertAccount() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/account/account")
                .param("name", "Tom")
                .param("nickName", "tooom")
                .param("money", "10.5"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":4,\"name\":\"Tom\",\"nickName\":\"tooom\",\"money\":10.5}"));
    }

    @Test
    public void testFindByName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/account/accounts")
                .param("name", name))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{\"id\":1,\"name\":\"Bob\",\"nickName\":\"boooob\",\"money\":50.5}]"));
    }

    @Test
    public void testUpdateAccount() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/account/account")
                .param("id", "1")
                .param("name", "Tom")
                .param("nickName", "tooom")
                .param("money", "10.5"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"name\":\"Tom\",\"nickName\":\"tooom\",\"money\":10.5}"));
    }

    @Test
    public void testDeleteById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/account/account")
                .param("id", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }
}
