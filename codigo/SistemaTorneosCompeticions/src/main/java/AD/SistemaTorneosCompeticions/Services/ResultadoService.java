package AD.SistemaTorneosCompeticions.Services;


import AD.SistemaTorneosCompeticions.Models.Resultado;
import AD.SistemaTorneosCompeticions.Repositories.ResultadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultadoService {

    @Autowired
    private ResultadoRepository resultadoRepository;

    public List<Resultado> obtenerTodos(){
        return resultadoRepository.findAll();
    }

    public Resultado obtener(Long id){
        return resultadoRepository.findById(id).orElse(null);
    }

    public Resultado guardar(Resultado resultado) {
        return resultadoRepository.save(resultado);
    }

    public void eliminar(Long id) {
        resultadoRepository.deleteById(id);
    }

}
