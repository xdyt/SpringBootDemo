package com.zxd.service.impl;

import com.zxd.entity.Orders;
import com.zxd.mapper.BookMapper;
import com.zxd.service.BookServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dbdb2
 * Book的server接口实现类
 */
@Service
public class BookServerImpl implements BookServer {
    @Autowired(required = false)
    private BookMapper bookMapper;

    @Override
    public List<Orders> selectAll() {
        List<Orders> orders = bookMapper.selectAll();
        if (null != orders){
            return orders;
        }
        return null;
    }
}
