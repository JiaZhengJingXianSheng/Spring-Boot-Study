package com.example.springbootfirstdemo.controller;


import com.example.springbootfirstdemo.pojo.ResponseMessage;
import com.example.springbootfirstdemo.pojo.User;
import com.example.springbootfirstdemo.pojo.dto.UserDto;
import com.example.springbootfirstdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController // 允许接口方法返回对象，且可以转换成json文本
@RequestMapping("/user") // localhost:8088/user/***
public class UserController {

    @Autowired
    IUserService userService;

    // REST
    // 增加
    @PostMapping    // localhost:8088/user      method: post
    public ResponseMessage add(@Validated @RequestBody UserDto user){
    // RequestBody 会自动把请求的json转换为一个user类

        User userNew = userService.add(user);
        return ResponseMessage.success(userNew);
    }



    // 查询
    // @GetMapping
    @GetMapping("/{userId}")    // localhost:8088/user/1    method: get
    public ResponseMessage get(@PathVariable Integer userId){
        // RequestBody 会自动把请求的json转换为一个user类

        User userNew = userService.getUser(userId);
        return ResponseMessage.success(userNew);
    }

    // 修改
    // @PutMapping

    @PutMapping()   // localhost:8088/user   method: put
    public ResponseMessage edit(@Validated @RequestBody UserDto user){
        // RequestBody 会自动把请求的json转换为一个user类

        User userNew = userService.edit(user);
        return ResponseMessage.success(userNew);
    }

    // 删除用户
    // @DeleteMapping
    @DeleteMapping("{userId}")
    public ResponseMessage delete(@PathVariable Integer userId){
        // RequestBody 会自动把请求的json转换为一个user类

        userService.delete(userId);
        return ResponseMessage.success();
    }
}
