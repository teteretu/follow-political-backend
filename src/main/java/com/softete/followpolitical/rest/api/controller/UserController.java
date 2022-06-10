package com.softete.followpolitical.rest.api.controller;

import com.softete.followpolitical.rest.api.Model.UserModel;
import com.softete.followpolitical.rest.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/id/{id}")
    public ResponseEntity search(@PathVariable("id") Integer id) {
        return userRepository.findById(id)
                .map(userModel -> ResponseEntity.ok().body(userModel))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/save")
    public UserModel save(@RequestBody() UserModel userModel) {
        return userRepository.save(userModel);
    }
}
