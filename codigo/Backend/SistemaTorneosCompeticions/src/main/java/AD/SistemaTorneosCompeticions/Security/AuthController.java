package AD.SistemaTorneosCompeticions.Security;

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

    @RestController
    @RequestMapping("/auth")
    public class AuthController {

        @Autowired
        private PasswordEncoder passwordEncoder;
        @Autowired
        private JwtTokenUtil jwtTokenUtil;

        @Autowired
        private UsuarioService usuarioService;

        // Registro de usuario
        @PostMapping("/register")
        public String registerUser(@RequestBody Usuario user) {
            // Encriptar la contraseña antes de guardarla
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            // Guardar el usuario en la base de datos
            usuarioService.guardar(user);
            return "Usuario registrado exitosamente";
        }

        // Login de usuario
        @PostMapping("/login")
        public ResponseEntity<?> loginUser(@RequestBody Map<String, String> loginRequest) {
            String nombreUsuario = loginRequest.get("nombreUsuario");
            String password = loginRequest.get("password");

            Optional<Usuario> userOptional = usuarioService.findByUsername(nombreUsuario);

            if (userOptional.isPresent() && passwordEncoder.matches(password, userOptional.get().getPassword())) {
                String token = jwtTokenUtil.generateToken(nombreUsuario);
                return ResponseEntity.ok(Map.of("message", "Login exitoso", "token", token));
            }

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Credenciales inválidas"));
        }



    }
