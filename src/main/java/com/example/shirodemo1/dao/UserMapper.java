package com.example.shirodemo1.dao;


import com.example.shirodemo1.entity.User;

import java.util.Map;

public interface UserMapper {

    public int insert(User user);

    public int update(Map map);

    public User selectbyid(Integer id);

    public User selectbyusername(String username);

}
