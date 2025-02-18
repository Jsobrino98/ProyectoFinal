package AD.SistemaTorneosCompeticions.Services;

import AD.SistemaTorneosCompeticions.Models.Equipo;

import AD.SistemaTorneosCompeticions.Models.Partido;
import AD.SistemaTorneosCompeticions.Repositories.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoService {
    @Autowired
    private PartidoRepository partidoRepository;

    public List<Partido> obtenerTodos(){
        return partidoRepository.findAll();
    }

    public Partido obtener(Long id){
        return partidoRepository.findById(id).orElse(null);
    }

    public Partido guardar(Partido partido) {
        return partidoRepository.save(partido);
    }

    public void eliminar(Long id) {
        partidoRepository.deleteById(id);
    }

}
