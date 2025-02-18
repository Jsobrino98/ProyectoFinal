package AD.SistemaTorneosCompeticions.Models;

import AD.SistemaTorneosCompeticions.Models.DTO.EquipoTorneoDTO;

import jakarta.persistence.*;

@Entity(name = "equipos")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "nombre")
    private String nombre;
    @Column (name = "ciudad")
    private String ciudad;
    @Column (name = "torneo_id",nullable = false)
    private Long torneo_id;
    @Column (name = "escudo_url")
    private String escudoURL;
    @Column(name = "competicion_secundaria_id")
    private Long competicionSecundaria_id;


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

    public String getEscudoURL() {
        return escudoURL;
    }

    public void setEscudoURL(String escudoURL) {
        this.escudoURL = escudoURL;
    }

    public Long getCompeticionSecundaria_id() {
        return competicionSecundaria_id;
    }

    public void setCompeticionSecundaria_id(Long competicionSecundaria_id) {
        this.competicionSecundaria_id = competicionSecundaria_id;
    }

}
