package com.example.demooauth2;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final KeycloakAuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors().disable()
            .authorizeHttpRequests(authentication -> authentication
                .antMatchers("/api/public").permitAll()
                .antMatchers("/api/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .oauth2ResourceServer()
            .jwt()
            .authenticationManager(new ProviderManager(authenticationProvider));
//            .mvcMatchers("/api/private-scoped").hasRole("ADMIN")

        return http.build();
    }

}
