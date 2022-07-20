package com.sky.tempest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @PostMapping("/auth/register")
    public AuthStatus registerUser(
            @Valid @RequestParam(name = "email") String email,
            @Valid @RequestParam(name = "first_name") String firstName,
            @Valid @RequestParam(name = "last_name") String lastName,
            @Valid @RequestParam(name = "password") String password) {

        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                System.out.println("User Already exists!");
                return AuthStatus.USER_ALREADY_EXISTS;
            }
        }
        User newUser = new User(email,firstName,lastName,password);
        System.out.println("Registered user: " + newUser.toString());
        userRepository.save(newUser);
        return AuthStatus.SUCCESS;
    }

    @PostMapping("/auth/login")
    public AuthStatus loginUser(
            @Valid @RequestParam(name="email") String email,
            @Valid @RequestParam(name = "password") String password){
        List<User> users = userRepository.findAll();
        for (User user : users) {
            System.out.println(user.toString());
            if (user.credentialsMatch(email, password)) {
                return AuthStatus.SUCCESS;
            }
        }
        return AuthStatus.FAILURE;
    }

    @PostMapping("/auth/logout")
    public AuthStatus logUserOut(
            @Valid @RequestParam(name="email") String email,
            @Valid @RequestParam(name = "password") String password) {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.credentialsMatch(email,password) ) {
                return AuthStatus.SUCCESS;
            }
        }
        return AuthStatus.FAILURE;
    }

    @PatchMapping("/auth/change_password")
    public AuthStatus changePassword(
            @Valid @RequestParam(name="email") String email,
            @Valid @RequestParam(name = "password") String password,
            @Valid @RequestParam(name= "new_password") String newPassword){
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.credentialsMatch(email,password)) {
                System.out.println(user.toString() + " password changed to " + newPassword);
                user.setPassword(newPassword);
                userRepository.save(user);
                return AuthStatus.SUCCESS;
            }
        }
        return AuthStatus.FAILURE;
    }



    @DeleteMapping("/auth/all")
    public AuthStatus deleteUsers() {
        userRepository.deleteAll();
        return AuthStatus.SUCCESS;
    }

    @GetMapping("auth/all")
    public String getUsers(){
        return userRepository.findAll().toString();
    }
}