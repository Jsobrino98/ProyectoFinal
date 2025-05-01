// Declaración del paquete en el que se encuentra esta clase
package AD.SistemaTorneosCompeticions.Security;

// Importaciones necesarias para el funcionamiento del controlador de autenticación
import AD.SistemaTorneosCompeticions.Models.Usuario;
import AD.SistemaTorneosCompeticions.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// Controlador REST que gestiona la autenticación de usuarios
@RestController
@RequestMapping("/auth") // Prefijo común para todas las rutas de este controlador
public class AuthController {

    // Inyección de dependencias: codificador de contraseñas
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Inyección de dependencias: clase utilitaria para generar tokens JWT
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    // Inyección de dependencias: servicio que maneja la lógica relacionada con usuarios
    @Autowired
    private UsuarioService usuarioService;

    /**
     * Endpoint para registrar un nuevo usuario.
     * @param user Objeto Usuario recibido en el cuerpo de la solicitud.
     * @return Mensaje de confirmación.
     */
    @PostMapping("/register")
    public String registerUser(@RequestBody Usuario user) {
        // Encriptar la contraseña antes de almacenarla
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Guardar el usuario en la base de datos mediante el servicio
        usuarioService.guardar(user);

        return "Usuario registrado exitosamente";
    }

    /**
     * Endpoint para iniciar sesión.
     * Valida las credenciales y retorna un token JWT si son correctas.
     * @param loginRequest Mapa con las claves "nombreUsuario" y "password".
     * @return ResponseEntity con token o error según el resultado.
     */
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> loginRequest) {
        // Obtener credenciales desde la solicitud
        String nombreUsuario = loginRequest.get("nombreUsuario");
        String password = loginRequest.get("password");

        // Buscar usuario por nombre de usuario
        Optional<Usuario> userOptional = usuarioService.findByUsername(nombreUsuario);

        // Verificar que el usuario exista y que la contraseña coincida
        if (userOptional.isPresent() && passwordEncoder.matches(password, userOptional.get().getPassword())) {
            // Generar token JWT si la autenticación es exitosa
            String token = jwtTokenUtil.generateToken(nombreUsuario);

            // Responder con mensaje de éxito y el token generado
            return ResponseEntity.ok(Map.of(
                    "message", "Login exitoso",
                    "token", token
            ));
        }

        // Responder con error si las credenciales no son válidas
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                Map.of("error", "Credenciales inválidas")
        );
    }
}
