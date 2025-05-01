// Declaración del paquete al que pertenece esta clase de configuración
package AD.SistemaTorneosCompeticions.config;

// Importaciones necesarias para configurar Swagger/OpenAPI 3
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;

// Anotación que indica que esta clase es una clase de configuración de Spring
@Configuration
public class SwaggerConfig {

    // Método que define un bean de tipo OpenAPI.
    // Este bean será gestionado por el contenedor de Spring y utilizado para generar
    // automáticamente la documentación de la API REST del sistema.
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // Se establece la información básica de la API utilizando un objeto Info
                .info(new Info()
                        .title("API de Sistema de Torneos y Competiciones") // Título de la API
                        .version("1.0") // Versión de la API
                        .description("Documentación para la gestión de Torneos, Equipos y Jugadores.") // Breve descripción

                        // Información de contacto del equipo de soporte
                        .contact(new Contact()
                                .name("Equipo de Soporte") // Nombre del contacto
                                .email("soporte@sistemaTorneosCompeticiones.com") // Correo electrónico
                                .url("https://www.STC.com")) // URL de contacto o página de soporte

                        // Información de la licencia bajo la cual se distribuye la API
                        .license(new License()
                                .name("Licencia de Uso") // Nombre de la licencia
                                .url("https://www.STC.com/licencia")) // URL de la licencia
                );
    }
}
