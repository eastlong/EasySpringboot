package com.eastlong.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: eastlong
 * @Date 2019/11/27
 * @function:
 **/
@Configuration
@ConfigurationProperties(prefix="com.eastlong")
@PropertySource("classpath:test.properties")
public class ConfigBean {
    private String name;
    private String wish;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }
}
