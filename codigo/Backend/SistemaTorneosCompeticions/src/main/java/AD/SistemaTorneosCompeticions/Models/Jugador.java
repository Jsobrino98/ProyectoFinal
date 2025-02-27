package AD.SistemaTorneosCompeticions.Models;

import jakarta.persistence.*;

@Entity(name = "jugadores")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private int edad;

    @Column
    private String posicion;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;


    public Jugador() {
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    // Getter para acceder al escudo de equipo
    public String getEquipoEscudoURL() {
        return equipo != null ? equipo.getEscudoURL() : null;
    }
}
