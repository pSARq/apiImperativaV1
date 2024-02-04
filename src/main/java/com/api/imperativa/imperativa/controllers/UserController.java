package com.api.imperativa.imperativa.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.imperativa.imperativa.models.UserModel;
import com.api.imperativa.imperativa.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping()
    public ArrayList<UserModel> findAll() {
        return userService.findAll();
    }

    @PostMapping()
    public UserModel save(@RequestBody UserModel userModel) {
        return userService.save(userModel);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping("/query")
    public ArrayList<UserModel> findByPriority(@RequestParam("priority") Integer priority) {
        return userService.findByPriority(priority);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean result = userService.deleteById(id);

        return result 
        ? "Se eliminó el usuario con el id " + id 
        : "No se pudo eliminar el usuario con el id " + id;
    }

}
