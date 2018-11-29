package com.timocode.portal.controller;

import com.timocode.common.util.filter.MyHttpSessionListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

@Controller
@Slf4j
public class UserController {
    @Value("${application.message:Hello World}")
    private String message;

    @GetMapping("/asd/{name}")
    public String welcome(@PathVariable String name, Map<String,Object> model){
        System.out.println("name:"+name);
        model.put("time", new Date());
        model.put("message", this.message);
        return "welcome";
    }

    @RequestMapping("/login")
    @ResponseBody
    public Object foo(){
        log.info("打印日志-----------------");
        return "login";
    }

    @RequestMapping("/index")
    @ResponseBody
    public Object index(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        session.setAttribute("zxc","zxc");
        return "index";
    }

    @RequestMapping("/online")
    @ResponseBody
    public Object online(){
        return "当前在线人数：" + MyHttpSessionListener.online + "人";
    }

}
