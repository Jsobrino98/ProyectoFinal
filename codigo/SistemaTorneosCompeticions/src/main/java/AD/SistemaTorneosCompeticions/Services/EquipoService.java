package AD.SistemaTorneosCompeticions.Services;

import AD.SistemaTorneosCompeticions.Models.Equipo;
import AD.SistemaTorneosCompeticions.Repositories.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public List<Equipo> obtenerTodos(){
        return equipoRepository.findAll();
    }

    public Equipo obtener(Long id){
        return equipoRepository.findById(id).orElse(null);
    }

    public Equipo guardar(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public void eliminar(Long id) {
        equipoRepository.deleteById(id);
    }


}
