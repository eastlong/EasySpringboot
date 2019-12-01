package com.eastlong.controller;

import com.eastlong.bean.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: eastlong
 * @Date 2019/11/27
 * @function:UserController
 **/
@RestController
public class UserController {
    @Autowired
    ConfigBean configBean;

    @RequestMapping("/hello")
    public String hello(){
        return configBean.getName() + "," + configBean.getWish() + "!";
    }


}
