package com.validator.service;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public boolean isValid(String token) {
        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("Token can't be empty");
        }
        
        token = token.replaceAll("-", "");

        int sum = 0;
        boolean alternate = false;

        for (int i = token.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(token.substring(i, i + 1));
            
            if (alternate) {
                n *= 2;
                
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }

            sum += n;
            alternate = !alternate;
        }
        
        return (sum % 10 == 0);
    }
}
