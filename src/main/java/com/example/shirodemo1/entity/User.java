package com.example.shirodemo1.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private Integer roleid;

}
