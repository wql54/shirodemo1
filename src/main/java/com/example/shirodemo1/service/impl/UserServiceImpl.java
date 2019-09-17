package com.example.shirodemo1.service.impl;

import com.example.shirodemo1.dao.UserMapper;
import com.example.shirodemo1.entity.User;
import com.example.shirodemo1.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int insert(User user) {
        int insert = userMapper.insert(user);
        return insert;
    }

    @Override
    public int update(Map map) {
        int update = userMapper.update(map);
        return update;
    }

    @Override
    public User selectbyid(Integer id) {
        User user = userMapper.selectbyid(id);
        return user;
    }

    @Override
    public User selectbyusername(String username) {
        User user = userMapper.selectbyusername(username);
        return user;
    }


}
