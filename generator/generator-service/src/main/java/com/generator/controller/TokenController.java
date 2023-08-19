package com.generator.controller;

import com.generator.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {
    
    @Autowired
    private TokenService tokenService;

    @PostMapping("/generate")
    public String generateToken(@RequestBody String digits) {
        return tokenService.generateToken(digits);
    }
}
