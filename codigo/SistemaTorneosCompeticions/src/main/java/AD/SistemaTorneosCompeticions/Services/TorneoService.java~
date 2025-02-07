package AD.SistemaTorneosCompeticions.Services;

import AD.SistemaTorneosCompeticions.Models.Torneo;
import AD.SistemaTorneosCompeticions.Repositories.TorneoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class TorneoService {

    @Autowired
    private TorneoRepository torneoRepository;


    // Método para obtener un torneo por ID
    public Torneo obtener(long id) {
        return torneoRepository.findById(id).orElse(null);
    }


    // Método para eliminar un torneo
    public void eliminar(long id) {
        torneoRepository.deleteById(id);
    }

    // Método para listar todos los torneos
    public List<Torneo> listarTorneos() {
        return torneoRepository.findAll();
    }

}
