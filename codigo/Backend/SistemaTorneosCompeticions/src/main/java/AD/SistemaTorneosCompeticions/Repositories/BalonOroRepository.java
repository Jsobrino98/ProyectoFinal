package AD.SistemaTorneosCompeticions.Repositories;

import AD.SistemaTorneosCompeticions.Models.BalonOro;
import AD.SistemaTorneosCompeticions.Models.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalonOroRepository extends JpaRepository<BalonOro, Long> {
    List<BalonOro> findByEquipo_Id(Long idEquipo);
}
