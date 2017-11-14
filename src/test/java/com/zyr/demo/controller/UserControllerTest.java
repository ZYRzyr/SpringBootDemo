package com.zyr.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSignUp_success() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/signUp")
                .param("name", "Bob")
                .param("age", "20")
                .param("password", "123456"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("success"));
    }

    @Test
    public void testSignUp_name_null() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/signUp")
                .param("name", "")
                .param("age", "20")
                .param("password", "123456"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("用户名不能为空"));
    }

    @Test
    public void testSignUp_age_error() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/signUp")
                .param("name", "Bob")
                .param("age", "10")
                .param("password", "123456"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("必须是成年人"));
    }
}
