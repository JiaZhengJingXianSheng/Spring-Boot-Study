package com.example.springbootfirstdemo.service;

import com.example.springbootfirstdemo.pojo.User;
import com.example.springbootfirstdemo.pojo.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    /**
     * 插入用户
     *
     * @param user
     * @return
     */
    User add(UserDto user);

    /**
     * 查询用户
     * @param userId    用户id
     * @return
     */
    User getUser(Integer userId);

    User edit(UserDto user);

    void delete(Integer userId);
}
