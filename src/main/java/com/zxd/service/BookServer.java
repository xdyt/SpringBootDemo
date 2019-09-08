package com.zxd.service;

import com.zxd.entity.Orders;

import java.util.List;

/**
 * @author dbdb2
 * book的server接口
 */
public interface BookServer {

    /**
     * 查询全部图书的信息
     * @return
     */
    List<Orders> selectAll();
}
