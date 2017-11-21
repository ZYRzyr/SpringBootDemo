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

    @Test
    public void testRegister_success() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user/register")
                .param("name", "Bob")
                .param("age", "20")
                .param("password", "123456"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("success"));
    }

    @Test
    public void testRegister_age_error() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/user/register")
                .param("name", "Bob")
                .param("age", "10")
                .param("password", "123456"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())//age=10，验证不通过，返回状态码400
                .andExpect(MockMvcResultMatchers.content().string("必须是成年人"));
    }

    @Test
    public void testGetUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user/users"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{\"name\":\"Bob\",\"age\":20,\"password\":\"123456\"},{\"name\":\"Tom\",\"age\":22,\"password\":\"654321\"}]"));
    }

    @Test
    public void testUpdateUser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/user/profile")
                .param("name", "new")
                .param("age", "30")
                .param("password", "555555"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"name\":\"new\",\"age\":30,\"password\":\"555555\"}"));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/user/user"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }
}
