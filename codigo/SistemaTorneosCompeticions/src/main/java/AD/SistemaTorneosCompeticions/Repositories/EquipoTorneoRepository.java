package AD.SistemaTorneosCompeticions.Repositories;

import AD.SistemaTorneosCompeticions.Models.EquipoTorneo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipoTorneoRepository extends JpaRepository<EquipoTorneo,Long> {
    List<EquipoTorneo> findByTorneoId(Long torneoId);

}
