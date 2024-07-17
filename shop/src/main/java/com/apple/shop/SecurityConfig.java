package com.apple.shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;


@Configuration
    @EnableWebSecurity
    public class SecurityConfig {

        @Bean //누군가 만들어놓은 클래스를 DI로 쓰고 싶다면
        PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder(); //스프링이 가져가서 Bean으로 만들어줌
        }


        @Bean
        public CsrfTokenRepository csrfTokenRepository() {
            HttpSessionCsrfTokenRepository repository =
                    new HttpSessionCsrfTokenRepository();
            repository.setHeaderName("X-XSRF-TOKEN");
            return repository;
        }


        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.csrf((csrf) -> csrf.disable());
            http.authorizeHttpRequests((authorize) ->
                    authorize.requestMatchers("/**").permitAll()
            );
            http.formLogin((formLogin)
                    -> formLogin.loginPage("/login")
                    .defaultSuccessUrl("/") //로그인 성공시
            );
            http.logout(logout -> logout.logoutUrl("/logout"));


            return http.build();
        }
    }


