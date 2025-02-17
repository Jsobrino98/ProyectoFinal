package AD.SistemaTorneosCompeticions.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Sistema de Torneos y Competiciones")
                        .version("1.0")
                        .description("Documentación para la gestión de Torneos, Equipos y Jugadores.")
                        .contact(new Contact()
                                .name("Equipo de Soporte")
                                .email("soporte@sistemaTorneosCompeticiones.com")
                                .url("https://www.STC.com"))
                        .license(new License().name("Licencia de Uso").url("https://www.STC.com/licencia"))
                );
    }
}
