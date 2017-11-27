package com.zyr.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity //表示该类是一个实体类，在配置中写了 ddl-auto，jpa会将类名作为表名自动生成表
public class Account {

    @Id   //主键约束
    @GeneratedValue  //自增
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String nickName;

    @NotNull
    private Double money;

    public Account() {   //必须写无参构造方法，否则报错
    }

    public Account(Integer id) {
        this.id  = id;
    }

    public Account(String name, String nickName, Double money) {
        this.name = name;
        this.nickName = nickName;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", money=" + money +
                '}';
    }
}
