package pl.nw.oceniarka.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


//@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {
    //private final UserAuthenticationProvider userAuthenticationProvider;
    private final JpaUserDetailsService jpaUserDetailsService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.httpBasic().and().csrf().disable()
                .authorizeRequests(auth -> auth
                        .mvcMatchers("/api/comments/**").hasAnyRole("USER", "MOD", "ADMIN")
                        .mvcMatchers("/api/posts/**").hasAnyRole("ADMIN", "MOD")
                        .mvcMatchers("/api/users/**").hasAnyRole("ADMIN")
                        .mvcMatchers("/swagger-ui/#/**").permitAll()
                        .anyRequest().permitAll())
                .formLogin(Customizer.withDefaults())
                .logout(Customizer.withDefaults())
                .build();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


    /*@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        //authenticationManagerBuilder.authenticationProvider(userAuthenticationProvider);
        return http
                //.csrf(csrf -> csrf.disable())
                .authorizeRequests(auth -> auth
                        .mvcMatchers(GET ,"/api/users").hasAnyRole("USER", "MOD", "ADMIN")
                        .mvcMatchers("/api/users/**").hasRole("ADMIN")
                        .anyRequest().permitAll())
                .userDetailsService(jpaUserDetailsService)
                .headers(headers -> headers.frameOptions().sameOrigin())
                .formLogin(Customizer.withDefaults())
                .logout(Customizer.withDefaults())
                .build();

/*
                        .anyRequest().authenticated()

                        .antMatchers("/swagger-ui/#/**").permitAll()
                        .antMatchers("/h2-console/**").permitAll()
                        .antMatchers(GET ,"/api/users").permitAll()
                        .antMatchers(GET, "/api/users/*").hasRole("USER")
                        .antMatchers("/api/users/").hasRole("ADMIN")
                        .anyRequest().authenticated())
                        .logout(Customizer.withDefaults())
                        .formLogin(Customizer.withDefaults())
                        .userDetailsService(jpaUserDetailsService)
                        .httpBasic(Customizer.withDefaults())
                        .headers(headers -> headers.frameOptions().sameOrigin())
                        .sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        .and()
                        .build();*/
}
