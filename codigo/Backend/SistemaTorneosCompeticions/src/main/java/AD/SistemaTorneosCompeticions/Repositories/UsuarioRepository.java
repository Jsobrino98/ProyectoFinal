package AD.SistemaTorneosCompeticions.Repositories;

import AD.SistemaTorneosCompeticions.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNombreUsuario(String username);
    Optional<Usuario> findByNombreUsuarioOrEmail(String username, String email);
}
