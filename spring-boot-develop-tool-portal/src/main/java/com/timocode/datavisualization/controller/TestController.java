package com.timocode.datavisualization.controller;

import com.timocode.datavisualization.develop.storage.entity.TimoUser;
import com.timocode.datavisualization.develop.storage.service.TimoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TimoUserService timoUserService;

    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(){
        TimoUser timoUser = new TimoUser();
        timoUser.setId(4);
        timoUser.setUserId("timo1");
        timoUser.setUserAge(11);
        timoUser.setUserEmail("123456789@qq.com");
        timoUser.setUserName("提莫1");
        timoUser.setUserHeight(new BigDecimal(160.2));
        timoUser.setUserWeight(new BigDecimal(45));
        timoUser.setUserPassword("123456");
        System.out.println("test1");
        Integer i= timoUserService.addTimoUser(timoUser);
        System.out.println(i);
        return i.toString();
    }
}
