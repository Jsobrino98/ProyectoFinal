package AD.SistemaTorneosCompeticions.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // Aplica a todos los endpoints
                        .allowedOrigins("http://localhost:4200", "http://localhost:8080")  // Permitir solicitudes desde Angular
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Métodos HTTP permitidos
                        .allowedHeaders("*")  // Permitir todos los encabezados
                        .allowCredentials(true);  // Permitir solicitudes con credenciales
            }
        };
    }
}
