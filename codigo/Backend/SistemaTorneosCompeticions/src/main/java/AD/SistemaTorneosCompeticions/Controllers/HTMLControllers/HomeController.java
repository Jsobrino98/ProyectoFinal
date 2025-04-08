package AD.SistemaTorneosCompeticions.Controllers.HTMLControllers;

import AD.SistemaTorneosCompeticions.Models.*;
import AD.SistemaTorneosCompeticions.Models.DTO.UsuarioDTO;
import AD.SistemaTorneosCompeticions.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private EquipoService equipoService;
    @Autowired
    private TorneoService torneoService;
    @Autowired
    private JugadorService jugadorService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private BalonOroService balonOroService;

    private static final String claveAdministrador = "ADMIN123";  // A clave correcta para ADMIN




    @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/equipos")
    public String equipos(Model model) {
        try {
            List<Equipo> equipos = equipoService.obtenerTodos();  // Verifica que esto no cause excepciones
            model.addAttribute("equipos", equipos);
            return "equipos";  // Devuelve la vista "equipos.html"
        } catch (Exception e) {
            e.printStackTrace();  // Esto ayudará a ver el error en los logs
            model.addAttribute("error", "Hubo un problema al cargar los equipos: " + e.getMessage());
            return "error";  // Redirige a una página de error personalizada
        }
    }


    @GetMapping("/torneos")
    public String torneos(Model model) {
        try {
            List<Torneo> torneos = torneoService.listarTorneos();
            model.addAttribute("torneos", torneos);
            return "torneos";  // Devuelve la vista "torneos.html"
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Hubo un problema al cargar los torneos: " + e.getMessage());
            return "error";  // Redirige a una página de error personalizada
        }
    }

    @GetMapping("/jugadores")
    public String jugadores(Model model) {
        try {
            List<Jugador> jugadores = jugadorService.obtenerTodos();
            model.addAttribute("jugadores", jugadores);
            return "jugadores";  // Devuelve la vista "jugadores.html"
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Hubo un problema al cargar los jugadores: " + e.getMessage());
            return "error";  // Redirige a una página de error personalizada
        }
    }

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.listarTodosLosUsuarios();
        model.addAttribute("usuarios", usuarios);  // Asegúrate de que 'usuarios' es el nombre correcto en el modelo
        return "usuarios";  // Esto debe coincidir con tu vista 'usuarios.html'
    }


    // Mostrar el formulario de registro
    @GetMapping("/registro")
    public String registroForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    // Procesar el formulario de registro
    @PostMapping("/registro")
    public String registrarUsuario(@ModelAttribute("usuario") Usuario usuario,
                                   @RequestParam(value = "claveAdmin", required = false) String claveAdmin,
                                   Model model) {
        try {
            System.out.println("Rol recibido: " + usuario.getRol());
            System.out.println("Clave recibida: " + claveAdmin);

            // Verifica que se é un administrador e se a clave coincide
            if ("ADMIN".equals(usuario.getRol())) {
                if (claveAdmin == null || !claveAdmin.equals("ADMIN123")) {
                    System.out.println("Clave incorrecta. Usuario NON se garda.");
                    model.addAttribute("error", "Clave de administrador incorrecta.");
                    return "registro";
                }
            }
            System.out.println("Usuario gárdase con rol: " + usuario.getRol());
            usuarioService.guardar(usuario);

            return "redirect:/home";  // Redirixe á páxina de inicio tras o rexistro exitoso
        } catch (Exception e) {
            model.addAttribute("error", "Houbo un erro ao rexistrar o usuario. Intenta de novo.");
            return "registro";  // Se hai erro, redirixe á páxina de rexistro
        }
    }



    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("usuario", new Usuario()); // Crea un objeto vacío para el formulario
        return "login"; // Devuelve la vista Thymeleaf "login.html"
    }
    // Mostrar todos los Balones de Oro en la vista Thymeleaf
    @GetMapping("/balon_oro")
    public String mostrarBalones(Model model) {
        List<BalonOro> balonesDeOro = balonOroService.obtenerTodos();
        model.addAttribute("balones", balonesDeOro);
        return "balonOro";  // Aquí "balonOro" es el nombre de la vista Thymeleaf (balonOro.html)
    }

}
