package AD.SistemaTorneosCompeticions.Services;

import AD.SistemaTorneosCompeticions.Models.*;
import AD.SistemaTorneosCompeticions.Repositories.EquipoRepository;
import AD.SistemaTorneosCompeticions.Repositories.EquipoTorneoRepository;
import AD.SistemaTorneosCompeticions.Repositories.TorneoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipoTorneoService {

    @Autowired
    private EquipoTorneoRepository equipoTorneoRepository;

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private TorneoRepository torneoRepository;

    public List<EquipoTorneo> obtenerTodos() {
        return equipoTorneoRepository.findAll();
    }

    public EquipoTorneo obtener(Long id) {
        return equipoTorneoRepository.findById(id).orElse(null);
    }

    public EquipoTorneo guardar(EquipoTorneo equipoTorneo) {
        return equipoTorneoRepository.save(equipoTorneo);
    }

    public void eliminar(Long id) {
        equipoTorneoRepository.deleteById(id);
    }

    // Método para obtener equipos y torneos simplificados (solo nombres)

    public List<EquipoTorneoDTO> obtenerEquiposPorTorneo(Long torneoId) {
        // Buscar equipos que están asociados al torneo
        List<EquipoTorneo> equiposTorneo = equipoTorneoRepository.findByTorneoId(torneoId);

        // Convertir la lista de equiposTorneo a DTO con los datos deseados
        return equiposTorneo.stream()
                .map(equipoTorneo -> new EquipoTorneoDTO(equipoTorneo.getEquipo().getNombre(), equipoTorneo.getTorneo().getNombre()))
                .collect(Collectors.toList());
    }

}
