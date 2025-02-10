package AD.SistemaTorneosCompeticions.Controllers;

import AD.SistemaTorneosCompeticions.Models.Resultado;
import AD.SistemaTorneosCompeticions.Services.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/resultado")
public class ResultadoController {

    @Autowired
    private ResultadoService resultadoService;

    // Obtener todos los resultados
    @GetMapping
    public List<Resultado> obtenerResultados() {
        return resultadoService.obtenerTodos();
    }

    // Obtener resultado por ID
    @GetMapping("/{id}")
    public Resultado obtenerResultado(@PathVariable Long id) {
        return resultadoService.obtener(id);
    }

    // Guardar un nuevo resultado
    @PostMapping
    public Resultado guardarResultado(@RequestBody Resultado resultado) {
        return resultadoService.guardar(resultado);
    }

    // Actualizar un resultado existente
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Resultado resultado) {
        if (id.equals(resultado.getId())) {
            resultadoService.guardar(resultado);
            return ResponseEntity.accepted().body("El resultado se ha actualizado correctamente");
        } else {
            return ResponseEntity.badRequest().body("El resultado no se ha podido actualizar, los id no coinciden o no existe");
        }
    }

    // Eliminar un torneo
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarResultado(@PathVariable Long id) {
        resultadoService.eliminar(id);
        return ResponseEntity.ok().body("El resultado ha sido eliminado correctamente");

    }




}
