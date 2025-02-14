package AD.SistemaTorneosCompeticions.Security;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableJpaRepositories(basePackages = "AD.SistemaTorneosCompeticions.Repositories")
public class JpaConfig {
}
