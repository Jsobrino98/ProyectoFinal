package AD.SistemaTorneosCompeticions.Models.DTO;

public class EquipoDTO {

    private Long id;
    private String nombre;


    public EquipoDTO() {
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
}
