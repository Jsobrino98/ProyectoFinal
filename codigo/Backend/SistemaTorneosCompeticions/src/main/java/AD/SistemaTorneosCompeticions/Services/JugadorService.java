package AD.SistemaTorneosCompeticions.Services;


import AD.SistemaTorneosCompeticions.Models.Jugador;
import AD.SistemaTorneosCompeticions.Repositories.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    public List<Jugador> obtenerTodos(){
        return jugadorRepository.findAll();
    }

    public Jugador obtener(Long id){
        return jugadorRepository.findById(id).orElse(null);
    }

    public Jugador guardar(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public void eliminar(Long id) {
        jugadorRepository.deleteById(id);
    }

    public List<Jugador> obtenerJugadoresPorEquipo(Long idEquipo) {
        return jugadorRepository.findByEquipo_Id(idEquipo);
    }

}
