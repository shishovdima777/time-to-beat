package com.timetobeat.timetobeat.config;

import com.timetobeat.timetobeat.services.serviceImpls.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UserServiceImpl userService;
    @Autowired
    public SecurityConfig(UserServiceImpl userService) {
        this.userService = userService;
    }

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
     http.
             authorizeHttpRequests((auth) ->
                     auth.anyRequest().authenticated()
             )
             .httpBasic(Customizer.withDefaults());

     return http.build();
 }
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
