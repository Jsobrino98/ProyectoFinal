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
            // Guardar el usuario en la base de datos
            usuarioService.guardar(user);
            return "Usuario registrado exitosamente";
        }

   /*     // Login de usuario
        @PostMapping("/login")
        public String loginUser(@RequestBody Usuario usuario) {
            Optional<Usuario> user = usuarioService.findByUsername(usuario.getNombreUsuario());
            if (user.isPresent() && passwordEncoder.matches(usuario.getPassword(), user.get().getPassword())) {
                String token = jwtTokenUtil.generateToken(user.get().getNombreUsuario());
                return "Login exitoso: " + token;
            } else {
                System.out.println("Contraseña ingresada: " + usuario.getPassword());
                System.out.println("Contraseña en BD: " + user.map(Usuario::getPassword).orElse("No encontrada"));
                return "Credenciales inválidas";
            }
        }
        public boolean verificarPassword(String rawPassword, String encodedPassword) {
            return passwordEncoder.matches(rawPassword, encodedPassword);
        }*/

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
