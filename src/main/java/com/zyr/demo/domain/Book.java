package com.zyr.demo.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component  //将该类作为Bean注入Spring容器
@ConfigurationProperties(prefix = "book")  //配置文件中user前缀的属性将自动绑定到本类对应的字段
public class Book {
    private String name;
    private Double price;
    private Integer page;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", page=" + page +
                '}';
    }
}
