package com.sky.tempest.user.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@ToString
public class UserDTO {
    private String firstName;
    private String lastName;
    private String email;
}
