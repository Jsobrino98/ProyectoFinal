package AD.SistemaTorneosCompeticions.Controllers;


import AD.SistemaTorneosCompeticions.Models.Jugador;
import AD.SistemaTorneosCompeticions.Services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/jugador")
public class JugadorController {
    @Autowired
    private JugadorService jugadorService;

    // Obtener todos los jugadores
    @GetMapping
    public List<Jugador> obtenerJugadores() {
        return jugadorService.obtenerTodos();
    }

    // Obtener jugador por ID
    @GetMapping("/{id}")
    public Jugador obtenerJugador(@PathVariable Long id) {
        return jugadorService.obtener(id);
    }

    // Guardar un nuevo jugador
    @PostMapping
    public Jugador guardarJugador(@RequestBody Jugador jugador) {
        return jugadorService.guardar(jugador);
    }

    // Actualizar un jugador existente
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Jugador jugador) {
        if (id.equals(jugador.getId())) {
            jugadorService.guardar(jugador);
            return ResponseEntity.accepted().body("El Jugador se ha actualizado correctamente");
        } else {
            return ResponseEntity.badRequest().body("El jugador no se ha podido actualizar, los id no coinciden o no existe");
        }
    }

    // Eliminar un jugador
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarJugador(@PathVariable Long id) {
        jugadorService.eliminar(id);
        return ResponseEntity.ok().body("El jugador ha sido eliminado correctamente");
    }
    // Obtener todos los jugadores de un equipo
    @GetMapping("/equipo/{idEquipo}")
    public List<Jugador> obtenerJugadoresPorEquipo(Long idEquipo) {
        return jugadorService.obtenerJugadoresPorEquipo(idEquipo);}


}
