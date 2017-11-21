package com.zyr.demo.controller;

import com.zyr.demo.domain.User;
import com.zyr.demo.util.TextUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/signUp")  //POST请求方式
    public String signUp(@Valid User user, BindingResult bindingResult) {
        System.out.println("name=" + user.getName());
        System.out.println("age=" + user.getAge());
        System.out.println("password=" + user.getPassword());

        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }

        return "success";
    }


    //------------------------第四节 RESTful API------------------------------------------------------------------------
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setName("Bob");
        user1.setAge(20);
        user1.setPassword("123456");

        User user2 = new User();
        user2.setName("Tom");
        user2.setAge(22);
        user2.setPassword("654321");

        //模拟从数据库取出数据
        users.add(user1);
        users.add(user2);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //如果验证出错，则返回错误信息，状态码400
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PutMapping("/profile")
    public ResponseEntity<User> updateUser(User newUser) {
        User oldUser = new User();
        oldUser.setName("old");
        oldUser.setAge(20);
        oldUser.setPassword("123456");

        //假设oldUser为数据库中已存在数据，用newUser更新oldUser
        if (!TextUtil.isEmpty(newUser.getName())) {
            oldUser.setName(newUser.getName());
        }

        if (newUser.getAge() != null) {
            oldUser.setAge(newUser.getAge());
        }

        if (!TextUtil.isEmpty(newUser.getPassword())) {
            oldUser.setPassword(newUser.getPassword());
        }

        return new ResponseEntity<>(oldUser, HttpStatus.OK);
    }

    @DeleteMapping("/user")
    public ResponseEntity deleteUser(String name) {
        //省略数据库删除数据操作
        return new ResponseEntity(HttpStatus.OK);
    }
}
