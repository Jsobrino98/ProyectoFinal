package AD.SistemaTorneosCompeticions.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configuramos CSRF para que no se desactive completamente, pero aún así proteja nuestras rutas
        http.csrf(csrf -> csrf
                        .ignoringAntMatchers("/api/auth/register", "/api/auth/login"))  // Excluimos las rutas públicas de CSRF
                .authorizeRequests()
                .antMatchers("/api/auth/register").permitAll()  // Rutas públicas
                .antMatchers("/api/auth/login").permitAll()
                .anyRequest().authenticated();  // Rutas protegidas

        return http.build();
    }
}