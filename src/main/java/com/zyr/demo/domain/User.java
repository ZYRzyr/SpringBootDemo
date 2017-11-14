package com.zyr.demo.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotNull(message = "用户名不能为空")
    @Size(min = 1, message = "用户名不能为空") //字符串必须有此注解，否则无法验证传的值""
    private String name;

    @NotNull(message = "年龄不能为空")
    @Min(value = 18, message = "必须是成年人")
    private Integer age;

    @NotNull(message = "密码不能为空")
    @Size(min = 6, max = 15, message = "密码长度为6—15位")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
