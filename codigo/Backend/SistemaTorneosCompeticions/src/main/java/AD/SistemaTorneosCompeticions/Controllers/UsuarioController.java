package AD.SistemaTorneosCompeticions.Controllers;

import AD.SistemaTorneosCompeticions.Models.DTO.UsuarioDTO;
import AD.SistemaTorneosCompeticions.Models.Torneo;
import AD.SistemaTorneosCompeticions.Models.Usuario;
import AD.SistemaTorneosCompeticions.Security.JwtTokenUtil;
import AD.SistemaTorneosCompeticions.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    // Buscar usuario por username o email
    public Usuario buscarUsuario(@RequestParam String usernameOrEmail) {
        return usuarioService.findByUsernameOrEmail(usernameOrEmail);
    }
    // Obtener todos los usuario
    @GetMapping
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }
    // Obtener usuario por ID
    @GetMapping("/{id}")
    public Usuario obtenerUsuario(@PathVariable Long id) {
        return usuarioService.obtener(id);
    }


    // Actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        if (id.equals(usuario.getId())) {
            usuarioService.guardar(usuario);
            return ResponseEntity.accepted().body("El usuario se ha actualizado correctamente");
        } else {
            return ResponseEntity.badRequest().body("El usuario no se ha podido actualizar, los id no coinciden o no existe");
        }
    }

    // Eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarUsuario(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return ResponseEntity.ok().body("El usuario ha sido eliminado correctamente");
    }


    // Listar todos los usuarios
    public List<Usuario> listarUsuariosTodo() {
        return usuarioService.listarTodosLosUsuarios();
    }

}
