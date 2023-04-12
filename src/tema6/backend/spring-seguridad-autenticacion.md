# Backend

## Spring

### Seguridad

#### Autenticación

Spring permite configurar la autenticación directamente en nuestro servicio mediante un formulario de login o con [autenticación básica](../../tema2/http/respuestas.html#basic-auth). Para ello se utiliza una clase de configuración de Spring Security que la aplicación servidor leerá al arrancar:

```java
@Configuration @EnableWebSecurity
public class ConfiguracionSeguridad {
  @Bean public SecurityFilterChain configuracion(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated())
        .formLogin(Customizer.withDefaults())
        .httpBasic(Customizer.withDefaults())
        .csrf().ignoringRequestMatchers("/api/**");
    return http.build();
  }

  @Bean public InMemoryUserDetailsManager usuarios() {
    UserDetails user = User.withDefaultPasswordEncoder()
            .username("usuario")
            .password("clave")
            .roles("USER")
            .build();
    return new InMemoryUserDetailsManager(user);
  }
}
```

> ⁉️ **Ejercicio 1:** _Añade la clase anterior al proyecto MVC. Intenta acceder a [`http://localhost:8080/contacto`](http://localhost:8080/contacto). Utilizando el inspector de red del navegador, identifica como se produce la autenticación y se mantiene en sucesivas peticiones._

> ⁉️ **Ejercicio 2:** _Intenta llamar al API de contadores `http://localhost:8080/api/contadores*` utilizando la autenticación básica de HTTP._