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
  torneo: any;
  equipos: any[] = [];

  constructor(private route: ActivatedRoute, private apiService: ApiService) { }

  ngOnInit(): void {
    this.torneoId = Number(this.route.snapshot.paramMap.get('id'));
    this.apiService.getTorneo(this.torneoId).subscribe(torneo => {
      this.torneo = torneo;
    });
    this.apiService.getEquipos().subscribe(equipos => {
      this.equipos = equipos.filter((equipo: any) => equipo.torneo_id === this.torneoId);
    });
  }
}
