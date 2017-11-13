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
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;  //模拟网络请求

    @Test
    public void say() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/my")) //GET方式请求`http:localhost:8080/my`
                .andExpect(MockMvcResultMatchers.status().isOk())   //期望响应成功
                .andExpect(MockMvcResultMatchers.content().string("Hello World!")); //期望响应值为"Hello World!"
    }

}
