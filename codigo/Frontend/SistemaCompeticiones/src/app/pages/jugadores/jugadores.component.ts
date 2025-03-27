import { Component } from '@angular/core';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-jugadores',
  standalone: false,
  templateUrl: './jugadores.component.html',
  styleUrls: ['./jugadores.component.css']
})
export class JugadoresComponent {

  jugadores: any[] = [];

  ligas = [
    { id: 1, nombre: 'Premier League' },
    { id: 2, nombre: 'Championship' },
    { id: 3, nombre: 'Scottish Premiership' },
    { id: 4, nombre: 'Bundesliga' },
    { id: 5, nombre: 'Serie A' },
    { id: 6, nombre: 'Ligue 1' },
    { id: 7, nombre: 'LaLiga' },
    { id: 8, nombre: 'Superliga de Grecia' },
    { id: 9, nombre: 'Eredivisie' },
    { id: 10, nombre: 'Jupiler Pro League' },
    { id: 11, nombre: 'Süper Lig' },
    { id: 12, nombre: 'Superliga Danesa' },
    { id: 13, nombre: 'Primeira Liga' },
    { id: 14, nombre: 'MLS' },
    { id: 15, nombre: 'Allsvenskan' },
    { id: 16, nombre: 'Liga MX' },
    { id: 17, nombre: 'Brasileirão' },
    { id: 18, nombre: 'Liga Premier de Ucrania' },
    { id: 19, nombre: 'Liga Premier de Rusia' },
    { id: 20, nombre: 'A-League' },
    { id: 21, nombre: 'Eliteserien' },
    { id: 22, nombre: 'Liga Hypermotion' }
  ];

  constructor(private jugadoresService: ApiService) {}

  ngOnInit(): void {
    this.jugadoresService.getJugadores().subscribe(data => {
      this.jugadores = data;
      console.log(data);
    });
  }

  obtenerLiga(index: number): string {
    const ligaIndex = Math.floor(index / 10); // Calcula la liga para cada grupo de 10 jugadores
    return this.ligas[ligaIndex]?.nombre || ''; // Devuelve el nombre de la liga
  }
}
