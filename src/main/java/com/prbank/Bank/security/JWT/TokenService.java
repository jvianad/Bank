package com.prbank.Bank.security.JWT;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TokenService {
    private final Set<String> invalidatedTokens = new HashSet<>();

    public void invalidateToken(String token) {
        invalidatedTokens.add(token);
    }

    public boolean isTokenInvalidated(String token) {
        return invalidatedTokens.contains(token);
    }

    public String getTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
