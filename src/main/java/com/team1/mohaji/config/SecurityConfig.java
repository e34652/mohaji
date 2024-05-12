package com.team1.mohaji.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
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
                .csrf(csrf -> csrf.disable())//CSRF protection: DB변동이 발생하는 request는 무조건 차단시켜버리는 기능. DB작업하려고 해제.
                .authorizeHttpRequests((requests) -> requests // HTTP 요청을 인증 및 권한 부여합니다.
                        .requestMatchers("/css/**", "/img/**" ,"/js/**").permitAll() // "모든 외부링크 적용 허용"
                        .requestMatchers("/", "/main").permitAll() // "/"와 "/main" 경로에 대한 요청은 모두 허용합니다.
                        .requestMatchers("/register").permitAll() // "/register" 경로에 대한 요청은 모두 허용합니다.
                        .anyRequest().authenticated())// 그 외의 모든 요청은 인증이 필요합니다.
                .formLogin(loginConfigurer -> loginConfigurer // 폼 로그인을 구성합니다.
                        .defaultSuccessUrl("/main",true) // 로그인 성공 시 기본 URL("/main")로 리다이렉트합니다.
                        .failureUrl("/login?error=true") // 로그인 실패 시 "/login?error=true" URL로 리다이렉트합니다.
                        .permitAll()) // 로그인 페이지에 대한 접근을 모두 허용합니다.
                .logout(logoutConfigurer -> logoutConfigurer  // 로그아웃을 구성합니다.
                        .invalidateHttpSession(true)// HTTP 세션을 무효화합니다.
                        .permitAll()) // 로그아웃 페이지에 대한 접근을 모두 허용합니다.
                .httpBasic(Customizer.withDefaults()); // 기본 HTTP 기본 인증을 사용합니다.
        return http.build(); // HttpSecurity 객체를 SecurityFilterChain으로 빌드하여 반환합니다.
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
