package AD.SistemaTorneosCompeticions.Controllers;

import AD.SistemaTorneosCompeticions.Models.Partido;

import AD.SistemaTorneosCompeticions.Services.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/partido")
public class PartidoController {

   @Autowired
    private PartidoService partidoService;

    // Obtener todos los resultados
    @GetMapping
    public List<Partido> obtenerPartidos() {
        return partidoService.obtenerTodos();
    }

    // Obtener partido por ID
    @GetMapping("/{id}")
    public Partido obtenerPartido(@PathVariable Long id) {
        return partidoService.obtener(id);
    }

    // Guardar un nuevo partido
    @PostMapping
    public Partido guardarPartido(@RequestBody Partido partido) {
        return partidoService.guardar(partido);
    }

    // Actualizar un partido existente
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Partido partido) {
        if (id.equals(partido.getId())) {
            partidoService.guardar(partido);
            return ResponseEntity.accepted().body("El partido se ha actualizado correctamente");
        } else {
            return ResponseEntity.badRequest().body("El partido no se ha podido actualizar, los id no coinciden o no existe");
        }
    }

    // Eliminar un partido
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarPartido(@PathVariable Long id) {
        partidoService.eliminar(id);
        return ResponseEntity.ok().body("El partido ha sido eliminado correctamente");

    }



}
