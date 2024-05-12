package com.team1.mohaji.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) //CSRF protection: DB변동이 발생하는 request는 무조건 차단시켜버리는 기능. DB작업하려고 해제.
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/js/**", "/css/**", "/img/**", "/json/**").permitAll()
                        .requestMatchers("/", "/main").permitAll()
                        .requestMatchers("/register").permitAll()
                        .anyRequest().authenticated())
                .formLogin(loginConfigurer->loginConfigurer.defaultSuccessUrl("/",true).failureUrl("/login?error=true").permitAll())
                .logout(logoutConfigurer -> logoutConfigurer.invalidateHttpSession(true).permitAll())
                    .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
