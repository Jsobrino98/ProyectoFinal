package AD.SistemaTorneosCompeticions.Repositories;

import AD.SistemaTorneosCompeticions.Models.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {
}
