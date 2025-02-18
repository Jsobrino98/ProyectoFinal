package AD.SistemaTorneosCompeticions.Repositories;


import AD.SistemaTorneosCompeticions.Models.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    @Query(value = "select * from equipos where competicion_secundaria_id=?1 order by torneo_id", nativeQuery = true)
    List<Equipo> pito(Long torneoID);
}



