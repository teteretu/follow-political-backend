package com.softete.followpolitical.rest.api.Service;

import com.softete.followpolitical.rest.api.Model.UserModel;
import com.softete.followpolitical.rest.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity getUserById(Integer id) {
        return userRepository.findById(id)
                .map(userModel -> ResponseEntity.ok().body(userModel))
                .orElse(ResponseEntity.notFound().build());
    }

    public UserModel saveUser(UserModel userModel) {
        return userRepository.save(userModel);
    }
}
