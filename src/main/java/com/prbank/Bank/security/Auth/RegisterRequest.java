package com.prbank.Bank.security.Auth;

import com.prbank.Bank.entities.Role;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {
    private String name;
    private String lastName;
    private String address;
    private String username;
    private String password;
    private String email;
}
