package AD.SistemaTorneosCompeticions.Models;

import jakarta.persistence.*;

    @Entity(name = "equipoTorneo")
    public class EquipoTorneo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "equipo_id")
        private Equipo equipo;

        @ManyToOne
        @JoinColumn(name = "torneo_id")
        private Torneo torneo;


        public EquipoTorneo() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Equipo getEquipo() {
            return equipo;
        }

        public void setEquipo(Equipo equipo) {
            this.equipo = equipo;
        }

        public Torneo getTorneo() {
            return torneo;
        }

        public void setTorneo(Torneo torneo) {
            this.torneo = torneo;
        }
    }
