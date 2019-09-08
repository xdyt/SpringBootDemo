package com.zxd.mapper;

import com.zxd.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author dbdb2
 * 用户的接口
 */
public interface UserMapper {
    /**
     * 用户登录的mapper接口
     * @param user String
     * @param pwd String
     * @return
     */
    @Select("select * from userinfo where username = #{user} and password = #{pwd}")
    User userLogin(String user, String pwd);
    /**
     * 用户注册的mapper接口
     * @param user
     * @return
     */
    @Insert("insert into userinfo (username,password,phone,email) VALUE (#{username},#{password},#{phone},#{email})")
    int userAdd(User user);

    /**
     * 查询用户详细信息
     * @param username
     * @return
     */
    @Select("SELECT * FROM userinfo where username = #{username}")
    User selectUser(String username);

    /**
     * 修改用户信息
     * @param phone String
     * @param email String
     * @param username String
     * @return
     */
    @Update("UPDATE userinfo SET phone=#{phone},email =#{email} WHERE username=#{username}")
    int updateUser(String phone,String email,String username);
}
