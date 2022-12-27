package com.example.acount.service;

import com.example.acount.Entity.Users;
import com.example.acount.RepositoryInter.UserInter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsersServices {
    @Autowired
    UserInter userInter;

    public List<Users> findAll(){
        return userInter.findAll();
    }

    public Users getUserById(Integer id){
        return userInter.findById(id).get();
    }

    public Users save(Users users){
        return userInter.save(users);
    }

    public Users getUserByUsername(String user){
        return userInter.findByUsername(user);
    }

    public boolean login(String username, String password){
        Users users = userInter.findByUsername(username);
        return users != null? users.getPassword().equals(password):false;
    }

}
