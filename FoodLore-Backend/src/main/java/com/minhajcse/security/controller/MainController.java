package com.minhajcse.controller;

import com.minhajcse.model.User;
import com.minhajcse.service.CustomUserDetailsService;
import com.minhajcse.service.UserService;
import com.minhajcse.utility.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class MainController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService customUserDetailsService;

    public MainController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, CustomUserDetailsService customUserDetailsService, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.customUserDetailsService = customUserDetailsService;
        this.userService = userService;
    }

    @PostMapping("/user/register")
    public String userRegister(@RequestBody User user){
        UserDetails existingUser = customUserDetailsService.loadUserByUsername(user.getUsername());

        if(existingUser != null){
            return "User already exists";
        }
        userService.addUser(user);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User user){
        System.out.println(user);
        try{
            // check if username and password is correct
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            if (authentication.isAuthenticated()) {
                UserDetails userDetails = customUserDetailsService.loadUserByUsername(user.getUsername());
                // create and return jwt
                Map<String, Object> tokenMap = new HashMap<>();
                tokenMap.put("jwtToken", jwtUtil.generateToken(userDetails));
                return tokenMap;
            } else {
                return Map.of("error", "Invalid credentials");
            }
        }
        catch (Exception e){
            //e.printStackTrace(); // Log the error
            return Map.of("error", "Invalid credentials");
        }
    }
}
