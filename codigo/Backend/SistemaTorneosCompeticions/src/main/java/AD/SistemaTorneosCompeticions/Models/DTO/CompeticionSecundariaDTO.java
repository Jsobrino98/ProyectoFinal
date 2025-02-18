package AD.SistemaTorneosCompeticions.Models.DTO;

import java.util.List;

public class CompeticionSecundariaDTO {
    private Long id;

    private String nombreTorneo;
    private List<TorneoDTO> torneos;

    public CompeticionSecundariaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public List<TorneoDTO> getTorneos() {
        return torneos;
    }

    public void setTorneos(List<TorneoDTO> torneos) {
        this.torneos = torneos;
    }
}
