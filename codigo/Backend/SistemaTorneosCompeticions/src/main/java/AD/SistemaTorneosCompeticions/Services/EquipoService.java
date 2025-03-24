package AD.SistemaTorneosCompeticions.Services;

import AD.SistemaTorneosCompeticions.Models.DTO.CompeticionSecundariaDTO;
import AD.SistemaTorneosCompeticions.Models.DTO.EquipoDTO;
import AD.SistemaTorneosCompeticions.Models.DTO.EquipoTorneoDTO;
import AD.SistemaTorneosCompeticions.Models.DTO.TorneoDTO;
import AD.SistemaTorneosCompeticions.Models.Equipo;
import AD.SistemaTorneosCompeticions.Models.Torneo;
import AD.SistemaTorneosCompeticions.Repositories.EquipoRepository;
import AD.SistemaTorneosCompeticions.Repositories.TorneoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;
    @Autowired
    private TorneoRepository torneoRepository;


    /*Lista de equipos*/
    public List<Equipo> obtenerTodos() {
        return equipoRepository.findAll();
    }

    public Equipo obtener(Long id) {
        return equipoRepository.findById(id).orElse(null);
    }

    public Equipo guardar(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public void eliminar(Long id) {
        equipoRepository.deleteById(id);
    }


    public CompeticionSecundariaDTO listarEquiposPorTorneo(Long torneoId) {
        List<Equipo> equipos = equipoRepository.torneoSecundario(torneoId);
        CompeticionSecundariaDTO competicionSecundariaDTO = new CompeticionSecundariaDTO();

        List<TorneoDTO> listaTorneos = new ArrayList<>();
        List<Torneo> torneos = torneoRepository.findAll();

        competicionSecundariaDTO.setTorneos(new ArrayList<>());
        competicionSecundariaDTO.setId(torneoId);

        for (Torneo torneo : torneos) {
            //Obter torneos
            TorneoDTO torneoDTO = new TorneoDTO();
            torneoDTO.setId(torneo.getId());
            torneoDTO.setNombre(torneo.getNombre());
            torneoDTO.setEquipos(new ArrayList<>());
            listaTorneos.add(torneoDTO);

            if (torneo.getId().equals(torneoId)) {
                competicionSecundariaDTO.setNombreTorneo(torneo.getNombre());
            }

        }

        for (Equipo equipo : equipos) {
            //Obter equipos
            EquipoDTO equipoDTO = new EquipoDTO();
            equipoDTO.setId(equipo.getId());
            equipoDTO.setNombre(equipo.getNombre());

            for (TorneoDTO torneoDTO : listaTorneos) {
                if (torneoDTO.getId().equals(equipo.getTorneo_id())) {
                    torneoDTO.getEquipos().add(equipoDTO);
                }
            }
        }
        //Si non hay equipos elimino DTO
        Iterator<TorneoDTO> iterator = listaTorneos.iterator();
        while (iterator.hasNext()) {
            TorneoDTO torneoDTO = iterator.next();
            if (torneoDTO.getEquipos().isEmpty()) {
                iterator.remove();
            }
        }

        competicionSecundariaDTO.setTorneos(listaTorneos);
        return competicionSecundariaDTO;
    }

}
