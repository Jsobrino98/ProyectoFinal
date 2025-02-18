package AD.SistemaTorneosCompeticions.Models.DTO;


public class UsuarioDTO {

    private String username;
    private String nombre;
    private String email;


    public UsuarioDTO() {
    }

    public UsuarioDTO(String nombreUsuario, String nombreCompleto, String email) {
        this.username = nombreUsuario;
        this.nombre = nombreCompleto;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
