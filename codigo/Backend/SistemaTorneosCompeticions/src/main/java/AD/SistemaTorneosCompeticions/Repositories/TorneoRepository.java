package AD.SistemaTorneosCompeticions.Repositories;

import AD.SistemaTorneosCompeticions.Models.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TorneoRepository extends JpaRepository<Torneo, Long> {


}
