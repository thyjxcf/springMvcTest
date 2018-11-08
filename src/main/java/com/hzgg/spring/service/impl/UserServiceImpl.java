package com.hzgg.spring.service.impl;

import com.hzgg.spring.dao.UserDao;
import com.hzgg.spring.entity.User;
import com.hzgg.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by luf on 2018/11/6.
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getAllUser() {
        return userDao.getAllUsers();
    }
}
