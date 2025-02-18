package AD.SistemaTorneosCompeticions.Models.DTO;



public class EquipoTorneoDTO {

    private String nombreEquipo;    // Nombre del equipo
    private String nombreTorneo;    // Nombre del torneo


    public EquipoTorneoDTO(String nombreEquipo, String nombreTorneo) {
        this.nombreEquipo = nombreEquipo;
        this.nombreTorneo = nombreTorneo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }
}

