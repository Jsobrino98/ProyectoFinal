package AD.SistemaTorneosCompeticions.Models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity(name = "torneos")
public class Torneo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private Date fecha_inicio;

    @Column
    private Date fecha_fin;

    @Column
    private String ubicacion;

    private String logoCompeticion;

    @OneToMany(mappedBy = "torneo")
    private List<EquipoTorneo> equiposTorneo;


    public Torneo() {
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

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getLogoCompeticion() {
        return logoCompeticion;
    }

    public void setLogoCompeticion(String logoCompeticion) {
        this.logoCompeticion = logoCompeticion;
    }

    public List<EquipoTorneo> getEquiposTorneo() {
        return equiposTorneo;
    }

    public void setEquiposTorneo(List<EquipoTorneo> equiposTorneo) {
        this.equiposTorneo = equiposTorneo;
    }
}
