package AD.SistemaTorneosCompeticions.Controllers;


import AD.SistemaTorneosCompeticions.Models.EquipoTorneo;
import AD.SistemaTorneosCompeticions.Services.EquipoTorneoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/equipoTorneo")
public class EquipoTorneoController {

    @Autowired
    private EquipoTorneoService equipoTorneoService;

    // Obtener todos los equipos que participan en varios torneos
    @GetMapping
    public List<EquipoTorneo> obtenerEquipoT() {
        return equipoTorneoService.obtenerTodos();
    }

    // Obtener equipo por ID
    @GetMapping("/{id}")
    public EquipoTorneo obtenerEquipoT(@PathVariable Long id) {
        return equipoTorneoService.obtener(id);
    }

    // Guardar un nuevo Equipo en un torneo
    @PostMapping
    public EquipoTorneo guardarEquipoT(@RequestBody EquipoTorneo equipoTorneo) {
        return equipoTorneoService.guardar(equipoTorneo);
    }

    // Actualizar un equipo de un torneo existente
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody EquipoTorneo equipoTorneo) {
        if (id.equals(equipoTorneo.getId())) {
            equipoTorneoService.guardar(equipoTorneo);
            return ResponseEntity.accepted().body("El Equipo se ha actualizado correctamente");
        } else {
            return ResponseEntity.badRequest().body("El Equipo no se ha podido actualizar, los id no coinciden o no existe");
        }
    }

    // Eliminar un Equipo de un torneo
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarEquipoT(@PathVariable Long id) {
        equipoTorneoService.eliminar(id);
        return ResponseEntity.ok().body("El Equipo ha sido eliminado correctamente");
    }



}
