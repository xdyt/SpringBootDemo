package com.zxd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author dbdb2
 */
@Controller
public class JemController {
    /**
     *  跳转到登陆页面的方法
     * @return
     */
    @RequestMapping("/")
    public String login(){
        return "user/login";
    }
    /**
     * 跳转到注册的页面
     * @return
     */
    @RequestMapping("/adduser")
    public String add(){
        return "user/adduser";
    }
}
