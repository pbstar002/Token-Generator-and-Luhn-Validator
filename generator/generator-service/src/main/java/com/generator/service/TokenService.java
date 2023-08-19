package com.generator.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TokenService {
    
    private final Random random = new Random();

    public String generateToken(String digits) {
        if (digits == null || digits.isEmpty()) {
            throw new IllegalArgumentException("Digits can't be empty");
        }

        StringBuilder token = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            int randomIndex = random.nextInt(digits.length());
            token.append(digits.charAt(randomIndex));

            // Append dash after every 4 digits
            if ((i + 1) % 4 == 0 && i != 15) {
                token.append('-');
            }
        }

        return token.toString();
    }
}
