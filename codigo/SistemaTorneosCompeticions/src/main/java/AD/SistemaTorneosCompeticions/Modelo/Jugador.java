package AD.SistemaTorneosCompeticions.Modelo;

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

    @Column
    private Long equipo_id;


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

    public Long getEquipo_id() {
        return equipo_id;
    }

    public void setEquipo_id(Long equipo_id) {
        this.equipo_id = equipo_id;
    }
}
