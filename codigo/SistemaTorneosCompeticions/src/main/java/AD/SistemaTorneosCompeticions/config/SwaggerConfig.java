package AD.SistemaTorneosCompeticions.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase para configurar la documentación
 */

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Sistema de Torneos y Competiciones")
                        .version("1.0")
                        .description("Documentación gestión Torneos")
                                        .contact(new Contact()
                                                .name("Equipo de Soporte")
                                                .email("soporte@sistemaTorneosCompeticiones.com")
                                                .url("https://www.STC.com")));
    }
}
