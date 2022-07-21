package com.sky.tempest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public AuthStatus registerUser(String email, String firstName, String lastName, String password) {
        Iterable<User> users = repository.findAll();
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                System.out.println("User Already exists with email " + email);
                return AuthStatus.USER_ALREADY_EXISTS;
            }
        }
        User newUser = new User(email,firstName,lastName,password);
        repository.save(newUser);
        System.out.println("Registered user: " + newUser.toString());
        return AuthStatus.SUCCESS;
    }

    public AuthStatus loginUser(String email, String password){
        Iterable<User> users = repository.findAll();
        for (User user : users) {
            System.out.println(user.toString());
            if (user.credentialsMatch(email, password)) {
                return AuthStatus.SUCCESS;
            }
        }
        return AuthStatus.FAILURE;
    }

    public AuthStatus logUserOut(String email, String password) {
        Iterable<User> users = repository.findAll();
        for (User user : users) {
            if (user.credentialsMatch(email,password) ) {
                return AuthStatus.SUCCESS;
            }
        }
        return AuthStatus.FAILURE;
    }

    public AuthStatus changePassword(String email, String password, String newPassword){
        Iterable<User> users = repository.findAll();
        for (User user : users) {
            if (user.credentialsMatch(email,password)) {
                System.out.println(user.toString() + " password changed to " + newPassword);
                user.setPassword(newPassword);
                repository.save(user);
                return AuthStatus.SUCCESS;
            }
        }
        return AuthStatus.FAILURE;
    }

    public AuthStatus deleteUser(String email, String password){
        Iterable<User> users = repository.findAll();
        for (User user : users) {
            if (user.credentialsMatch(email, password)) {
                repository.delete(user);
                return AuthStatus.SUCCESS;
            }
        }
        return AuthStatus.FAILURE;
    }

    public String getUsers(){
        return repository.findAll().toString();
    }
}
