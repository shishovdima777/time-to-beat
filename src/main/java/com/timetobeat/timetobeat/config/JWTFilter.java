package com.timetobeat.timetobeat.config;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.timetobeat.timetobeat.security.JWTAuth;
import com.timetobeat.timetobeat.security.UserDetailsImpl;
import com.timetobeat.timetobeat.services.serviceImpls.UserServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JWTFilter extends OncePerRequestFilter {
    private  final UserServiceImpl userServiceImpl;
    private final JWTAuth jwtAuth;
    @Lazy
    @Autowired
    public JWTFilter(UserServiceImpl userServiceImpl, JWTAuth jwtAuth) {
        this.userServiceImpl = userServiceImpl;
        this.jwtAuth = jwtAuth;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");

        if(authHeader != null && !authHeader.isBlank() && authHeader.startsWith("Bearer ")) {
            String jwt = authHeader.substring(7);

            if(jwt.isBlank()) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST,
                        "Invalid JWT Token in Bearer Header");
            } else {
                try {
                    String username = jwtAuth.validateTokenAndGetClaim(jwt);

                    UserDetails userDetails = userServiceImpl.loadUserByUsername(username);

                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),
                            Collections.emptyList());

                    if(SecurityContextHolder.getContext().getAuthentication() == null) {
                        SecurityContextHolder.getContext().setAuthentication(authToken);
                    }
                } catch (JWTVerificationException e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST,
                            "Invalid JWT token");
                }

            }
        }
        filterChain.doFilter(request, response);
    }
}
