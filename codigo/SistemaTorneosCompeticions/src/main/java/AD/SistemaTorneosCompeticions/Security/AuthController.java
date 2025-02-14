package AD.SistemaTorneosCompeticions.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String usuario, @RequestParam String clave) {

        // Validar el usuario

        if ("usuario".equals(usuario) && "123456".equals(clave)) {
            String token = jwtTokenUtil.generateToken(usuario);
            return ResponseEntity.ok().body(token);
        }

        return ResponseEntity.status(401).body("Usuario incorrecto");
    }
}
