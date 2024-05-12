package com.team1.mohaji.config;

<<<<<<< HEAD:src/main/java/com/team1/mohaji/config/ProjectSecurityConfig.java
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class ProjectSecurityConfig {

//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) //CSRF protection: DB변동이 발생하는 request는 무조건 차단시켜버리는 기능. DB작업하려고 해제.
//                .authorizeHttpRequests((requests) -> requests
//                .requestMatchers("/authenticated").authenticated()
//                .requestMatchers("/unauthenticated").permitAll())
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
=======
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
                        .requestMatchers("/", "/main").permitAll()
                        .requestMatchers("/register").permitAll()
                        .requestMatchers("/authenticated", "/notification/**").authenticated()
                        .anyRequest().authenticated())
                .formLogin(loginConfigurer->loginConfigurer.defaultSuccessUrl("/mypage").failureUrl("/login?error=true").permitAll())
                .logout(logoutConfigurer -> logoutConfigurer.invalidateHttpSession(true).permitAll())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
>>>>>>> main:src/main/java/com/team1/mohaji/config/SecurityConfig.java

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
