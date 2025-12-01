package com.backend.controller;

import com.backend.dto.request.TokenRequest;
import com.backend.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class TokenController {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public TokenController(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/token")
    public String getToken(@RequestBody TokenRequest tokenRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(tokenRequest.getEmail(), tokenRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(tokenRequest.getEmail(), authentication.getAuthorities().toArray()[0].toString());
        }
        throw new UsernameNotFoundException("invalid email:" + tokenRequest.getEmail());
    }
}
