package com.zxd.mapper;

import com.zxd.entity.Orders;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author dbdb2
 * book的mapper接口
 */
public interface BookMapper {
    /**
     * 查询全部图书信息
     * @return
     * @select 写查询语句
     */
    @Select("select * from orders")
    List<Orders> selectAll();
}
