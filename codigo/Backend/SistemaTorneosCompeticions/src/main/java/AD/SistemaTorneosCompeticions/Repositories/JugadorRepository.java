package AD.SistemaTorneosCompeticions.Repositories;

import AD.SistemaTorneosCompeticions.Models.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    List<Jugador> findByEquipo_Id(Long idEquipo);
}
