package AD.SistemaTorneosCompeticions.Models.DTO;

import java.util.List;

public class TorneoDTO {

    private Long id;
    private String nombre;
    private List<EquipoDTO> equipos;

    public TorneoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<EquipoDTO> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<EquipoDTO> equipos) {
        this.equipos = equipos;
    }
}
