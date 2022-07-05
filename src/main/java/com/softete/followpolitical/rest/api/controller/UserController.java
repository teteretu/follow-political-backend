package com.softete.followpolitical.rest.api.controller;

import com.softete.followpolitical.rest.api.Model.UserModel;
import com.softete.followpolitical.rest.api.Service.UserService;
import com.softete.followpolitical.rest.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/id/{id}")
    public ResponseEntity search(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping(path = "/save")
    public UserModel save(@RequestBody() UserModel userModel) {
        return userService.saveUser(userModel);
    }
}
