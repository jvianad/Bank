package com.prbank.Bank.security.Auth;

import com.prbank.Bank.entities.Role;
import com.prbank.Bank.entities.User;
import com.prbank.Bank.repositories.iUserRepository;
import com.prbank.Bank.security.JWT.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final iUserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public AuthResponse login(LoginRequest loginRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        UserDetails user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest registerRequest){
        User user = User.builder()
                .name(registerRequest.getName())
                .lastName(registerRequest.getLastName())
                .address(registerRequest.getAddress())
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .email(registerRequest.getEmail())
                .role(Role.ROLE_USER)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}

