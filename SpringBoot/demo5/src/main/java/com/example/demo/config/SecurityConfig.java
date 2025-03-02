//package com.example.demo.config;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//               .requestMatchers("/public").permitAll() // Public endpoint
//                .anyRequest().authenticated()      // Secure all other endpoints
//            .and()
//            .formLogin(); // Enable form-based login
//        return http.build();
//    }
//}
