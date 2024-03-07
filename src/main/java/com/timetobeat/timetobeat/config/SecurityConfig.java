package com.timetobeat.timetobeat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final JWTFilter jwtFilter;
    @Autowired
    public SecurityConfig(JWTFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
     http.

             csrf((csrf -> csrf.disable())
             )
             .authorizeHttpRequests(auth -> auth
                     .requestMatchers("/auth/login", "auth/registration", "auth/showInfo")
                     .permitAll()
                     .anyRequest()
                     .authenticated()
             )
             .formLogin(form -> form
                     .loginProcessingUrl("/login")
                     .permitAll()
             )
             .logout(logout -> logout
                     .logoutUrl("/logout"))
             .sessionManagement(sm -> sm
                     .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
             .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

     return http.build();
 }
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
