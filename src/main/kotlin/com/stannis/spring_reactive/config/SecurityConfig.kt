package com.stannis.spring_reactive.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.server.SecurityWebFilterChain


@Configuration
class SecurityConfig {


    @Bean
    fun userDetailsService(): ReactiveUserDetailsService {
        val u1 = User.withUsername("bill")
            .password(passwordEncoder().encode("12345"))
            .authorities("read")
            .build()
        return MapReactiveUserDetailsService(u1)
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun securityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        http.httpBasic(Customizer.withDefaults())
            .formLogin(Customizer.withDefaults())
//            .csrf { it.disable() }
//            .cors { it.disable() }
            .authorizeExchange {
                it.pathMatchers("/product1").hasAuthority("read")
                    .anyExchange()
                    .authenticated()
            }

        return http.build()
    }

}
