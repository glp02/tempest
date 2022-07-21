package com.sky.tempest.user;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false,name = "user_id")
    private long id;

    @Column(unique = true,nullable = false, name = "user_email")
    private @NotBlank String email;

    @Column(nullable = false, name = "user_first_name")
    private String firstName;

    @Column(nullable = false, name = "user_last_name")
    private String lastName;

    @Column(nullable = false)
    private @NotBlank String password;

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User(@NotBlank String email,
                @NotBlank String firstName,
                @NotBlank String lastName,
                @NotBlank String password) {
        setEmail(email);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }
    private String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean credentialsMatch(String email, String attemptedPassword) {
        return( this.getEmail().equals(email) && this.getPassword().equals(attemptedPassword));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.getId());
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}