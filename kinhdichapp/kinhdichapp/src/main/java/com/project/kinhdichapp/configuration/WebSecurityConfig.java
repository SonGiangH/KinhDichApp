package com.project.kinhdichapp.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//            http.cors(new Customizer<CorsConfigurer<HttpSecurity>>() {
//                @Override
//                public void customize(CorsConfigurer<HttpSecurity> httpSecurityCorsConfigurer) {
//                CorsConfiguration configuration = new CorsConfiguration();
//                configuration.setAllowedOrigins(List.of("*"));
//                configuration.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
//                configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
//                configuration.setExposedHeaders(List.of("x-auth-token"));
//                UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//
//                source.registerCorsConfiguration("/**", configuration);
//                httpSecurityCorsConfigurer.configurationSource(source);
//                }
//            });

//            http.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest().permitAll()).csrf(AbstractHttpConfigurer::disable);
//            http.authorizeHttpRequests(x -> x.requestMatchers("http://localhost:8088")
//                    .permitAll()
//                    .anyRequest().authenticated());

            http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                    .csrf(AbstractHttpConfigurer::disable);

            return http.build();
    }
}
