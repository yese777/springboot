package com.yese.service;

import com.yese.pojo.User;

import java.util.List;

public interface UserService {

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> getUserList();

    /**
     * 根据用户名和密码查找用户
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    User getUserByUsernameAndPwd(String username, String password);
}
