package com.zxd.service;

import com.zxd.entity.User;

/**
 * @author dbdb2
 * 用户的server层接口
 */
public interface UserServer {
    /**
     * 用户登陆
     * @param username String
     * @param pwd String
     * @return
     */
    User userLogin(String username, String pwd);
    /**
     * 用户注册
     * @param user UserInfo
     * @return
     */
    int userAdd(User user);
    /**
     * 查询用户详细信息
     * @param username String
     * @return
     */
    User selectUser(String username);
    /**
     * 修改用户信息
     * @param phone String
     * @param username String
     * @param email String
     * @return
     */
    int updateUser(String phone,String email,String username);
}
