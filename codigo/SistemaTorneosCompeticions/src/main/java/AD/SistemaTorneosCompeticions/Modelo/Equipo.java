package AD.SistemaTorneosCompeticions.Modelo;

import jakarta.persistence.*;

@Entity(name = "equipos")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String ciudad;
    @Column
    private Long torneo_id;


    public Equipo() {
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Long getTorneo_id() {
        return torneo_id;
    }

    public void setTorneo_id(Long torneo_id) {
        this.torneo_id = torneo_id;
    }
}
