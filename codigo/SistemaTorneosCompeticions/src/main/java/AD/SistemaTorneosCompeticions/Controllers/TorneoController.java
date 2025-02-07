package AD.SistemaTorneosCompeticions.Controllers;

import AD.SistemaTorneosCompeticions.Models.Torneo;
import AD.SistemaTorneosCompeticions.Services.TorneoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController("api/torneo")
public class TorneoController {

    @Autowired
    private TorneoService torneoService;

    @GetMapping
    public List<Torneo> obtenerTorneos() {
        return torneoService.listarTorneos();
    }

    @GetMapping("/{id}")
    public Torneo obtenerTorneo(@PathVariable Long id) {
        return torneoService.obtener(id);
    }

    @PostMapping
    public Torneo guardarTorneo(@RequestBody Torneo torneo) {
        return torneoService.guardar(torneo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Torneo torneo) {
        if (id.equals(torneo.getId())) {
            torneoService.guardar(torneo);
            return ResponseEntity.accepted().body("El torneo se ha actualizado correctamente");
        } else {
            return ResponseEntity.badRequest().body("El torneo no se ha podido actualizar los id no coinciden o no existe");
        }
    }

    public void borrarTorneo(@PathVariable Long id) {
        torneoService.eliminar(id);
    }

}