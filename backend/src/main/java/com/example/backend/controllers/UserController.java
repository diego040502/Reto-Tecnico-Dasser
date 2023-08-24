package com.example.backend.controllers;

import com.example.backend.models.UserModel;
import com.example.backend.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public List<UserModel> listUsers(){
        //return service.getUsers();
        return service.getUsersWithStates();
    }

    @GetMapping("/users/{id}")
    public Optional<UserModel> getUserById(@PathVariable Integer id){
        return service.getUserId(id);
    }

    @PostMapping("/save")
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel model){
        service.saveUser(model);
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable Integer id, @RequestBody UserModel model){
        UserModel u = service.updateUser(id, model);

        if(u != null){
            return new ResponseEntity<>(u, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserModel> deleteUser(@PathVariable Integer id){
        service.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/findByName/{nombres}")
    public ResponseEntity<UserModel> findByName(@PathVariable String nombres){
        UserModel us = service.getUserByName(nombres);
        if(us != null){
            return new ResponseEntity<>(us,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByStatus/{state}")
    public ResponseEntity<UserModel> findByStatus(@PathVariable String state){
        UserModel us = service.getUserByStatus(state);
        if(us != null){
            return new ResponseEntity<>(us, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/findByLogin/{login}")
    public ResponseEntity<UserModel> findByLogin(@PathVariable String login){
        UserModel us = service.getUserByLogin(login);
        if(us != null){
            return new ResponseEntity<>(us, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
