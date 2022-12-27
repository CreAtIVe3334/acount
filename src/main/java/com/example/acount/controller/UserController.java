package com.example.acount.controller;

import com.example.acount.Entity.Users;
import com.example.acount.service.UsersServices;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {

    UsersServices usersServices;
    @Autowired
    public UserController(UsersServices usersServices){
        this.usersServices=usersServices;
    }

    @PostMapping("/signup")
    public ResponseEntity<Users> registration(@RequestBody Users user){
        return new ResponseEntity<Users>(usersServices.save(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUser(@PathVariable Integer id){
        return  new ResponseEntity<Users>(usersServices.getUserById(id),HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@PathParam("username") String username, @PathParam("password") String password){
        return  new ResponseEntity<String>(usersServices.login(username,password)?"Succesfully login":"Incorrect username or password",HttpStatus.ACCEPTED);
    }

}
