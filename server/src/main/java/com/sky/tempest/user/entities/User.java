package com.sky.tempest.user.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.val;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Entity
@Table(name = "users")
@Data
@ToString
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(unique = true,nullable = false,name = "user_id")
    @val
    //@OnDelete(action = OnDeleteAction.NO_ACTION)
    private long id;

    @NotNull
    @Email
    @Column(unique = true,nullable = false, name = "user_email")
    private @NotBlank String email;

    @Column(nullable = false, name = "user_first_name")
    @NotBlank
    private String firstName;

    @Column(nullable = false, name = "user_last_name")
    @NotBlank
    private String lastName;

    @Column(nullable = false)
    @NotBlank
    private String password;

    public User(@NotBlank String email,
                @NotBlank String firstName,
                @NotBlank String lastName,
                @NotBlank String password) {
        setEmail(email);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
    }

    public boolean passwordMatches(String attemptedPassword) {
        return(this.getPassword().equals(attemptedPassword));
    }
}