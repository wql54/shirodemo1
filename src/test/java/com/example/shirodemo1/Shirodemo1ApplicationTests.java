package com.example.shirodemo1;

import com.example.shirodemo1.entity.User;
import com.example.shirodemo1.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Shirodemo1ApplicationTests {
    @Autowired
    private UserService userService;
    @Test
    public void contextLoads() {
    }

    @Test
    public void serviceTest(){
        User test = userService.selectbyusername("test");
        System.out.println(test);
    }
}
