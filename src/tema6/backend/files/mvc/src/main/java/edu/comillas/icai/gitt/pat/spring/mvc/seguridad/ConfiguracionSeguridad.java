package edu.comillas.icai.gitt.pat.spring.mvc.seguridad;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class ConfiguracionSeguridad {
    @Value("${user.usuario.username}")
    private String usuarioUsername;
    @Value("${user.usuario.password}")
    private String usuarioPassword;
    @Value("${user.administrador.username}")
    private String adminUsername;
    @Value("${user.administrador.password}")
    private String adminPassword;

    @Bean
    public SecurityFilterChain configuracion(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated())
            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults())
            .csrf().ignoringRequestMatchers("/api/**");
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager usuarios() {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        UserDetails user = userBuilder
                .username(usuarioUsername)
                .password(usuarioPassword)
                .roles("USER")
                .build();
        UserDetails admin = userBuilder
                .username(adminUsername)
                .password(adminPassword)
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}
