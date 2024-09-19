package com.minhajcse.config;

import com.minhajcse.service.CustomUserDetailsService;
import com.minhajcse.utility.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService customUserDetailsService;
    public JwtRequestFilter(JwtUtil jwtUtil, CustomUserDetailsService customUserDetailsService) {
        this.jwtUtil = jwtUtil;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String jwt = parseJwt(request);

            if (StringUtils.hasText(jwt) && jwtUtil.validateJwtToken(jwt)) {
                String username = jwtUtil.extractUsername(jwt);
                UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken( userDetails, "", userDetails.getAuthorities() );
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//            if (userDetails != null) {
//                Authentication auth = new JwtAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                SecurityContextHolder.getContext().setAuthentication(auth);
//            }
            }
        }
        catch (Exception ex){
            System.out.println("Invalid Credential");
        }
        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {
        String jwt = request.getHeader("Authorization");
        if(StringUtils.hasText(jwt) && jwt.startsWith("Bearer ")) {
            return jwt.substring(7);
        }
        return null;
    }
}

