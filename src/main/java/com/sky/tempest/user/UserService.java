package com.sky.tempest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public AuthStatus registerUser(String email, String firstName, String lastName, String password) {
        Optional<User> optionalUser = repository.findUserByEmail(email);
        if(optionalUser.isEmpty()){
            User newUser = new User(email,firstName,lastName,password);
            repository.save(newUser);
            System.out.println("Registered user: " + newUser);
            return AuthStatus.SUCCESS;
        } else {
            System.out.println("User Already exists with email " + email);
            return AuthStatus.USER_ALREADY_EXISTS;
        }
    }

    public AuthStatus loginUser(String email, String password){
        Optional<User> optionalUser = repository.findUserByEmail(email);
        if(optionalUser.isPresent() && optionalUser.get().credentialsMatch(email, password))
            return AuthStatus.SUCCESS;
        else
            return AuthStatus.FAILURE;
    }

    public AuthStatus logUserOut(String email, String password) {
        Optional<User> optionalUser = repository.findUserByEmail(email);
        if(optionalUser.isPresent() && optionalUser.get().credentialsMatch(email, password))
            return AuthStatus.SUCCESS;
        else
            return AuthStatus.FAILURE;
    }

    public AuthStatus changePassword(String email, String password, String newPassword){
        Optional<User> optionalUser = repository.findUserByEmail(email);
        if(optionalUser.isPresent() && optionalUser.get().credentialsMatch(email,password)){
            User user = optionalUser.get();
            System.out.println(user.toString() + " password changed to " + newPassword);
            user.setPassword(newPassword);
            repository.save(user);
            return AuthStatus.SUCCESS;
        } else {
            return AuthStatus.FAILURE;
        }
    }

    public AuthStatus deleteUser(String email, String password){
        Optional<User> optionalUser = repository.findUserByEmail(email);
        if(optionalUser.isPresent() && optionalUser.get().credentialsMatch(email,password)){
                return AuthStatus.SUCCESS;
        } else {
            return AuthStatus.FAILURE;
        }
    }

    public String getUsers(){
        return repository.findAll().toString();
    }
}
