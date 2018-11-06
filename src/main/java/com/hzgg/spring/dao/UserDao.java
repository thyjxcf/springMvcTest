package com.hzgg.spring.dao;

import com.hzgg.spring.entity.User;

import java.util.List;

/**
 * Created by luf on 2018/11/6.
 */
public interface UserDao {

    List<User> getAllUsers();
}
