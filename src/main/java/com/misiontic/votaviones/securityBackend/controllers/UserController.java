package com.misiontic.votaviones.securityBackend.controllers;

import com.misiontic.votaviones.securityBackend.models.User;
import com.misiontic.votaviones.securityBackend.services.UserServices;
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
    private UserServices userServices;

    @GetMapping("/all")
    public List <User> getAllUsers() {
        return this.userServices.index();
    }

    @GetMapping("/by_id/{id}")
    public Optional <User> getUserById(@PathVariable("id") int id) {
        return this.userServices.show(id);
    }

    @GetMapping("/by_nickname/{nickname}")
    public Optional <User> getUserByNickname(@PathVariable("nickname") String nickname) {
        return this.userServices.showByNickname(nickname);
    }

    @GetMapping("/by_email/{email}")
    public Optional <User> getUserByEmail(@PathVariable("email") String email) {
        return this.userServices.showByEmail(email);
    }

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public User insertUser(@RequestBody User user) {
        return this.userServices.create(user);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity <User> loginUser(@RequestBody User user) {
        return this.userServices.login(user);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public User updateUser(@PathVariable("id") int id, @RequestBody User user) {
        return this.userServices.update(id, user);
    }

    @DeleteMapping ("/delete/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean deleteUser(@PathVariable("id") int id) {
        return this.userServices.delete(id);
    }
}