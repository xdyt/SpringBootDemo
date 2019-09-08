package com.zxd.controller;

import com.zxd.entity.Orders;
import com.zxd.service.BookServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author dbdb2
 */
@Controller
public class BookController {
    /**
     * 注入book的server接口
     */
    @Autowired(required = false)
    private BookServer bookServer;
    /**
     * 查询全部图书的信息
     * @param session
     * @return
     */
    @RequestMapping("/selectAllBook")
    public String selectAllBook(HttpSession session){
        /**查询方法*/
        List<Orders> booklist  = bookServer.selectAll();
        /**把数据存放到session中*/
        session.setAttribute("book",booklist);
        /**判断数组是否为空,如果不为空着跳转到对应的jsp页面*/
        if (null != booklist){
            return "book/selectbook";
        }
        return null;
    }
}
