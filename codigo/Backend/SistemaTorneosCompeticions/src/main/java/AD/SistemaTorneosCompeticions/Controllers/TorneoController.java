package AD.SistemaTorneosCompeticions.Controllers;

import AD.SistemaTorneosCompeticions.Models.Torneo;
import AD.SistemaTorneosCompeticions.Services.TorneoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/torneo")
public class TorneoController {

    @Autowired
    private TorneoService torneoService;

    // Obtener todos los torneos
    @GetMapping
    public List<Torneo> obtenerTorneos() {
        return torneoService.listarTorneos();
    }

    // Obtener torneo por ID
    @GetMapping("/{id}")
    public Torneo obtenerTorneo(@PathVariable Long id) {
        return torneoService.obtener(id);
    }

    // Crear un nuevo torneo
    @PostMapping
    public Torneo guardarTorneo(@RequestBody Torneo torneo) {
        return torneoService.guardar(torneo);
    }

    // Actualizar un torneo existente
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Torneo torneo) {
        if (id.equals(torneo.getId())) {
            torneoService.guardar(torneo);
            return ResponseEntity.accepted().body("El torneo se ha actualizado correctamente");
        } else {
            return ResponseEntity.badRequest().body("El torneo no se ha podido actualizar, los id no coinciden o no existe");
        }
    }

    // Eliminar un torneo
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarTorneo(@PathVariable Long id) {
        torneoService.eliminar(id);
        return ResponseEntity.ok().body("El torneo ha sido eliminado correctamente");
    }


}

