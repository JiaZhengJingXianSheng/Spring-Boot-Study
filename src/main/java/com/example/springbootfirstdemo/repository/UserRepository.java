package com.example.springbootfirstdemo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.springbootfirstdemo.pojo.User;
import org.springframework.stereotype.Repository;

@Repository     // spring bean
public interface UserRepository extends CrudRepository<User, Integer> {
}
