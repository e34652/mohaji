import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@@ -4,6 +4,8 @@ import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

@@ -14,11 +16,25 @@ public class ProjectSecurityConfig {
        http
                .csrf(csrf -> csrf.disable()) //CSRF protection: DB변동이 발생하는 request는 무조건 차단시켜버리는 기능. DB작업하려고 해제.
            .authorizeHttpRequests((requests) -> requests
<<<<<<< HEAD
                .requestMatchers("/authenticated").authenticated()
                .requestMatchers("/unauthenticated").permitAll())
            =======
            .requestMatchers("/authenticated", "/notification/**").authenticated()
                .requestMatchers("/register").permitAll())
            >>>>>>> origin/Oh
            .formLogin(Customizer.withDefaults())
            .logout(logout->logout
            .logoutSuccessUrl("/login")
            .invalidateHttpSession(true) //로그아웃 이후 세션 전체 삭제
                )
                        .httpBasic(Customizer.withDefaults());
        return http.build();
}

@Bean
public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
}

}