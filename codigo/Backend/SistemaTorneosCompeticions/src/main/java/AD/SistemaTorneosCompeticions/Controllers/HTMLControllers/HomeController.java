package AD.SistemaTorneosCompeticions.Controllers.HTMLControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }
    @GetMapping("/equipos")
    public String equipos(Model model) {
        return "equipos";
    }
    @GetMapping("/torneos")
    public String torneos(Model model) {
        return "torneos";
    }
}
