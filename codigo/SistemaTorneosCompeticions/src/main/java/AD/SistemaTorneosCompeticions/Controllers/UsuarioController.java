package AD.SistemaTorneosCompeticions.Controllers;

import AD.SistemaTorneosCompeticions.Models.Usuario;
import AD.SistemaTorneosCompeticions.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Registro de usuario
    @PostMapping("/register")
    public String registerUser(@RequestBody Usuario user) {
        // Guardar el usuario en la base de datos
        usuarioService.guardar(user);
        return "Usuario registrado exitosamente";
    }

    // Login de usuario
    @PostMapping("/login")
    public String loginUser(@RequestBody Usuario usuario) {
        // Verificar si el usuario existe y si la contraseña es correcta
        Optional<Usuario> user = usuarioService.buscarPorUsername(usuario.getNombreUsuario());
        if (user.isPresent() && user.get().getPassword().equals(usuario.getPassword())) {
            return "Login exitoso";
        } else {
            return "Credenciales inválidas";
        }
    }

}
