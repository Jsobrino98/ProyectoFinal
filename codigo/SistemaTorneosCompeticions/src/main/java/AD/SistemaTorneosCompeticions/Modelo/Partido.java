package AD.SistemaTorneosCompeticions.Modelo;


import jakarta.persistence.*;

import java.sql.Date;

@Entity(name = "partidos")
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date fecha;

    @Column
    private Long equipo_local_id;

    @Column
    private Long equipo_visitante_id;

    @Column
    private Long torneo_id;

    public Partido() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getEquipo_local_id() {
        return equipo_local_id;
    }

    public void setEquipo_local_id(Long equipo_local_id) {
        this.equipo_local_id = equipo_local_id;
    }

    public Long getEquipo_visitante_id() {
        return equipo_visitante_id;
    }

    public void setEquipo_visitante_id(Long equipo_visitante_id) {
        this.equipo_visitante_id = equipo_visitante_id;
    }

    public Long getTorneo_id() {
        return torneo_id;
    }

    public void setTorneo_id(Long torneo_id) {
        this.torneo_id = torneo_id;
    }
}
