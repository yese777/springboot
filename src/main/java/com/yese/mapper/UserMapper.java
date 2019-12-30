package com.yese.mapper;

import com.yese.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper//表明这是一个mybatis的mapper,另一种全局的写法是在主程序中添加@MapperScan("com.yese.mapper")
@Repository//交给spring管理
public interface UserMapper {

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> getUserList();

    /**
     * 根据用户名和密码查找用户
     *
     * @param username
     * @param password
     * @return
     */
    User getUserByUsernameAndPwd(@Param("username") String username, @Param("password") String password);
}