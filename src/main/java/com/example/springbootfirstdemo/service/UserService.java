package com.example.springbootfirstdemo.service;

import com.example.springbootfirstdemo.pojo.User;
import com.example.springbootfirstdemo.pojo.dto.UserDto;
import com.example.springbootfirstdemo.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service    // 配置成spring的bean
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;


    // UserDto 是防止请求的字段和数据库字段不一致
    @Override
    public User add(UserDto user) {
        User userPojo = new User();
        BeanUtils.copyProperties(user, userPojo);
        return userRepository.save(userPojo);
    }

    @Override
    public User getUser(Integer userId) {
        return userRepository.findById(userId).orElseThrow(() -> {
            throw new IllegalArgumentException("用户不存在，查询异常");
        });
    }

    @Override
    public User edit(UserDto user) {
        User userPojo = new User();
        BeanUtils.copyProperties(user, userPojo);
        //userRepository.deleteById(userPojo.getUserId());
        return userRepository.save(userPojo);
    }

    @Override
    public void delete(Integer userId) {
        userRepository.deleteById(userId);
    }
}
