package com.validator.controller;

import com.validator.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {
    
    @Autowired
    private TokenService tokenService;

    @PostMapping("/validate")
    public boolean validateToken(@RequestBody String token) {
        return tokenService.isValid(token);
    }
}
