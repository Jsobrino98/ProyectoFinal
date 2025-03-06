import { Component } from '@angular/core';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-jugadores',
  standalone: false,
  templateUrl: './jugadores.component.html',
  styleUrl: './jugadores.component.css'
})
export class JugadoresComponent {

  jugadores: any[] = [];
  
  constructor(private jugadoresService: ApiService) {}

  ngOnInit(): void {
    this.jugadoresService.getJugadores().subscribe(data => {this.jugadores = data; console.log(data)});
    console.log("traballando en jugadores");
  }
}
