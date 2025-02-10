package AD.SistemaTorneosCompeticions.Services;

import AD.SistemaTorneosCompeticions.Models.EquipoTorneo;
import AD.SistemaTorneosCompeticions.Models.Jugador;
import AD.SistemaTorneosCompeticions.Repositories.EquipoTorneoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoTorneoService {

    @Autowired
    private EquipoTorneoRepository equipoTorneoRepository;

    public List<EquipoTorneo> obtenerTodos(){
        return equipoTorneoRepository.findAll();
    }

    public EquipoTorneo obtener(Long id){
        return equipoTorneoRepository.findById(id).orElse(null);
    }

    public EquipoTorneo guardar(EquipoTorneo equipoTorneo) {
        return equipoTorneoRepository.save(equipoTorneo);
    }

    public void eliminar(Long id) {
        equipoTorneoRepository.deleteById(id);
    }

}
