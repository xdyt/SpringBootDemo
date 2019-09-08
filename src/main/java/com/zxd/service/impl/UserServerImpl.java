package com.zxd.service.impl;

import com.zxd.entity.User;
import com.zxd.mapper.UserMapper;
import com.zxd.service.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dbdb2
 * 用户的server接口实现类
 */
@Service
public class UserServerImpl implements UserServer {
    /**
     * 注入user的mapper
     * @return
     */
    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public User userLogin(String username, String pwd) {
        User users = userMapper.userLogin(username,pwd);
        if (null != users){
            return users;
        }
        return null;
    }

    @Override
    public int userAdd(User user) {
        int i = userMapper.userAdd(user);
        if (i != 0){
            return i;
        }
        return 0;
    }

    @Override
    public User selectUser(String username) {
        User user = userMapper.selectUser(username);
        if (null != user){
            return user;
        }
        return null;
    }

    @Override
    public int updateUser(String phone ,String email,String username) {
        int i = userMapper.updateUser(phone,email,username);
        if (i != 0){
            return i;
        }
        return 0;
    }
}
