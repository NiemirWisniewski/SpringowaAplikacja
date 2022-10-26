package pl.nw.hehexd.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {
    private final JpaUserDetailsService jpaUserDetailsService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.ignoringAntMatchers("h2-console/**"))
                .authorizeRequests(auth -> auth
                        .antMatchers("/swagger-ui/#/**").permitAll()
                        .antMatchers("/h2-console/**").permitAll()
                        .mvcMatchers("/api/users").permitAll()
                        .mvcMatchers("api/items").permitAll()
                        .anyRequest().authenticated())
                .userDetailsService(jpaUserDetailsService)
                .httpBasic(Customizer.withDefaults())
                .headers(headers -> headers.frameOptions().sameOrigin())
                .build();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
       authenticationManagerBuilder.userDetailsService(jpaUserDetailsService).passwordEncoder(encoder());
    }
}