package AD.SistemaTorneosCompeticions.Controllers;

import AD.SistemaTorneosCompeticions.Models.DTO.CompeticionSecundariaDTO;
import AD.SistemaTorneosCompeticions.Models.DTO.EquipoTorneoDTO;
import AD.SistemaTorneosCompeticions.Models.Equipo;
import AD.SistemaTorneosCompeticions.Services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/equipo")
@CrossOrigin(origins = "http://localhost:4200") // Permitir solo Angular
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    // Obtener todos los equipos
    @GetMapping
    public List<Equipo> obtenerEquipo() {
        return equipoService.obtenerTodos();
    }

    // Obtener equipo por ID
    @GetMapping("/{id}")
    public Equipo obtenerEquipo(@PathVariable Long id) {
        return equipoService.obtener(id);
    }

    // Guardar un nuevo Equipo
    @PostMapping
    public Equipo guardarEquipo(@RequestBody Equipo equipo) {
        return equipoService.guardar(equipo);
    }

    // Actualizar un equipo existente
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Equipo equipo) {
        if (id.equals(equipo.getId())) {
            equipoService.guardar(equipo);
            return ResponseEntity.accepted().body("El equipo se ha actualizado correctamente");
        } else {
            return ResponseEntity.badRequest().body("El equipo no se ha podido actualizar, los id no coinciden o no existe");
        }
    }

    // Eliminar un equipo
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarEquipo(@PathVariable Long id) {
        equipoService.eliminar(id);
        return ResponseEntity.ok().body("El equipo ha sido eliminado correctamente");

    }

    // Endpoint para listar todos los equipos de un torneo
    @GetMapping("/torneo/{torneoId}")
    public CompeticionSecundariaDTO listarEquiposPorTorneo(@PathVariable Long torneoId) {
        return equipoService.listarEquiposPorTorneo(torneoId);
    }

}
