package com.yese.service.impl;

import com.yese.mapper.UserMapper;
import com.yese.pojo.User;
import com.yese.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    /**
     * 根据用户名和密码查找用户
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public User getUserByUsernameAndPwd(String username, String password) {
        return userMapper.getUserByUsernameAndPwd(username, password);
    }
}
