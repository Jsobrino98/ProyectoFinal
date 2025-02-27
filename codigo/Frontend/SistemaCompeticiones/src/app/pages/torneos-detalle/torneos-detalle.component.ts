import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-torneos-detalle',
  standalone: false,
  templateUrl: './torneos-detalle.component.html',
  styleUrl: './torneos-detalle.component.css'
})
export class TorneosDetalleComponent implements OnInit {

  torneoId!: number;
  equipos: any[] = [];

  constructor(private route: ActivatedRoute, private apiService: ApiService) {}

  ngOnInit() {
    // Obtener el ID del torneo desde la URL
    this.torneoId = Number(this.route.snapshot.paramMap.get('id'));

    // Obtener los equipos y filtrarlos
    this.apiService.getEquipos().subscribe((equipos) => {
      this.equipos = equipos.filter((equipo: { torneo_id: number; }) => equipo.torneo_id === this.torneoId);
    });
  }
}
