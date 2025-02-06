package AD.SistemaTorneosCompeticions.Models;

import jakarta.persistence.*;

@Entity(name = "resultados")
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long partido_id;

    @Column
    private int goles_local;

    @Column
    private int goles_visitante;


    public Resultado() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPartido_id() {
        return partido_id;
    }

    public void setPartido_id(Long partido_id) {
        this.partido_id = partido_id;
    }

    public int getGoles_local() {
        return goles_local;
    }

    public void setGoles_local(int goles_local) {
        this.goles_local = goles_local;
    }

    public int getGoles_visitante() {
        return goles_visitante;
    }

    public void setGoles_visitante(int goles_visitante) {
        this.goles_visitante = goles_visitante;
    }
}
