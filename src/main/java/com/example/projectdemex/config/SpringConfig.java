package com.example.projectdemex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;

@Configuration
public class SpringConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SpringSecurityDialect securityDialect(){
        return new SpringSecurityDialect();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(
                                "/registration",
                                "/webjars/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN"))
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/admin/user/list")
                        .permitAll()
                )
                .rememberMe(rememberMe -> rememberMe
                        .key("A6OzwHU19WzPexMsBAfC")
                        .tokenValiditySeconds(86400)
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login")
                        .logoutUrl("/logout")
                        .permitAll()
                        .deleteCookies("JSESSIONID")
                );

        return http.build();
    }

}
