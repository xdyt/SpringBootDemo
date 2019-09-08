package com.zxd.controller;

import com.zxd.entity.User;
import com.zxd.service.UserServer;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author dbdb2
 */
@Controller
public class UserController {
    /**
     * 注入用户的server接口
     */
    @Autowired(required = false)
    private UserServer userServer;
    /**
     * 用户登陆
     */
    @RequestMapping("/userLogin")
    @ResponseBody
    public String userLogin(String username, @Param("pwd") String pwd, HttpSession session){
        User userinfo = userServer.userLogin(username,pwd);
        if (null != userinfo){
            session.setAttribute("username",username);
            return "success";
        }
        return null;
    }
    /**
     * 查询用户信息
     */
    @RequestMapping("/selectbyusername")
    public String selectuser(HttpSession session){
        String username = (String) session.getAttribute("username");
        User user = userServer.selectUser(username);
        if (null != user){
            session.setAttribute("user",user);
            return "user/slelectuser";
        }
        return null;
    }

    /**
     * 用户注册
     */
    @RequestMapping("/registration")
    @ResponseBody
    public String userAdd(User user){
        int i = userServer.userAdd(user);
        if (i!=0){
            return "success";
        }
        return null;
    }
    /**
     * 修改用户信息
     */
    @RequestMapping("/updateuser")
    @ResponseBody
    public String updateUser(String phone,String email,HttpSession session){
        String username = (String) session.getAttribute("username");
        int i = userServer.updateUser(phone,email,username);
        if (i != 0){
            return "success";
        }
        return null;
    }
    /**
     * 删除信息
     */

}
