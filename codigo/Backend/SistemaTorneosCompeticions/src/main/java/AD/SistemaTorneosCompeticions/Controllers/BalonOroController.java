package AD.SistemaTorneosCompeticions.Controllers;

import AD.SistemaTorneosCompeticions.Models.BalonOro;

import AD.SistemaTorneosCompeticions.Services.BalonOroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("api/balon_oro")
    public class BalonOroController {
        @Autowired
        private BalonOroService balonOroService;

        // Obtener todos los jugadores que ganaron el Balon de Oro
        @GetMapping
        public List<BalonOro> obtenerJugadores() {
            return balonOroService.obtenerTodos();
        }

        // Obtener jugador por año en que gano el Balon de Oro
        @GetMapping("/{id}")
        public BalonOro obtenerJugador(@PathVariable Long id) {
            return balonOroService.obtener(id);
        }

        // Guardar un nuevo jugador
        @PostMapping
        public BalonOro guardarJugador(@RequestBody BalonOro balonOro) {
            return balonOroService.guardar(balonOro);
        }

        // Actualizar un jugador existente
        @PutMapping("/{id}")
        public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody BalonOro jugador) {
            if (id.equals(jugador.getId())) {
                balonOroService.guardar(jugador);
                return ResponseEntity.accepted().body("El Jugador se ha actualizado correctamente");
            } else {
                return ResponseEntity.badRequest().body("El jugador no se ha podido actualizar, los id no coinciden o no existe");
            }
        }

        // Eliminar un jugador
        @DeleteMapping("/{id}")
        public ResponseEntity<?> borrarJugador(@PathVariable Long id) {
            balonOroService.eliminar(id);
            return ResponseEntity.ok().body("El jugador ha sido eliminado correctamente");
        }
        // Obtener todos los jugadores de un equipo
        @GetMapping("/equipo/{idEquipo}")
        public List<BalonOro> obtenerJugadoresPorEquipo(Long idEquipo) {
            return balonOroService.obtenerJugadoresPorEquipo(idEquipo);}



    }
