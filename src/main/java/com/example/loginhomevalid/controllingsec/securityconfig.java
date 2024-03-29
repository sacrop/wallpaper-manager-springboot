package com.example.loginhomevalid.controllingsec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
public class securityconfig {

     @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
         UserDetails user = User.withUsername("admin")
            .password(passwordEncoder().encode("password"))
            .roles("USER")
            .build();
        
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize ->
                authorize
                .requestMatchers("/", "/login").permitAll()
                .requestMatchers(publicResourcesMatcher()).permitAll()
                        .requestMatchers("/display").authenticated()
                        .requestMatchers("/table").authenticated()
        ).formLogin(form ->
                form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/display")
                        .permitAll()
        )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login")
                        .deleteCookies("JSESSIONID"));
                    return http.build();
    }
    
    private RequestMatcher publicResourcesMatcher() {
        return new AntPathRequestMatcher("/images/**");
    }

    @Bean 
    public PasswordEncoder passwordEncoder() { 
        return new BCryptPasswordEncoder(); 
    }
}
