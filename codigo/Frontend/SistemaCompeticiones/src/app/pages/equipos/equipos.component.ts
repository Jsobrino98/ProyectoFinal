import { Component } from '@angular/core';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-equipos',
  standalone: false,
  templateUrl: './equipos.component.html',
  styleUrl: './equipos.component.css'
})
export class EquiposComponent {
  equipos: any[] = []; // Lista de equipos

  constructor(private equiposService: ApiService) {}

  ngOnInit(): void {
    this.equiposService.getEquipos().subscribe(
      (data) => {
        this.equipos = data;  // Almacena los datos de la respuesta en la variable
      },
      (error) => {
        console.error('Error al obtener equipos:', error);
      }
    );
  }
}
