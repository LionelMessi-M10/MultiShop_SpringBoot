package com.multishop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.sql.DataSource;

@Configuration
public class ConfigSecurity {

    @Autowired
    private DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }

    @Bean
    @Autowired
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("SELECT email, password, enabled FROM users WHERE email=?");
        userDetailsManager.setAuthoritiesByUsernameQuery("select u.email, r.code from users u " +
                "inner join user_role ur on u.id = ur.user_id " +
                "inner join roles r on ur.role_id = r.id where u.email=?");
        return userDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, CustomAuthenticationSuccessHandler authenticationSuccessHandler) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(
                        configurer-> configurer
                                .requestMatchers("/shop/**").permitAll()
                                .requestMatchers("/seller/**").hasAnyRole("ADMIN", "SELLER")
                                .requestMatchers("/admin/**").hasAnyRole("ADMIN")
                                .anyRequest().permitAll()
                ).formLogin(
                        form->form.loginPage("/shop/login")
                                .loginProcessingUrl("/authenticateTheUser")
                                .successHandler(authenticationSuccessHandler)
                                .permitAll()
                ).logout(
                        logout->logout
                                .logoutUrl("/logout")
                                .logoutSuccessUrl("/shop/login")
                                .permitAll()
                ).sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer
                        .maximumSessions(1).expiredUrl("/shop/login?sessionTimeOut"))
                .exceptionHandling(
                        configurer->configurer.accessDeniedPage("/shop/showPage403")
                );

        return http.build();
    }
}

