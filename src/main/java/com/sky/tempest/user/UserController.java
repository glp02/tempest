package com.sky.tempest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/auth/register")
    public AuthStatus registerUser(
            @Valid @RequestParam(name = "email") String email,
            @Valid @RequestParam(name = "first_name") String firstName,
            @Valid @RequestParam(name = "last_name") String lastName,
            @Valid @RequestParam(name = "password")
            //Line below adds constraints on password.
            //@Pattern("^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$")
            String password) {
        return service.registerUser(email, firstName, lastName, password);
    }

    @PostMapping("/auth/login")
    public AuthStatus loginUser(
            @Valid @RequestParam(name="email") String email,
            @Valid @RequestParam(name = "password") String password){
        return service.loginUser(email, password);
    }

    @PostMapping("/auth/logout")
    public AuthStatus logoutUser(
            @Valid @RequestParam(name="email") String email,
            @Valid @RequestParam(name = "password") String password) {
        return service.logUserOut(email, password);
    }

    @PatchMapping("/auth/change_password")
    public AuthStatus changePassword(
            @Valid @RequestParam(name="email") String email,
            @Valid @RequestParam(name = "password") String password,
            @Valid @RequestParam(name= "new_password") String newPassword){
        return service.changePassword(email, password, newPassword);
    }

    @DeleteMapping("/auth/delete_account")
    public AuthStatus deleteUser(
        @Valid @RequestParam(name="email") String email,
        @Valid @RequestParam(name = "password") String password){
            return service.deleteUser(email, password);
    }

    @GetMapping("auth/all")
    public String getUsers(){
        return service.getUsers();
    }
}