package AD.SistemaTorneosCompeticions.Controllers;


import AD.SistemaTorneosCompeticions.Models.DTO.EquipoTorneoDTO;
import AD.SistemaTorneosCompeticions.Services.EquipoTorneoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/equipoTorneo")
public class EquipoTorneoController {

    @Autowired
    private EquipoTorneoService equipoTorneoService;

    @GetMapping("/por-torneo/{torneoId}")
    public ResponseEntity<List<EquipoTorneoDTO>> obtenerEquiposPorTorneo(@PathVariable Long torneoId) {
        List<EquipoTorneoDTO> equipos = equipoTorneoService.obtenerEquiposPorTorneo(torneoId);
        if (equipos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Si no hay equipos asociados, respondemos con 204
        }
        return new ResponseEntity<>(equipos, HttpStatus.OK);  // Si hay equipos, respondemos con 200
    }

}
