package AD.SistemaTorneosCompeticions.Services;

import AD.SistemaTorneosCompeticions.Models.BalonOro;
import AD.SistemaTorneosCompeticions.Models.Equipo;
import AD.SistemaTorneosCompeticions.Models.Jugador;
import AD.SistemaTorneosCompeticions.Repositories.BalonOroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalonOroService {

    @Autowired
    private BalonOroRepository balonOroRepository;


    public List<BalonOro> obtenerTodos() {
        return balonOroRepository.findAll();
    }

    public BalonOro obtener(Long id) {
        return balonOroRepository.findById(id).orElse(null);
    }

    public BalonOro guardar(BalonOro balonOro) {
        return balonOroRepository.save(balonOro);
    }

    public void eliminar(Long id) {
        balonOroRepository.deleteById(id);
    }

    public List<BalonOro> obtenerJugadoresPorEquipo(Long idEquipo) {
        return balonOroRepository.findByEquipo_Id(idEquipo);
    }
}
